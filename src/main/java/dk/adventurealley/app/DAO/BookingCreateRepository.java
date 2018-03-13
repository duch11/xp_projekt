package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


@Repository
public class BookingCreateRepository {


    @Autowired
    private JdbcTemplate jdbc;

    public void create (Booking b, Customer c) {
        jdbc.update("INSERT INTO adventure_alley_db.customer(name, companyName, phone) " + "VALUES ('" + c.getCustomerName() + "', '" + c.getCompanyName() + "', '" + c.getPhone() + "')");
        SqlRowSet sr1 = jdbc.queryForRowSet("SELECT * FROM customer WHERE phone = '" + c.getPhone() + "'");
        Customer cnew = new Customer();

        if(sr1.next()) {
            cnew.setId(sr1.getInt("id")); cnew.setCustomerName(sr1.getString("name")); cnew.setCustomerName(sr1.getString("companyName")); cnew.setPhone(sr1.getString("phone"));
        }


    jdbc.update("INSERT INTO adventure_alley_db.booking(date, customerID, numOfParticipants, description, instructorID) " + "VALUES ('" + b.getDate() + "', '" + cnew.getId() + "', '" + b.getNumOfParticipants() + "', '" + b.getDescription() + "')");
    }

}
