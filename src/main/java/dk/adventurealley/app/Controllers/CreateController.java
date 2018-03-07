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

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/createActivity", method = RequestMethod.GET)
    public String createActivity(Model model) {
        requirements = requireRepo.readAll();
        Activity a = new Activity();
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/addReq")
    public String addRequirement(@ModelAttribute Activity a, Model model, @RequestParam String reqname, @RequestParam String value) {
        Requirement r = new Requirement(reqname, value);
        activeReqs.add(r);
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }

    @PostMapping("/createA")
    public String activityCreate(@ModelAttribute Activity a) {
        a.setActivityReq(activeReqs);
        activityRepo.create(a);
        activeReqs.clear();
        return "index";
    }

    @GetMapping("/createRequirement")
    public String createRequirement(Model model) {
        model.addAttribute("activity", new Requirement());
        return "createRequirement";
    }

    @PostMapping("/createReq")
    public String requirementCreate(@ModelAttribute Requirement req, Model model) {
        requirements.add(req);
        model.addAttribute("activity", new Activity());
        model.addAttribute("req", requirements);
        return "createActivity";
    }
}
