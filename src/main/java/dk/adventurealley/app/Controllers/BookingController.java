package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.BookingCreateRepository;
import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    BookingCreateRepository bookRepo = new BookingCreateRepository();

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String createBooking(Model model) {
        model.addAttribute("book", new Booking());
        model.addAttribute("cust", new Customer());
        model.addAttribute("acti", new Activity());
        return "booking";
    }

    @PostMapping("/createB")
    public String bookingCreate(@ModelAttribute Booking b, Customer c, Activity a, @RequestParam String InstructorID) {
        System.out.println("Tilføjet Booking: " + b.toString());
        System.out.println("Tilføjet Kunde: " + c.toString());
        System.out.println("Tilføjet Aktivitet: " + a.getName());
        System.out.println("Tilføjet Instructor ID: " + InstructorID);
        bookRepo.create(b, c, InstructorID);
        return "redirect:/";
    }

}