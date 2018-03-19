package dk.adventurealley.app.Model.Entities;

import dk.adventurealley.app.DAO.BookingRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Ejer on 19-03-2018.
 */
public class SalesCart {
    private ArrayList<SaleItem> list;

    public SalesCart() {
        list = new ArrayList<>();
    }
    public Sale makeSale(){
        double sum = 0;
        for(SaleItem saleItem: list){
            sum = sum + saleItem.getTotal();
        }
        LocalDate localDate = LocalDate.now();
        return new Sale(localDate,sum);
    }
    public void addProductToCart(Product product){
        boolean containsProduct = false;
        for(SaleItem saleItem: list){
            if(saleItem.getProduct().getId() == product.getId()){
                saleItem.countOneUp();
                containsProduct = true;
            }
        }
        if(containsProduct == false){
            list.add(new SaleItem(product));
        }
    }

    public ArrayList<SaleItem> getList() {
        return list;
    }

    public void setList(ArrayList<SaleItem> list) {
        this.list = list;
    }
    public void removeProduct(Product product){
        boolean delete = false;
        SaleItem itemToRemove = null;
        for(SaleItem saleItem : list){
            if(saleItem.getProduct().getId() == product.getId()){
                if(saleItem.getAmount() > 1){
                    saleItem.countOneDown();
                }
                else {
                   itemToRemove = saleItem;
                   break;
                }
            }
        }
        if(itemToRemove != null){
            list.remove(itemToRemove);
        }
    }
    public int cartSize(){
        return list.size();
    }

    @Override
    public String toString() {
        return "SalesCart{" +
                "list=" + list +
                '}';
    }

}
