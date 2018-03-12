package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActivityRequirementsRepo {
    @Autowired
    private JdbcTemplate jdbc;
    private ArrayList<Requirement> requirements = new ArrayList<>();

    public ArrayList<Requirement> readAllReqNameForOneAct(String id){
        requirements.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM act_reqs WHERE fk_act_id ='"+ id +"'");
        SqlRowSet rs2 = jdbc.queryForRowSet("SELECT * FROM requirements WHERE id ="+rs.getInt("fk_req_id"));

        while (rs.next()){
            requirements.add(new Requirement(rs.getInt("fk_req_id"), rs2.getString("name"), rs.getString("req_value")));
        }
        return requirements;
    }

    public Requirement read(String actID, String reqID){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM act_reqs WHERE fk_act_id ='"+ actID +"' AND fk_req_id ='"+ reqID +"'");
        SqlRowSet rs2 = jdbc.queryForRowSet("SELECT * FROM requirements WHERE id ="+rs.getInt("fk_req_id"));
        if (rs.next()){
            return new Requirement(rs.getInt("fk_req_id"), rs2.getString("name"), rs.getString("req_value"));
        }

        return null;
    }
}
