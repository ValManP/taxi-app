package edu.unn.taxi.impl.controller;

import com.google.common.collect.Lists;
import edu.unn.taxi.impl.db.ClientRepository;
import edu.unn.taxi.impl.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/client")
public class ClientController extends UserController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Client createClient(@RequestParam String name, @RequestParam String password, @RequestParam String description) {
        Client client = new Client();
        client.setName(name);
        client.setPassword(password);
        client.setDescription(description);

        return clientRepository.save(client);
    }

    @GetMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Client updateClient(@RequestParam int clientId, @RequestParam String description) {
        Client client = clientRepository.findById(clientId).orElse(null);

        if (client == null) {
            return null;
        }

        client.setDescription(description);

        return clientRepository.save(client);
    }

    @GetMapping(path = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Client getClient(@RequestParam int clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    @GetMapping(path = "/getAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Client> getAllClients() {
        return Lists.newArrayList(clientRepository.findAll());
    }
}
