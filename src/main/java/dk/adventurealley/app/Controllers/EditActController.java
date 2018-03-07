package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class EditActController {

    @Autowired
    ActivityRepository aR = new ActivityRepository();

    @GetMapping ("/editActivity")
    public String editActivity(Model model){

        model.addAttribute("requirement", new Requirement());
        Activity activity = aR.read("GokartTest");
        model.addAttribute("requirements", activity.getRegList());
        model.addAttribute("activity", activity);
        return "editActivity";
    }
}
