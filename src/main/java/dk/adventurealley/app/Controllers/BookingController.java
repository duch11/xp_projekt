package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.BookingCreateRepository;
import dk.adventurealley.app.DAO.InstructorRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import dk.adventurealley.app.Model.Entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BookingController {

    @Autowired
    BookingCreateRepository bookRepo = new BookingCreateRepository();

    @Autowired
    ActivityRepository actiRepo = new ActivityRepository();

    @Autowired
    InstructorRepository intRepo = new InstructorRepository();


    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Instructor> instructors = new ArrayList<>();

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String createBooking(Model model) {
        activities = actiRepo.readAll();
        instructors = intRepo.readAll();
        model.addAttribute("book", new Booking());
        model.addAttribute("cust", new Customer());
        model.addAttribute("acti", new Activity());
        model.addAttribute("ilist", instructors);
        model.addAttribute("alist", activities);
        return "booking";
    }

    @PostMapping("/createB")
    public String bookingCreate(@ModelAttribute Booking b, Customer c, Activity a, @RequestParam String intName, @RequestParam String actiName) {
        System.out.println("Tilføjet Booking: " + b.toString());
        System.out.println("Tilføjet Kunde: " + c.toString());
        System.out.println("Tilføjet Aktivitet: " + a.getName());
        bookRepo.create(b, c);
        return "redirect:/";
    }



}