package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.BookingCreateRepository;
import dk.adventurealley.app.DAO.InstructorRepository;
import dk.adventurealley.app.Model.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class SalesPageController {
    private SalesCart salesCart = new SalesCart();

    @RequestMapping(value = "/salesPage", method = RequestMethod.GET)
    public String showSalesPage(Model model) {
        return "salesPage";
    }

    @PostMapping("/salePage")
    public String salesPage(@ModelAttribute Product product, Model model){
        salesCart.addProductToCart(product);
        
        return "salesPage";
    }
}