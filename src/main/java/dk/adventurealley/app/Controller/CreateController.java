package dk.adventurealley.app.Controller;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirements;
import dk.adventurealley.app.Model.Services.ActivityRepository;
import dk.adventurealley.app.Model.Services.Interfaces.IActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CreateController {

    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Requirements> requirements  = new ArrayList<>();
    Requirements r1 = new Requirements("Age", "");
    Requirements r2 = new Requirements("Weight", "");

    @Autowired
    IActivity activityRepo = new ActivityRepository();

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/createActivity", method = RequestMethod.GET)
    public String createActivity(Model model) {
        requirements.add(r1);
        requirements.add(r2);
        model.addAttribute("activity", new Activity());
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/createA")
    public String activityCreate(@ModelAttribute Activity activity) {
        //activityRepo.create(activity);
        System.out.println("Tilføjet activity: " + activity.getName());
        return "index";
    }

    @GetMapping("/createRequirement")
    public String createRequirement(Model model) {
        model.addAttribute("activity", new Requirements());
        return "createRequirement";
    }

    @PostMapping("/createReq")
    public String requirementCreate(@ModelAttribute Requirements req, Model model) {
        requirements.add(req);
        model.addAttribute("activity", new Activity());
        model.addAttribute("req", requirements);
        return "createActivity";
    }
}
