package ru.lesson.lessions;

import org.junit.Test;

/**
 * Clinic tests
 * Created by art on 29.05.16.
 */
public class ClinicTest {

    @Test
    public void getClientsTest() throws Exception {
        Clinic clinic = new Clinic();
        /*clinic.addClient(new Client("147","Brown", new Cat("Digy")));
        clinic.addClient(new Client("156","Nick", new Dog(new Animal("Sparky","dog"))));

        assertEquals(clinic.getClients().size(),2);*/
    }

    @Test
    public void addClientTest() throws Exception {
        Clinic clinic = new Clinic();
       /* clinic.addClient(new Client("147","Brown", new Cat("Digy")));
        clinic.addClient(new Client("156","Nick", new Dog(new Animal("Sparky","dog"))));

        assertEquals(clinic.getClients().size(),2);

        clinic.addClient(new Client("1477","Brown", new Cat("Digy")));
        assertTrue(clinic.getClients().size()==3);*/
    }

    @Test
    public void findClientByPetNameTest() throws Exception {
        Clinic clinic = new Clinic();
       /* clinic.addClient(new Client("147","Brown", new Cat("Digy")));
        clinic.addClient(new Client("156","Nick", new Dog(new Animal("Sparky","dog"))));
        clinic.addClient(new Client("176","Win", new Dog(new Animal("Sparky","dog"))));

        assertEquals(clinic.findClientByPetName("Sparky").size(),2);*/
    }

    @Test
    public void findClientByClientNameTest() throws Exception {
        Clinic clinic = new Clinic();
        /*clinic.addClient(new Client("147","Brown", new Cat("Digy")));
        clinic.addClient(new Client("156","Nick", new Dog(new Animal("Nick","dog"))));
        clinic.addClient(new Client("176","Nick", new Dog(new Animal("Sparky","dog"))));

        assertEquals(clinic.findClientByPetName("Nick").size(),1);*/
    }

    @Test
    public void getTest() throws Exception {
        Clinic clinic = new Clinic();
        /*clinic.addClient(new Client("147","Brown", new Cat("Digy")));
        clinic.addClient(new Client("156","Nick", new Dog(new Animal("Sparky","dog"))));

        Client client = clinic.get("147");
        assertTrue(client.getName().equals("Brown"));*/
    }

    @Test
    public void editClientTest() throws Exception {
        Clinic clinic = new Clinic();
       /* clinic.addClient(new Client("147","Brown", new Cat("Digy")));
        clinic.addClient(new Client("156","Nick", new Dog(new Animal("Sparky","dog"))));

        assertTrue(clinic.get("147").getName().equals("Brown"));

        clinic.addClient(new Client("147","Spown", new Cat("Digy")));

        assertFalse(clinic.get("147").getName().equals("Brown"));*/
    }

    @Test
    public void deleteTest() throws Exception {
        Clinic clinic = new Clinic();
        /*clinic.addClient(new Client("147","Brown", new Cat("Digy")));
        clinic.addClient(new Client("156","Nick", new Dog(new Animal("Sparky","dog"))));

        assertEquals(clinic.getClients().size(),2);

        clinic.delete("147");

        assertEquals(clinic.getClients().size(),1);*/
    }

}