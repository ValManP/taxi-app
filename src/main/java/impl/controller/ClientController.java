package impl.controller;

import impl.entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/client")
public class ClientController extends UserController {
    @GetMapping(path = "/create")
    public @ResponseBody
    Client createClient(@RequestParam String name, @RequestParam String password, @RequestParam String description) {
        return null;
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    Client updateClient(@RequestParam int clientId, @RequestParam String description) {
        return null;
    }

    @GetMapping(path = "/get")
    public @ResponseBody
    Client getClient(@RequestParam int clientId) {
        return null;
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Client> getAllClients() {
        return null;
    }
}
