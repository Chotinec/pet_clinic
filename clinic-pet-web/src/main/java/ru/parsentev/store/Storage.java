package ru.parsentev.store;

import ru.parsentev.models.User;

import java.util.Collection;

/**
 * Created by art on 04.06.16.
 */
public interface Storage {

    Collection<User> values();

    int add(final User user);

    void edit(final User user);

    void delete(final int id);

    User get(final int id);

    User findByLogin(final String login);

    int generateId();

    void close();
}
