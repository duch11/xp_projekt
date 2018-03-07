package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.RequirementRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class EditActController {

    @Autowired
    ActivityRepository aR = new ActivityRepository();
    @Autowired
    RequirementRepository rR = new RequirementRepository();

    @GetMapping ("/editActivity")
    public String editActivity(Model model){
        Activity activity = aR.read("GokartTest");
        System.out.println(rR.readAll());
        model.addAttribute("newReq", new Requirement());
        model.addAttribute("requirements", rR.readAll());
        model.addAttribute("activity", activity);
        return "editActivity";
    }

    @PostMapping ("/editActivity")
    public String editActivity(@ModelAttribute Activity activity, @ModelAttribute Requirement newReq, Model model){
        System.out.println(newReq);
        if(newReq.getName() != null){
            activity.getRegList().add(newReq);
        }
        System.out.println(activity);
        aR.update(activity);
        model.addAttribute("requirements", rR.readAll());
        model.addAttribute("activity", aR.read(activity.getName()));
        return "editActivity";
    }
}
