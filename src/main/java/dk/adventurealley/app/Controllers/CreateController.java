package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CreateController {

    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Requirements> requirements  = new ArrayList<>();
    ArrayList<Requirements> activeReqs = new ArrayList<>();
    Requirements r1 = new Requirements("Age", "");
    Requirements r2 = new Requirements("Weight", "");

    @Autowired
    ActivityRepository activityRepo = new ActivityRepository();

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/createActivity", method = RequestMethod.GET)
    public String createActivity(Model model) {
        requirements.add(r1);
        requirements.add(r2);
        Activity a = new Activity();
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/addReq")
    public String addRequirement(@ModelAttribute Activity a, Model model, @RequestParam String reqname, @RequestParam String value) {
        Requirements r = new Requirements(reqname, value);
        activeReqs.add(r);
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/createA")
    public String activityCreate(@ModelAttribute Activity a) {
        a.setActivityReq(activeReqs);
        //activityRepo.create(a);
        System.out.println("Tilføjet activity: " + a.toString());
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
