package dk.adventurealley.app.Model.Services;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Services.Interfaces.IActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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
