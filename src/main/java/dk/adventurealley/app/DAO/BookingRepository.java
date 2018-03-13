package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private CustomerRepository customerRepository = new CustomerRepository();
    @Autowired
    private ActivityRepository activityRepository = new ActivityRepository();

    public ArrayList<Booking> readAll(){
        ArrayList<Booking> bookingList = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM booking");
        while(sqlRowSet.next()){
            //getDate() format skal muligvis laves om
            bookingList.add(new Booking(sqlRowSet.getInt("id"),activityRepository.read(sqlRowSet.getString("activityID")),
                    customerRepository.read(sqlRowSet.getString("customerID")),sqlRowSet.getDate("date").toLocalDate(),
                    sqlRowSet.getString("description"),sqlRowSet.getInt("numOfParticipants")));
        }
        return bookingList;
    }
    public void deleteBooking(int id){
        jdbc.update("DELETE FROM booking WHERE id = " + id);
    }
}
