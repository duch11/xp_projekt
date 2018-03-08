package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.RequirementRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CreateController {

    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Requirement> requirements  = new ArrayList<>();
    ArrayList<Requirement> activeReqs = new ArrayList<>();

    @Autowired
    ActivityRepository activityRepo = new ActivityRepository();

    @Autowired
    RequirementRepository requireRepo = new RequirementRepository();

    @RequestMapping(value = "/createactivity", method = RequestMethod.GET)
    public String createActivity(Model model) {
        requirements = requireRepo.readAll();
        Activity a = new Activity();
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/addReq")
    public String addRequirement(@ModelAttribute Activity a, Model model, @RequestParam String name, @RequestParam String value) {
        Requirement r = new Requirement(name, value);
        activeReqs.add(r);
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/createA")
    public String activityCreate(@ModelAttribute Activity a) {
        a.setReqList(activeReqs);
        activityRepo.create(a);
        activeReqs.clear();
        return "redirect:/";
    }
    
}
