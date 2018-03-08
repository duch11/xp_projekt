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

    public ArrayList<Requirement> readAllReqNameForOneAct(String actName){
        requirements.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM act_reqs WHERE fk_act_name ='"+ actName +"'");

        while (rs.next()){
            requirements.add(new Requirement(rs.getString("fk_req_names_name"), rs.getString("req_value")));
        }
        return requirements;
    }

    public Requirement read(String actName, String reqName){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM act_reqs WHERE fk_act_name ='"+ actName +"' AND fk_req_names_name ='"+ reqName +"'");

        if (rs.next()){
            return new Requirement(rs.getString("fk_req_names_name"), rs.getString("req_value"));
        }

        return null;
    }
}
