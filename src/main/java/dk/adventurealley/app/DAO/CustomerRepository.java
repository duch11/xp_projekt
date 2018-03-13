package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Customer read(String customerId){
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM customer WHERE id =" + customerId);
        return new Customer(sqlRowSet.getInt("id"), sqlRowSet.getString("companyName"),
                sqlRowSet.getString("name"), sqlRowSet.getString("phone"));
    }

}
