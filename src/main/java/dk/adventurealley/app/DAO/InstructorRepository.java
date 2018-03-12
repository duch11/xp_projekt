package dk.adventurealley.app.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorRepository {

    @Autowired
    JdbcTemplate jdbc;

    public void createInstructor (String name){
        jdbc.update("INSERT INTO adventure_alley_db.instructors (name) VALUES (?)", name);
    }
}
