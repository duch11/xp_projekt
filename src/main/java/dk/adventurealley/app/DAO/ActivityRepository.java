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
    private RequirementRepository rR = new RequirementRepository();
    @Autowired
    private ActivityRequirementsRepository aRR = new ActivityRequirementsRepository();

    // write Activity to DB
    public void create(Activity a) {
        jdbc.update("INSERT INTO activities(name, equipment, description, imagePath) " + "VALUES ('" + a.getName() + "', '" + a.getEquipment() + "', '" + a.getDescription() + "', ' " + a.getImagePath() +"')");
        for (Requirement req : a.getReqList()) {
            jdbc.update(" INSERT INTO act_reqs(fk_act_id, fk_req_id, req_value) " + "VALUES ('" + readActivityID(a.getName()) + "', '" + rR.readReqID(req.getReqName()) + "', '" + req.getValue() + "')");
        }
    }

    // find out what ID the Activity has
    public Integer readActivityID(String name){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT id FROM activities WHERE name='" + name + "'");
        while (rs.next()){
            return rs.getInt("id");
        }
        return null;
    }

    // return specific Activity
    public Activity read(Integer id){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM activities WHERE id="+id);
        while(rs.next()) {
            return new Activity(rs.getInt("id"), rs.getString("name"), aRR.readAllReqForActivity(id),
                    rs.getString("equipment"), rs.getString("imagePath"), rs.getString("description"));
        }
        return null;
    }

    // Returns a list of Activities with name and image (used in front-page for display)
    public ArrayList<Activity> readAll(){
        activityList.clear();
//        activityList.add(new Activity());
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM activities");
        while(rs.next()){
            activityList.add(new Activity(rs.getInt("id"), rs.getString("name"), rs.getString("imagePath")));
        }
        return activityList;
    }

    // Updates Activity in DB with given Activity
    public void update(Activity activity){
        jdbc.update("UPDATE activities SET name ='"+ activity.getName() +"', equipment ='"+ activity.getEquipment() +"', " +
                "imagePath ='"+ activity.getImagePath() +"', description ='"+ activity.getDescription() +"' WHERE id ='"+ activity.getId() +"'");
        aRR.updateActivityRequirements(readActivityID(activity.getName()), activity.getReqList());
    }

    // Delete specific Activity
    public void deleteActivity(Integer id){
        jdbc.update("DELETE FROM activities WHERE id='"+id+"'");
    }

    /*
    public void create(Activity a) {
        jdbc.update("INSERT INTO adventure_alley_db.activities(name, equipment, description, imagePath) " + "VALUES ('" + a.getName() + "', '" + a.getEquipment() + "', '" + a.getDescription() + "', ' " + a.getImagePath() +"')");
        for (Requirement req : a.getReqList()) {
            jdbc.update(" INSERT INTO adventure_alley_db.act_reqs(fk_act_id, fk_req_id, req_value) " + "VALUES ('" + a.getId() + "', '" + req.getId() + "', '" + req.getValue() + "')");
        }
    }

    public Activity read(String actName){
        SqlRowSet rs1 = jdbc.queryForRowSet("SELECT * FROM activities WHERE name = '"+ actName +"'");
        SqlRowSet rs2 = jdbc.queryForRowSet("SELECT fk_req_id, req_value FROM act_reqs WHERE fk_act_id ='"+ rs1.getInt("id") +"'");
        SqlRowSet rs3 = jdbc.queryForRowSet("SELECT * FROM requirements WHERE id="+rs2.getInt("fk_req_id"));
        ArrayList<Requirement> requirements = new ArrayList<>();
        if (rs1.next()){
            while (rs2.next()){
                requirements.add(new Requirement(rs2.getInt("id"), rs3.getString("name"), rs2.getString("req_value")));
            }
            return new Activity(rs1.getInt("id"), rs1.getString("name"), requirements , rs1.getString("equipment"), rs1.getString("imagePath"), rs1.getString("description"));
        }
        return null;
    }

    public void update(Activity activity){
        jdbc.update("UPDATE activities SET name ='"+ activity.getName() +"', equipment ='"+ activity.getEquipment() +"', imagePath ='"+ activity.getImagePath() +"', description ='"+ activity.getDescription() +"' WHERE id ='"+ activity.getId() +"'");
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM act_reqs WHERE fk_act_id ='"+ activity.getId() +"'");
        while (rs.next()){
            for (Requirement req : activity.getReqList()) {
                jdbc.update("UPDATE act_reqs SET req_value ='" + req.getValue() + "' WHERE fk_act_id ='" + activity.getId() + "' AND fk_req_id ='" + req.getId() + "'");
            }
        }
        System.out.println(activity.getReqList());
        System.out.println(aRR.readAllReqNameForOneAct(activity.getName()));
        if(activity.getReqList() != null) {
            for (Requirement req : activity.getReqList()) {
                if (aRR.read(activity.getName(), req.getReqName()) == null) {
                    jdbc.update("INSERT INTO act_reqs (fk_act_id, fk_req_id, req_value) VALUES ('" + activity.getId() + "', '" + req.getId() + "', '" + req.getValue() + "')");
                }
            }
        }
    } */
}

