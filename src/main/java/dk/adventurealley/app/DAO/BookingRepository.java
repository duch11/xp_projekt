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

    @Autowired
    private JdbcTemplate jdbc;
    private ArrayList<Activity> activityList;

    private Activity golfactivity = new Activity("Minigolf","/");
    private Customer costumer = new Customer(1, "Mærsk","Hassan Jensen", "+33 41 41 22 11");
    private LocalDateTime localDateTime = LocalDateTime.of(2018, 3, 12, 12, 20, 0);
    private Booking booking = new Booking(1, golfactivity, costumer, localDateTime.toLocalDate(), "Firmafrokost", 12);
    @Autowired
    private ActivityRepository activityRepository;

    public Booking read(int id){
        SqlRowSet rowset1 = jdbc.queryForRowSet("SELECT * FROM booking WHERE id = ?",id);
        while (rowset1.next()){
            Activity activity = activityRepository.read(String.valueOf(id));
            new Booking(
                    id,activity,costumer,
            )
        }
    }

}
