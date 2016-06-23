package ru.parsentev.store;

import ru.lesson.lessions.Client;

import java.util.Collection;
import java.util.List;

/**
 * Singletpn clinic
 * Created by art on 30.05.16.
 */
public class ClinicCashe implements StorageClinic {

    private Client currentClient = null;

    /** initialization of a single instance */
    private static final ClinicCashe INSTANCE = new ClinicCashe();

    //private final PetClinic clinic = new SEClinic();
    private final StorageClinic clinic = new JdbcClinic();

    private ClinicCashe(){}

    /**
     * Get current client
     * @return client
     */
    public Client getCurrentClient() {
        return this.clinic.getCurrentClient();
    }

    /**
     * Set current client
     * @param currentClient
     */
    public void setCurrentClient(Client currentClient) {
        //if (currentClient == null) {
        this.clinic.setCurrentClient(currentClient);
        //}
    }

    /**
     * Get instance
     * @return single clinic Instance
     */
    public static ClinicCashe getInstance(){return INSTANCE;}

    /**
     * Get all clients
     * @return clients
     */
    public Collection<Client> getClients() {
        return this.clinic.getClients();
    }

    /**
     * Get client by id
     * @param id client id
     * @return
     */
    public Client getClient(String id) {
        return this.clinic.getClient(id);
    }

    /**
     * Add client
     * @param client client
     */
    public void addClient(Client client) {
        this.clinic.addClient(client);
    }

    /**
     * Delete client
     * @param id client id
     */
    public void deleteClient(String id) {
        this.clinic.deleteClient(id);
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
        return this.clinic.findClients(type,toSearch);
    }

    /**
     * Check client id
     * @param id
     * @return
     */
    public boolean checkId(String id){
        return clinic.checkId(id);
    }

    /**
     * Release resources
     */
    @Override
    public void close() {
        this.clinic.close();
    }
}
