package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private ActivityRepository aR;
    @Autowired
    private ActivityRequirementsRepo aRR;

//    public Booking read(Integer id){
//        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM bookings WHERE id ='"+ id +"'");
//        if (rs.next()){
////            return new Booking(rs.getInt("id"), aR.read(rs.getInt("activityID")))0
//        }
//    }
}
