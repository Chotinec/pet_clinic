package ru.parsentev.store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.lesson.lessions.Animals.Cat;
import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Client;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by art on 12.06.16.
 */
public class HibernateClinicTest {

    private HibernateClinic clinic = null;

    @Before
    public void setConnection() {
        this.clinic = new HibernateClinic();
    }

    @After
    public void closeConnection(){
        this.clinic.close();
    }

    @Test
    public void testGetClients() throws Exception {
        Collection<Client> clients = clinic.getClients();
        assertFalse(clients.isEmpty());
        assertEquals(clients.size(),6);
    }

    @Test
    public void getClient() throws Exception {
        String clientId = "XX_55555556";
        Client client = clinic.getClient(clientId);
        assertEquals(clientId,client.getId());

    }

    @Test
    public void addClient() throws Exception {
        Client client = new Client("testH","testH",null);
        client.addPet(new Cat("testH"));
        clinic.addClient(client);
        assertNotNull(clinic.getClient("testH"));
        assertEquals(clinic.getClient("testH").getId(),"testH");
    }

    @Test
    public void deleteClient() throws Exception {

    }

    @Test
    public void editClient() throws Exception {

    }

    @Test
    public void checkId() throws Exception {

    }

}