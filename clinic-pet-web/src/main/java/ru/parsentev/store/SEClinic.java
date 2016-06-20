package ru.parsentev.store;

import ru.lesson.lessions.Client;
import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.exception.InterruptOperationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by art on 06.06.16.
 */
public class SEClinic implements PetClinic {
    private static final String ID = "id";
    private static final String CLIENT_NAME = "clientName";
    private static final String PET_NAME = "petName";

    private Client currentClient = null;

    /**
     * Get current client
     * @return client
     */
    public Client getCurrentClient() {
        return currentClient;
    }

    /**
     * Set current client
     * @param currentClient
     */
    public void setCurrentClient(Client currentClient) {
        //if (currentClient == null) {
        this.currentClient = currentClient;
        //}
    }

    private final Clinic clinic = new Clinic();

    /**
     * Get all clients
     * @return clients
     */
    public Collection<Client> getClients() {
        return clinic.getClients();
    }

    /**
     * Get client by id
     * @param id client id
     * @return
     */
    public Client getClient(String id) {
        Client client = null;
        try {
            client = clinic.get(id);
        } catch (InterruptOperationException e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * Add client
     * @param client client
     */
    public void addClient(Client client) {
        try {
            clinic.addClient(client);
        } catch (InterruptOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete client
     * @param id client id
     */
    public void deleteClient(String id) {
        try {
            clinic.delete(id);
        } catch (InterruptOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edit client
     * @param client client
     */
    public void editClient(Client client) {
        clinic.editClient(client);
    }

    /**
     * Find clients
     * @param type search parametr
     * @param toSearch string to serch
     * @return
     */
    public List<Client> findClients(String type, String toSearch) {
        List<Client> findClients = new ArrayList<Client>();
        if (ID.equals(type)) {
            try {
                findClients.add(clinic.get(toSearch));
            } catch (InterruptOperationException e) {

            }
        }
        if (CLIENT_NAME.equals(type)){
            findClients = clinic.findClientByClientName(toSearch);
        }
        if (PET_NAME.equals(type)){
            findClients = clinic.findClientByPetName(toSearch);
        }
        return findClients;
    }

    /**
     * Check client id
     * @param id
     * @return
     */
    public boolean checkId(String id){
        return clinic.checkId(id);
    }

    @Override
    public void close() {

    }
}
