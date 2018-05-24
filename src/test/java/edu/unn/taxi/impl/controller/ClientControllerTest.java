package edu.unn.taxi.impl.controller;

import edu.unn.taxi.TaxiApplication;
import edu.unn.taxi.impl.db.ClientRepository;
import edu.unn.taxi.impl.entity.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ClientControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ClientController clientController;

    @Autowired
    private ClientRepository clientRepository;

    @Before
    public void init() {
        clientRepository.deleteAll();
    }

    @Test
    public void testCreateClient() throws Exception {
        mvc.perform(get("/client/create?name=cl1&password=cl1&description=abc")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    public void testUpdateClient() throws Exception {
        Client client = new Client();
        client.setName("cl2");
        client.setPassword("cl2");
        client.setDescription("abc");

        client = clientRepository.save(client);

        mvc.perform(get("/client/update?clientId=" + client.getID() + "&description=cba")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("cba"));
    }

    @Test
    public void testGetClient() throws Exception {
        Client client = new Client();
        client.setName("cl");
        client.setPassword("cl");
        client.setDescription("abc");

        client = clientRepository.save(client);

        mvc.perform(get("/client/get?clientId=" + client.getID())
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.description").value("abc"));
    }

    @Test
    public void testGetAllClient() throws Exception {
        Client clientA = new Client();
        clientA.setName("cl");
        clientA.setPassword("cl");

        Client clientB = new Client();
        clientB.setName("cl1");
        clientB.setPassword("cl1");

        clientRepository.save(clientA);
        clientRepository.save(clientB);

        mvc.perform(get("/client/getAll")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[1].name").value("cl1"));
    }
}
