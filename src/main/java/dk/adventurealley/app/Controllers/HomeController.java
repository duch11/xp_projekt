package dk.adventurealley.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    //ArrayList<Activity> activities = activityRepo.getActivityList();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("activities", activities);
        return "index";
    }

}
