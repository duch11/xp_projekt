package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.BookingCreateRepository;
import dk.adventurealley.app.DAO.InstructorRepository;
import dk.adventurealley.app.DAO.ProductRepository;
import dk.adventurealley.app.Model.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class SalesPageController {
    private SalesCart salesCart = new SalesCart();

    @Autowired
    public ProductRepository productRepository;

    @RequestMapping(value = "/salesPage", method = RequestMethod.GET)
    public String showSalesPage(Model model) {
        model.addAttribute("salesCartList", salesCart.getList());
        model.addAttribute("totalPrice", salesCart.calculateTotal());
        model.addAttribute("productList", productRepository.readAll());
        return "salesPage";
    }

    @PostMapping("/addProduct")
    public String addProductToCart(@ModelAttribute Product product, Model model){
        salesCart.addProductToCart(product);

        return "redirect:/salesPage";
    }

    @PostMapping("/removeProduct")
    public String removeProductFromCart(@ModelAttribute Product product, Model model){
        salesCart.removeProduct(product);
        return "redirect:/salesPage";
    }

    @PostMapping("/checkout")
    public String completeSale(){
        System.out.println(salesCart.makeSale());
        return "redirect:/salesPage";
    }
}