package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CreateController {

    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Requirement> requirements  = new ArrayList<>();

    @GetMapping("/createactivity")
    public String createActivity(Model model) {
        model.addAttribute("activity", new Activity());
        model.addAttribute("req", new Requirement());
        return "createActivity";
    }

    @PostMapping("/createA")
    public String activityCreate(@ModelAttribute Activity activity, Requirement requirement) {
        System.out.println("Tilføjet activity: " + activity.getName());
        System.out.println("Tilføjet krav: " + requirement.toString());
        return "index";
    }
}