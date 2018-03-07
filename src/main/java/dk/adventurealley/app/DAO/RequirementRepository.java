package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// Lavet af Andreas og Jonas
@Repository
public class RequirementRepository {

    @Autowired
    private JdbcTemplate jdbc;

    private ArrayList<Requirement> requirementsList = new ArrayList<>();

    // readAll er kun til requirement names, outputter kun Requirement uden værdier
    public ArrayList<Requirement> readAll() {
        requirementsList.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM adventure_alley_db.req_names");
        while (rs.next()) {
            requirementsList.add(new Requirement(rs.getString("name")));
        }
        return requirementsList;
    }

    // Create requirement name
    public void createRequirement(String requirementName) {
        jdbc.update("insert into adventure_alley_db.req_names (name) values (?)",requirementName);
    }


}