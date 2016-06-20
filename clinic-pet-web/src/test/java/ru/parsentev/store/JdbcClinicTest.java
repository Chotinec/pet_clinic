package ru.parsentev.store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.lesson.lessions.Client;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * jdbc clinic test
 * Created by art on 06.06.16.
 */
public class JdbcClinicTest {

    /*private JdbcClinic clinic = null;

    @Before
    public void setClinic() {
        this.clinic = new JdbcClinic();
    }

    @After
    public void closeClinic(){
        this.clinic.close();
    }

    @Test
    public void getClients() throws Exception {
        Collection<Client> clients = clinic.getClients();
        assertFalse(clients.isEmpty());
        /*for (Client client : clients){
            assertFalse(client.getPets().isEmpty());
        }
    }

    @Test
    public void getClient() throws Exception {
        String id = "XX 55555556";
        Client client = clinic.getClient(id);
        assertEquals(id,client.getId());
       //assertEquals(5,client.getPets().size());
    }

    @Test
    public void addClient() throws Exception {
        String id = "XX 55555558";
        Client client = new Client(id, "Peter", null);
        clinic.addClient(client);
        assertEquals(id,clinic.getClient(id).getId());
        clinic.deleteClient(id);
    }

    @Test(expected = IllegalStateException.class)
    public void deleteClient() throws Exception {
        String id = "XX 55555558";
        Client client = new Client(id, "Peter", null);
        clinic.addClient(client);
        assertEquals(id,clinic.getClient(id).getId());
        clinic.deleteClient(id);
        assertEquals(id,clinic.getClient(id).getId());
    }

    @Test
    public void editClient() throws Exception {
        String id = "XX 55555557";
        String name = "Pet";
        Client client = new Client(id, name, null);
        clinic.editClient(client);
        assertEquals(name,clinic.getClient(id).getName());
    }

    @Test
    public void findClients() throws Exception {

    }

    @Test
    public void checkId() throws Exception {
        String id = "XX 55555557";
        assertTrue(clinic.checkId(id));
    }
*/
}