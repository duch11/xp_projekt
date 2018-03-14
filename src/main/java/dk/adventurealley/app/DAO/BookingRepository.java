package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private ActivityRepository aR;
    @Autowired
    private ActivityRequirementsRepository aRR;
    @Autowired
    private CustomerRepository cR;
    @Autowired
    private InstructorRepository iR;

    public Booking read(Integer id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM bookings WHERE id ='" + id + "'");
        if (rs.next()) {
            return new Booking(rs.getInt("id"), aR.read(rs.getInt("activityID")), cR.read(rs.getInt("customerID")), rs.getTimestamp("date").toLocalDateTime(),
                    rs.getString("description"), rs.getInt("numOfParticipants"), iR.read(rs.getInt("instructorID")));
        }
        return null;
    }

    public void update(Booking booking) {

        jdbc.update("UPDATE bookings SET activityID ='" + booking.getActivity().getId() + "', " +
                "customerID ='" + booking.getCustomer().getId() + "', " +
                "date ='" + booking.getDate() + "', description ='" + booking.getDescription() + "', " +
                "numOfParticipants ='" + booking.getNumOfParticipants() + "'," +
                "instructorID ='" + booking.getInstructor().getId() + "' WHERE id ='" + booking.getId() + "'");

        cR.update(booking.getCustomer());
    }

    public ArrayList<Booking> readAll() {
        ArrayList<Booking> bookingList = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM bookings");
        while (sqlRowSet.next()) {
            //getDate() format skal muligvis laves om
            bookingList.add(
                    new Booking(
                            sqlRowSet.getInt("id"),
                            aR.read(sqlRowSet.getInt("activityID")),
                            cR.read(sqlRowSet.getInt("customerID")),
                            sqlRowSet.getTimestamp("date").toLocalDateTime(),
                            sqlRowSet.getString("description"), sqlRowSet.getInt("numOfParticipants"),
                            iR.read(sqlRowSet.getInt("instructorID"))));
        }
        return bookingList;
    }

    public void deleteBooking(int id) {
        jdbc.update("DELETE FROM bookings WHERE id = " + id);
    }

}
