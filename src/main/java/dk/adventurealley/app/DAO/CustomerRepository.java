package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    public Customer read(String customerId){


        return new Customer();
    }

}
