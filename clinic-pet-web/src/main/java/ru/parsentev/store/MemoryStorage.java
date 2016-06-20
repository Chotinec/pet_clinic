package ru.parsentev.store;

import ru.parsentev.models.User;

import java.util.Collection;

/**
 * TODO: connents
 * Created by art on 04.06.16.
 */
public class MemoryStorage implements Storage {

    @Override
    public Collection<User> values() {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
