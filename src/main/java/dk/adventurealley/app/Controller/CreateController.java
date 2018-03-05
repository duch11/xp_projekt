package dk.adventurealley.app.Controller;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirements;
import dk.adventurealley.app.Model.Services.ActivityRepository;
import dk.adventurealley.app.Model.Services.Interfaces.IActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class CreateController {

    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Requirements> requirements  = new ArrayList<>();

    @Autowired
    IActivity activityRepo = new ActivityRepository();

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/createActivity", method = RequestMethod.GET)
    public String createActivity(Model model, Model model1) {
        model.addAttribute("activity", new Activity());
        model1.addAttribute("req", new Requirements());
        return "createActivity";
    }

    @PostMapping("/createA")
    public String activityCreate(@ModelAttribute Activity activity, Requirements requirement) {
        activityRepo.create(activity);
        System.out.println("Tilføjet activity: " + activity.getName());
        System.out.println("Tilføjet krav: " + requirement.toString());
        return "index";
    }
}
