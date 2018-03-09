package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.ActivityRequirementsRepo;
import dk.adventurealley.app.DAO.RequirementRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {


    @Autowired
    ActivityRepository aR = new ActivityRepository();
    @Autowired
    RequirementRepository rR = new RequirementRepository();
    @Autowired
    ActivityRequirementsRepo aRR = new ActivityRequirementsRepo();

    ArrayList<Activity> activities = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model){
        activities = aR.readAll();
        model.addAttribute("activities", activities);
        return "index";
    }

    @GetMapping("/activityPage")
    public String activityPage(@RequestParam("id") String id, Model model){
        Activity temp = aR.read(activities.get(Integer.parseInt(id)).getName());
        model.addAttribute("activity", temp);
        return "activityPage";
    }

    @GetMapping("/deleteActivity")
    public String deleteAcitivity(String name){
        aR.deleteActivity(name);
        return "redirect:/";
    }

    @GetMapping ("/editActivity")
    public String editActivity(@RequestParam("name") String name, Model model){

        model.addAttribute("newReq", new Requirement());
        model.addAttribute("requirements", rR.readAll());
        model.addAttribute("activity", aR.read(name));
        return "editActivity";
    }

    @PostMapping ("/editActivity")
    public String editActivity(@RequestParam("action") String action, @ModelAttribute Activity activity, @ModelAttribute Requirement newReq, Model model){
        System.out.println(action);
        ArrayList<String> reqNames = new ArrayList<>();
        if(activity.getReqList() != null) {
            for (Requirement requirement : activity.getReqList()) {
                reqNames.add(requirement.getReqName());
            }
        }
        if (!newReq.getReqName().equals(null) && !reqNames.contains(newReq.getReqName()) && action.equals("Tilføj krav")) {
            System.out.println(1);
            if(activity.getReqList() == null){
                activity.setReqList(new ArrayList<Requirement>());
                activity.getReqList().add(newReq);
            }
            else {
                activity.getReqList().add(newReq);
            }
            model.addAttribute("requirements", rR.readAll());
            model.addAttribute("newReq", new Requirement());
            model.addAttribute("activity", activity);
            return "editActivity";

        }
        else if (action.equals("Gem Ændringer")){
            System.out.println(2);

            aR.update(activity);
        }
        model.addAttribute("activity", activity);

        return "activityPage";
    }
}
