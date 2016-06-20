package ru.parsentev.store;

import ru.lesson.lessions.Client;

import java.util.Collection;
import java.util.List;

/**
 * Clinic interface
 * Created by art on 29.05.16.
 */
public interface PetClinic {

    /**
     * Get all clients
     * @return list of clients
     */
    Collection<Client> getClients();

    /**
     * Get client by id
     * @param id
     * @return
     */
    Client getClient(String id);

    /**
     * Get current client
     * @return current client
     */
    Client getCurrentClient();

    /**
     * Set current client
     * @param currentClient
     */
    void setCurrentClient(Client currentClient);

    /**
     * Add client to the clinic
     * @param client client
     */
    void addClient(Client client);

    /**
     * Delete client
     * @param id client id
     */
    void deleteClient(String id);

    /**
     * Edit client
     * @param client client
     */
    void editClient(Client client);

    /**
     * Find clients
     * @param type search parametr
     * @param toSearch string to serch
     * @return
     */
    List<Client> findClients(String type, String toSearch);

    /**
     * Check client id
     * @param id id
     * @return true if consist client, false if no
     */
    boolean checkId(String id);

    /**
     * Release resources
     */
    void close();

}
