package dk.adventurealley.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ReqController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){

        return "ActivityPage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(){
        return "edit";
    }
}

