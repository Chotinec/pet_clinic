package ru.parsentev.store;

import ru.parsentev.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO: coment
 * Created by art on 25.05.16.
 */
public class UserCashe implements Storage {

    private final Storage storage = new MemoryStorage();

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    private static UserCashe ourInstance = new UserCashe();

    private UserCashe() {}

    public static UserCashe getInstance() {
        return ourInstance;
    }

    @Override
    public Collection<User> values(){
        return  this.storage.values();
    }

    @Override
    public int add(final User user){
       return this.storage.add(user);
    }

    @Override
    public void delete(final int id){
        this.storage.delete(id);
    }

    @Override
    public User get(final int id){
        return this.storage.get(id);
    }

    @Override
    public void edit(final User user){
        this.storage.equals(user);
    }

    @Override
    public User findByLogin(final String login){
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }

}
