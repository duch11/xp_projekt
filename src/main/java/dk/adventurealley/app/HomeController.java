package dk.adventurealley.app;

import dk.adventurealley.app.models.Activity;
import dk.adventurealley.app.models.Requirement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<Requirement> requirements = new ArrayList<>();

    @GetMapping ("/editActivity")
    public String editActivity(Model model){
        if(requirements.isEmpty()) {
            Requirement s1 = new Requirement("højde", "200");
            Requirement s2 = new Requirement("højd", "2");
            Requirement s3 = new Requirement("høj", "257");
            Requirement s4 = new Requirement("hø", "202350");
            Requirement s5 = new Requirement("h", "2023450");
            requirements.add(s1);
            requirements.add(s2);
            requirements.add(s3);
            requirements.add(s4);
            requirements.add(s5);
        }
        model.addAttribute("requirement", new Requirement());
        Activity activity = new Activity("Gokart", requirements, "Hjelm", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFqnVyooVfj3rVcljhdOQSRgcxrowe0GUQJli12phkLzTuh5nL", "haleluja");
        model.addAttribute("requirements", activity.getRequirements());
        model.addAttribute("activity", activity);
        return "editActivity";
    }
}
