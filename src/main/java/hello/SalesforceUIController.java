package hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SalesforceUIController {
    @RequestMapping("/sfui/create")
    public String create(){
        return "create";
    }

    @RequestMapping("/sfui/update")
    public String update(){
        return "update";
    }
}
