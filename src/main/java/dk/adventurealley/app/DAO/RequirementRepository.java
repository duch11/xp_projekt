package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RequirementRepository {

    @Autowired
    private JdbcTemplate jdbc;

    private ArrayList<Requirement> requirementsList = new ArrayList<>();

    //Not working
    public ArrayList<Requirement> readAll(){
        return requirementsList;
    }

    //Create
    public void createRequirement(String name, String value){
        jdbc.execute("INSERT INTO adventure_alley_db.req_names name");

    }


}
