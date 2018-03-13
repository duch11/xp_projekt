package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class InstructorRepository {

    ArrayList<Instructor> intlist = new ArrayList<>();

    @Autowired
    JdbcTemplate jdbc;

    public void createInstructor (String name){
        jdbc.update("INSERT INTO adventure_alley_db.instructor (name) VALUES (?)", name);
    }


    public ArrayList<Instructor> readAll() {
        intlist.clear();
        SqlRowSet sqlrowset = jdbc.queryForRowSet("SELECT * FROM instructor ");
        while (sqlrowset.next()) {
            intlist.add(new Instructor(sqlrowset.getInt("id"), sqlrowset.getString("name")));
        }
        return intlist;
    }
}
