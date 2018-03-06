package dk.adventurealley.app.DAO;

import dk.adventurealley.app.*;
import dk.adventurealley.app.Model.Entities.Activity;
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
            activityList.add(new Activity(rs.getString("name"), rs.getString("image_path")));
        }
        return activityList;
    }

    public void deleteActivity(String name){
        jdbc.update("DELETE FROM activities WHERE name='"+name+"'");
    }
}
