package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActivityRepository {

    @Autowired
    private JdbcTemplate jdbc;
    private ArrayList<Activity> activityList = new ArrayList<>();

    public ArrayList<Activity> readAll(){
        activityList.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM adventure_alley_db.activities");
        while(rs.next()){
            activityList.add(new Activity());
        }
        return activityList;
    }

    public void create(Activity a) {
        jdbc.update("INSERT INTO adventure_alley_db.activities(name, equipment, image_path, description) " + "VALUES ('" + a.getName() + "', '" + a.getEquipment() + "', '" + a.getImagePath() + "', ' " + a.getDescription() + "')");
        for (Requirement req : a.getActivityReq()) {
            jdbc.update(" INSERT INTO adventure_alley_db.act_reqs(fk_act_name, fk_req_names_name, req_value) " + "VALUES ('" + a.getName() + "', '" + req.getReqName() + "', '" + req.getValue() + "')");
        }
    }
}

