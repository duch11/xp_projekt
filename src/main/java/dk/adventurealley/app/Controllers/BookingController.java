package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.Model.Entities.Activity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String createBooking(Model model) {
        return "booking";
    }

}


    /*@RequestMapping(value = "/createactivity", method = RequestMethod.GET)
    public String createActivity(Model model) {
        requirements = requireRepo.readAll();
        Activity a = new Activity();
        model.addAttribute("activity", a);
        model.addAttribute("req", requirements);
        return "createActivity";
    }*/
