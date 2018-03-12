package dk.adventurealley.app.Controllers;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class BookingController {

    private Activity golfactivity = new Activity("Minigolf","/");
    private Customer costumer = new Customer(1, "Mærsk","Hassan Jensen", "+33 41 41 22 11");
    private LocalDateTime localDateTime = LocalDateTime.of(2018, 3, 12, 12, 20, 0);
    private Booking booking = new Booking(1, golfactivity, costumer, localDateTime.toLocalDate(), "Firmafrokost", 12);

    @GetMapping("/booking")
    public String showBookingDetails(@RequestParam int id, Model model){
        model.addAttribute("booking", booking);
        model.addAttribute("customer", booking.getCustomer());
        model.addAttribute("activity", golfactivity);
        return "bookingDetails";
    }
}
