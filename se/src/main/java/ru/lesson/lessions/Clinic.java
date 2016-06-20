package ru.lesson.lessions;

import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.exception.InterruptOperationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
*       class describe clinic
*/
public class Clinic{

   // private static Clinic clinic = new Clinic();

    /* List of clients */
    private final ConcurrentHashMap<String, Client> clients = new ConcurrentHashMap<String, Client>();

   public Clinic() {}


        /**
        * Get all clients
        * @return list of clients
        */
        public Collection<Client> getClients() {
            return clients.values();
        }

        /**
        * Add client
        * @param client
        */
        public void addClient(Client client) throws InterruptOperationException {
                if (clients.contains(client)) {
                    throw new InterruptOperationException("Clinic contains this user.");
                }
                clients.put(client.getId(),client);
        }



        /**
        * Find clients by pet name
        * @param name
        * @return list of clients
        */
        public ArrayList<Client> findClientByPetName(String name){
                ArrayList<Client> findClients = new ArrayList<Client>();
                for (ConcurrentHashMap.Entry<String,Client> cl: clients.entrySet()) {
                    for (Pet pet : cl.getValue().getPets()) {
                        if (pet.getName().equals(name)) {
                            findClients.add(cl.getValue());
                        }
                    }
                }
                return findClients;
        }

        /**
        * Find clients by client name
        * @param name
        * @return list of clients
        */
        public ArrayList<Client> findClientByClientName(String name){
                ArrayList<Client> findClients = new ArrayList<Client>();
                for (ConcurrentHashMap.Entry<String,Client> cl: clients.entrySet()) {
                    if (cl.getValue().getName().equals(name)) {
                        findClients.add(cl.getValue());
                    }
                }
                return findClients;
        }

    /**
     * Get client by id
     * @param id client id
     * @return client
     */
    public Client get(final String id) throws InterruptOperationException {
        Client client = clients.get(id);
        if (client == null) throw new InterruptOperationException(String.format("No such client with id : %s!",id));
        return client;
    }

    /**
     * Edit client
     * @param client client
     */
    public void editClient(final Client client){
        this.clients.replace(client.getId(),client);
    }

    /**
     * Delete client by id
     * @param id client id
     */
    public void delete(final String id) throws InterruptOperationException {
       Client client = this.clients.remove(id);
        if (client == null){
            throw new InterruptOperationException(String.format("No such client with id : %s!",id));
        }
    }

    /**
     * Check client id
     * @param id client
     * @return
     */
    public boolean checkId(String id){
        return clients.containsKey(id);
    }

}
