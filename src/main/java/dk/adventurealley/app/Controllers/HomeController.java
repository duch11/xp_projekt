package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    ActivityRepository activityRepo = new ActivityRepository();
    ArrayList<Activity> activities = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model){
        activities = activityRepo.readAll();
        model.addAttribute("activities", activities);
        return "index";
    }

    @GetMapping("/activityPage")
    public String activityPage(@RequestParam("id") String id, Model model){
        Activity temp = activityRepo.read(activities.get(Integer.parseInt(id)).getName());
        model.addAttribute("activity", temp);
        model.addAttribute("reqList", temp.getReqList());
        return "activityPage";
    }
    /*
    @PostMapping("/activityPage")
    public String deleteAcitivity(String name){
        activityRepo.deleteActivity(name);
        return "index";
    }*/
}
