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
    @Autowired
    private RequirementRepository rP = new RequirementRepository();

    public ArrayList<Activity> readAll(){
        activityList.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM adventure_alley_db.activities");
        while(rs.next()){
            activityList.add(new Activity(rs.getString("name"), rs.getString("image_path")));
        }
        return activityList;
    }

    public Activity read(String actId){
        SqlRowSet rs1 = jdbc.queryForRowSet("SELECT * FROM activities WHERE name = '"+ actId +"'");
        SqlRowSet rs2 = jdbc.queryForRowSet("SELECT fk_req_names_name, req_value FROM act_reqs WHERE fk_act_name ='"+ actId +"'");
        ArrayList<Requirement> requirements = new ArrayList<>();
        if (rs1.next()){
            while (rs2.next()){
                requirements.add(new Requirement(rs2.getString("fk_req_names_name"), rs2.getString("req_value")));
            }
            return new Activity(rs1.getString("name"), requirements , rs1.getString("equipment"), rs1.getString("image_path"), rs1.getString("description"));
        }
        return null;
    }
}
