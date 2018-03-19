package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.BookingRepository;
import dk.adventurealley.app.DAO.CustomerRepository;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ViewBookingController {

    @Autowired
    ActivityRepository activityRepository = new ActivityRepository();
    @Autowired
    BookingRepository bookingRepository = new BookingRepository();
    @Autowired
    CustomerRepository customerRepository = new CustomerRepository();

    ArrayList<Booking> bookingArray = new ArrayList<>();

    @GetMapping("/viewBooking")
    public String viewBooking(Model model){
        bookingArray = bookingRepository.readAll();
        model.addAttribute("searchBooking", new Booking());
        model.addAttribute("booking", bookingArray);
        model.addAttribute("isbookingpage", true);
        return "viewBooking";
    }

    @GetMapping("/deleteBooking")
    public String deleteBooking(@RequestParam("id") Integer id){
        bookingRepository.deleteBooking(id);
        return "redirect:/viewBooking";
    }

    @PostMapping("/viewBooking")
    public String searchBooking(@RequestParam (value = "da", required = false)  String da, @ModelAttribute Booking searchBooking, Model model){
        ArrayList<Booking> searchedBookings = new ArrayList<>();
        model.addAttribute("isbookingpage", true);
        model.addAttribute("searchBooking", new Booking());

        for (Booking b : bookingArray) {
            if (b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase()) &&
                    b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase()) &&
                    b.getDate().toLocalDate().toString().equals(da)){
                searchedBookings.add(b);
            }
            else if (da.isEmpty() && searchBooking.getCustomer().getCustomerName().isEmpty()){
                if (b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase())){
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getActivity().getName().isEmpty() && searchBooking.getCustomer().getCustomerName().isEmpty()){
                if (b.getDate().toLocalDate().toString().equals(da)){
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getActivity().getName().isEmpty() && da.isEmpty()){
                if (b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase())){
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getActivity().getName().isEmpty()){
                if (b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase()) && b.getDate().toLocalDate().toString().equals(da)) {
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getCustomer().getCustomerName().isEmpty()){
                if (b.getDate().toLocalDate().toString().equals(da) && b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase())) {
                    searchedBookings.add(b);
                }
            }
            else if (da.isEmpty()){
                if (b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase()) && b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase())) {
                    searchedBookings.add(b);
                }
            }
        }
        model.addAttribute("booking", searchedBookings);
        return "viewBooking";
    }
}
