package dk.adventurealley.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateRequirementController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String createActivity(Model model){

    return "createRequirement";
  }

}
