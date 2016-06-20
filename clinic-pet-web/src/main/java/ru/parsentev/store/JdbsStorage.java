package ru.parsentev.store;

import ru.parsentev.models.User;
import ru.parsentev.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by art on 04.06.16.
 */
public class JdbsStorage implements Storage {

    private final Connection connection;

    public JdbsStorage() {
        final Settings settings = Settings.getInstance();
        try {
            this.connection = DriverManager.getConnection(
                    settings.value("jdbc.url"),
                    settings.value("jdbc.username"),
                    settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Collection<User> values() {
        final List<User> users = new ArrayList<User>();
        try(final Statement statment = this.connection.createStatement();
            final ResultSet res = statment.executeQuery("SELECT * FROM client")){

            while (res.next()){
                users.add(new User(res.getInt("uid"),res.getString("name"),null));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int add(User user) {
        try(PreparedStatement preparedStatment = this.connection.prepareStatement(
                "INSERT INTO client (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)){
            preparedStatment.setString(1,user.getLogin());
            preparedStatment.executeUpdate();
            try(ResultSet res = preparedStatment.getGeneratedKeys()){
                if (res.next()){
                    return  res.getInt(1);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user!");
    }

    @Override
    public void edit(User user) {
        try(PreparedStatement statement = this.connection.prepareStatement("UPDATE client SET name = (?) WHERE uid = (?)")){
            statement.setString(1,user.getLogin());
            statement.setInt(2,user.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement statement = this.connection.prepareStatement("DELETE FROM client WHERE uid = (?)")){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User get(int id) {
        try(PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM client WHERE uid = (?)")){
            statement.setInt(1,id);
            try(final ResultSet res = statement.executeQuery()){
                while(res.next()){
                    return new User(res.getInt("uid"),res.getString("name"),null);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("User %s does not exists",id));
    }

    @Override
    public User findByLogin(String login) {
        try(PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM client WHERE name = (?)")){
            statement.setString(1,login);
            try(final ResultSet res = statement.executeQuery()){
                while(res.next()){
                    return new User(res.getInt("uid"),res.getString("name"),null);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("User with name %s does not exists",login));
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
