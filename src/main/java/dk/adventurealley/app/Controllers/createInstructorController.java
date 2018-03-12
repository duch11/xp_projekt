package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.DAO.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class createInstructorController {

    @Autowired
    InstructorRepository intstructorRepo = new InstructorRepository();

    @GetMapping
    public String showCreateInstructor(){
        return "createInstructor";
    }

    @PostMapping ("/createInstructor")
    public String createInstructor(@RequestParam String name){
        intstructorRepo.createInstructor(name);
        return "createInstructor";
    }
}
