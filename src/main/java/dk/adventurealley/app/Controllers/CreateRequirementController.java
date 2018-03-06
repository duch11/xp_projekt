package dk.adventurealley.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateRequirementController {

    @RequestMapping(value = "/createrequirement", method = RequestMethod.GET)
    public String showCreateReqView(Model model){

        return "createRequirement";
    }

    @RequestMapping(value = "/createrequirement", method = RequestMethod.POST)
    public String createRequirement(Model model, @RequestParam String name){
        System.out.println("værdi:" + name);
        return "createRequirement";
    }
}
