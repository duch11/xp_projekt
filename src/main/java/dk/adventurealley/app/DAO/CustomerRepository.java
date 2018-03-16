package dk.adventurealley.app.DAO;


import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Customer read(int customerID){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customers WHERE id ='"+ customerID +"'");

        if (rs.next()){
            return new Customer(rs.getInt("id"), rs.getString("companyName"), rs.getString("name"), rs.getString("phone"));
        }
        return null;
    }

    public void update(Customer customer){
        jdbc.update("UPDATE customers SET name ='"+ customer.getCustomerName() +"', " +
                "companyName ='"+ customer.getCompanyName() +"', " +
                "phone ='"+ customer.getPhone() +"' WHERE id ='"+ customer.getId() +"'");
    }
}
