package hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.force.api.*;

@RestController
public class SalesforceController {
    private ForceApi api;
    public SalesforceController(){
        /*authenticates to salesforce.
            obviously these values should be in a config file that is not
            checked into source control. but this project is just for demo
            purposes.
         */
        api = new ForceApi(new ApiConfig()
                .setUsername("<SALESFORCE USERNAME")
                .setPassword("<PASSWORD + SECURITY TOKEN")
                .setClientId("<LONG ALPHANUMERIC STRING")
                .setClientSecret("<SHORTER NUMBER STRING>"));
    }
    @RequestMapping("/sf/getaccount")
    public Account getaccount(@RequestParam(name="id") String id){
        return api.getSObject("Account", id).as(Account.class);
    }

    @RequestMapping(value="/sf/updateaccount", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String updateaccount(@RequestBody Account account) {
        Account a = new Account();
        a.setName(account.name);
        a.setDescription(account.description);
        api.updateSObject("account", account.id, a);
        return "success";
    }

    @RequestMapping(value="/sf/createaccount", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public Account createAccount(@RequestBody Account account){
        String id = api.createSObject("account", account);

        account.setId(id);
        return account;

    }

    @RequestMapping(value="/sf/deleteaccount", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String deleteAccount(@RequestBody Account account){
        String id = account.id;
        api.deleteSObject("account", id);
        return "success";
    }
}
