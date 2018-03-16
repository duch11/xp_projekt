package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCreateRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Double fixComma(String price){
        price.replaceAll(",",".");
        return Double.parseDouble(price);
    }

    public void create(Product p) {

        jdbc.update("INSERT INTO adventure_alley_db.products(name, price, imagePath)" + "VALUES ('" + p.getName() + "', '" + p.getPrice() + "', '" + p.getProductImagePath() + "')");
    }
}
