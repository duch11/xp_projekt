package dk.adventurealley.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateRequirementController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCreateReqView(Model model){

        return "createRequirement";
    }

    @RequestMapping(value = "/createrequirement", method = RequestMethod.POST)
    public String createRequirement(Model model, @ModelAttribute String name, @ModelAttribute String value){
        System.out.println("værdi:" + name + " " + value);
        return "createRequirement";
    }
}
