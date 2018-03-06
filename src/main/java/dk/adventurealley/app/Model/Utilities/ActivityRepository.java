package dk.adventurealley.app.Model.Utilities;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Utilities.Interfaces.IActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepository implements IActivity {

    @Autowired
    private JdbcTemplate jdbc;
    private SqlRowSet sqlRowSet;

    /*@Override
    public ArrayList<Activity> read(String name) {

    }*/

    @Override
    public void create(Activity a) {
        jdbc.update("INSERT INTO adventure_alley_db.activities(name, equipment, image_path) " + "VALUES ('" + a.getName() + "', '" + a.getEquipment() + "', '" + a.getImagePath() + "') ");
    }

}
