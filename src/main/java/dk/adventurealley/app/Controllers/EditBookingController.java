package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

@Controller
public class EditBookingController {

    ArrayList<Requirement> requirements = new ArrayList<>();
    LocalDateTime localDateTime = LocalDateTime.of(1923, Month.JULY, 20, 10, 24);
    ArrayList<Activity> activities = new ArrayList<>();

    @GetMapping("/editBooking")
    public String editBooking(Model model){
        activities.clear();
        requirements.clear();
        requirements.add(new Requirement("Min. højde"));
        requirements.add(new Requirement("Vægt"));
        activities.add(new Activity("Tennis", requirements, "equipment pasdfdng", "image sdafhg", "description osadgn"));
        activities.add(new Activity("Gokart", requirements, "Equipment oidasfng", "http:wwww.google.dk", "description er godt"));
        activities.add(new Activity("Mini golf", requirements, "equipment pasdfdng", "image sdafhg", "description osadgn"));
        model.addAttribute("newActivity", new Activity());
        model.addAttribute("activities", activities);
        model.addAttribute("booking", new Booking(null,
                new Activity("Gokart", requirements, "Equipment oidasfng", "http:wwww.google.dk", "description er godt"),
                new Customer(null, "kunde navn juhu", "11223344"), localDateTime, "description yolo", 40));
        System.out.println(localDateTime);
        return "editBooking";
    }

    @PostMapping("/editBooking")
    public String editBooking(@RequestParam("action") String action, @ModelAttribute Booking booking){
        System.out.println(booking);
        return "editBooking";
    }
}
