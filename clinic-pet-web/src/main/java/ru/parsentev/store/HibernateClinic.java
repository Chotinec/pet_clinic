package ru.parsentev.store;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Client;
import ru.lesson.lessions.PetCreator;
import ru.parsentev.models.ClientModel;
import ru.parsentev.models.PetModel;
import ru.parsentev.models.PetTypeModel;
import ru.parsentev.service.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hibernate clinic
 * Created by art on 12.06.16.
 */
public class HibernateClinic implements StorageClinic {

    private final SessionFactory factory;

    /** Current client for updating */
    private Client currentClient = null;

    public HibernateClinic(){
        factory = HibernateUtil.getSessionFactory();
    }

    /**
     * Get all clients
     * @return clients list
     */
    @Override
    public Collection<Client> getClients() {
        ArrayList<Client> clients = new ArrayList<>();
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List<ClientModel>clientModels = session.createQuery("from ClientModel").list();
            for (ClientModel clientModel : clientModels){
                clients.add(createClient(clientModel));
            }
        }finally {
            tx.commit();
            session.close();
        }
        return clients;
    }

    /**
     * Get client by id
     * @param id client id
     * @return client
     */
    @Override
    public Client getClient(String id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            ClientModel clientModel = (ClientModel)session.get(ClientModel.class,id);
            return createClient(clientModel);
        }finally {
            tx.commit();
            session.close();
        }
    }

    /**
     * Get current client
     * @return current client
     */
    @Override
    public Client getCurrentClient() {
        return this.currentClient;
    }

    /**
     * Set current client
     * @param currentClient currentclient
     */
    @Override
    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    /**
     * Add client
     * @param client client
     */
    @Override
    public void addClient(Client client) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            ClientModel clientModel = new ClientModel(client.getId(),client.getName(),null,null);
            for(Pet pet : client.getPets()){
                PetModel petModel = new PetModel(pet.getName());
                PetTypeModel petTypeModel = getPetTypeByType(pet.getType());
                petModel.setPetTypeModel(petTypeModel);
                petTypeModel.getPetModels().add(petModel);
                petModel.setClientModel(clientModel);
                clientModel.getPetModels().add(petModel);
                session.save(petModel);
            }
            session.save(clientModel);
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void deleteClient(String id) {

    }

    @Override
    public void editClient(Client client) {

    }

    @Override
    public List<Client> findClients(String type, String toSearch) {
        return null;
    }

    @Override
    public boolean checkId(String id) {
        return false;
    }

    /**
     * Close connection
     */
    @Override
    public void close() {
        this.factory.close();
    }

    /**
     * Get pet type by type
     * @return pet type
     */
    private PetTypeModel getPetTypeByType(String type){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        PetTypeModel petTypeModel = null;
        try{
            //return (PetTypeModel)session.get(PetTypeModel.class,type);
            final Query query = session.createQuery("from PetTypeModel as pet_type where pet_type.type=:type");
            query.setString("type",type);
            List<PetTypeModel> petTypeModels =  query.list();
            for (PetTypeModel petType : petTypeModels){
                petTypeModel = petType;
            }
        }finally {
            tx.commit();
            session.close();
        }
        return petTypeModel;
    }

    /**
     * Create client
     * @param clientModel client model
     * @return client
     */
    private Client createClient(ClientModel clientModel){
        Client client = new Client(clientModel.getClient_id(),clientModel.getClient_id(),null);
        for (PetModel petModel : clientModel.getPetModels()){
            Pet pet = PetCreator.createPet(petModel.getPetTypeModel().getType(),petModel.getName());
            client.addPet(pet);
        }
        return client;
    }
}
