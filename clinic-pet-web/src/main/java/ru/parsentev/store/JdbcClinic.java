package ru.parsentev.store;

import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Client;
import ru.lesson.lessions.PetCreator;
import ru.parsentev.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Pet clinic based on jdbc
 * Created by art on 06.06.16.
 */
public class JdbcClinic implements PetClinic {

    /** Connection with DB */
    private final Connection connection;

    /** Current client for updating */
    private Client currentClient = null;

    /** Search types*/
    private static final String ID = "id";
    private static final String CLIENT_NAME = "client_name";
    private static final String PET_NAME = "pet_name";

    /**
     * Queries
     */
    private final String SQL_GET_ALL_CLIENTS = "SELECT * FROM clients";
    private final String SQL_GET_ALL_PETS = "SELECT * FROM pets WHERE client_id = (?)";
    private final String SQL_GET_CLIENT_BY_ID = "SELECT * FROM clients WHERE client_id = (?)";
    private final String SQL_GET_CLIENT_BY_NAME = "SELECT * FROM clients WHERE name = (?)";
    private final String SQL_ADD_CLIENT = "INSERT INTO clients (client_id, name) VALUES (?, ?)";
    private final String SQL_ADD_PET = "INSERT INTO pets (name, type_id, client_id) VALUES (?, ?, ?)";
    private final String SQL_PET_TYPE_ID = "SELECT type_id FROM pet_type WHERE type = (?)";
    private final String SQL_PET_TYPE_BY_ID = "SELECT type FROM pet_type WHERE type_id = (?)";
    private final String SQL_DELETE_CLIENT = "DELETE FROM clients WHERE client_id = (?)";
    private final String SQL_DELETE_PET = "DELETE FROM pets WHERE client_id = (?)";
    private final String SQL_GET_CLIENT_BY_PET_NAME =
            "SELECT clients.client_id, clients.name \n" +
            "FROM clients INNER JOIN pets\n" +
            "ON clients.client_id = pets.client_id\n" +
            "WHERE pets.name = ?";

    public JdbcClinic(){
        final Settings settings = Settings.getInstance();
        try {
            Class.forName(settings.value("jdbc.driver_class"));
            this.connection = DriverManager.getConnection(
                    settings.value("jdbc.url"),
                    settings.value("jdbc.username"),
                    settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Get list of clients
     * @return clients collection
     */
    @Override
    public Collection<Client> getClients() {
        final List<Client> clients = new CopyOnWriteArrayList<>();
        try(final Statement statement = this.connection.createStatement();
            final ResultSet result = statement.executeQuery(SQL_GET_ALL_CLIENTS)){
            while (result.next()){
                clients.add(new Client(result.getString("client_id"),
                                        result.getString("name"),
                                        getClientPets(result.getString("client_id"))));
            }
        }catch (SQLException e){
            e.printStackTrace();
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
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_GET_CLIENT_BY_ID)){
            statement.setString(1,id);
            try(ResultSet result = statement.executeQuery()){
                while (result.next()){
                    return new Client(
                            result.getString("client_id"),
                            result.getString("name"),
                            getClientPets(id)
                    );
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("Client %s does not exists",id));
    }

    /**
     * Get current client
     * @return
     */
    @Override
    public Client getCurrentClient() {
        return this.currentClient;
    }

    /**
     * Set current client
     * @param currentClient
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
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_ADD_CLIENT)){
            statement.setString(1,client.getId());
            statement.setString(2,client.getName());
            statement.executeUpdate();
            for (Pet pet: client.getPets()){
                addPet(pet.getName(),pet.getType(),client.getId());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Delete client
     * @param id client id
     */
    @Override
    public void deleteClient(String id) {
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_DELETE_CLIENT)){
            statement.setString(1,id);
            statement.executeUpdate();
            deletePet(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Edit client
     * @param client client
     */
    @Override
    public void editClient(Client client) {
        String client_id = client.getId();
        deleteClient(client_id);
        addClient(client);
    }

    /**
     * Find clients by search type
     * @param type search parametr
     * @param toSearch string to serch
     * @return find clients list
     */
    @Override
    public List<Client> findClients(String type, String toSearch) {
        List<Client> findClients = new ArrayList<>();
        try {
            if (ID.equals(type)) {
                findClients.add(getClient(toSearch));
            }
            if (CLIENT_NAME.equals(type)) {
                findClients.addAll(findClientsByName(toSearch));
            }
            if (PET_NAME.equals(type)) {
                findClients.addAll(findClientsByPetName(toSearch));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return findClients;
    }

    /**
     * Check client id
     * @param id id
     * @return true if consist client, false if not
     */
    @Override
    public boolean checkId(String id) {
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_GET_CLIENT_BY_ID)){
            statement.setString(1,id);
            try(ResultSet result = statement.executeQuery()){
                while (result.next()){
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Close conection with Database
     */
    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get list of pets
     * @param id client id
     * @return pets list
     */
    private List<Pet> getClientPets(String id){
        List<Pet> pets = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_GET_ALL_PETS)){
            statement.setString(1,id);
            try(ResultSet result = statement.executeQuery()){
                while (result.next()){
                    pets.add(PetCreator.createPet(
                            getPetTypeById(result.getInt("type_id")),
                            result.getString("name")
                    ));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pets;
    }

    /**
     * Add pet
     * @param name pet name
     * @param type_id pet id
     * @param client_id client id
     */
    private void addPet(String name, String type_id, String client_id) throws SQLException {
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_ADD_PET)){
            int typeId = getPetTypeId(type_id);
            statement.setString(1,name);
            statement.setInt(2,typeId);
            statement.setString(3,client_id);
            statement.executeUpdate();
        }
    }

    /**
     * Get pet type id
     * @param petType pet type
     * @return pet type id
     */
    private int getPetTypeId(String petType) throws SQLException {
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_PET_TYPE_ID)){
            statement.setString(1,petType);
            try(ResultSet result = statement.executeQuery()){
                while (result.next()){
                    return result.getInt("type_id");
                }
            }
        }
        throw new IllegalStateException(String.format("Pet type %s does not exists",petType));
    }

    /**
     * Get pet type by id
     * @param type_id pet type id
     * @return pet type string
     */
    private String getPetTypeById(int type_id) throws SQLException {
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_PET_TYPE_BY_ID)){
            statement.setInt(1,type_id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                return result.getString("type");
            }
        }
        throw new IllegalStateException(String.format("Pet type_id %s does not exists",type_id));
    }

    /**
     * Dlete pet
     * @param client_id client id
     */
    private void deletePet(String client_id) throws SQLException {
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_DELETE_PET)){
            statement.setString(1, client_id);
            statement.executeUpdate();
        }
    }

    /**
     * Find clients by name
     * @param clientName client name
     * @return
     * @throws SQLException
     */
    private List<Client> findClientsByName(String clientName) throws SQLException {
        List<Client> clients = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQL_GET_CLIENT_BY_NAME)){
            statement.setString(1,clientName);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                clients.add(new Client(result.getString("client_id"),
                                        result.getString("name"),
                                        getClientPets(result.getString("client_id"))));
            }
        }
        return clients;
    }

    /**
     * Find clients by pet name
     * @param name client name
     */
    private List<Client> findClientsByPetName(String name) throws SQLException {
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(SQL_GET_CLIENT_BY_PET_NAME)){
            statement.setString(1,name);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                clients.add(new Client(result.getString("client_id"),
                        result.getString("name"),
                        getClientPets(result.getString("client_id"))));
            }
        }
        return clients;
    }
}
