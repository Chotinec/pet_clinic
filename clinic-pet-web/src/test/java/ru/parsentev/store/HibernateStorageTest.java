package ru.parsentev.store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.parsentev.models.Message;
import ru.parsentev.models.Role;
import ru.parsentev.models.User;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Hibernate test
 * Created by art on 12.06.16.
 */
public class HibernateStorageTest {

    private UserStorage storage = null;

    @Before
    public void setConnection() {
        this.storage = new UserStorage();
    }

    @After
    public void closeConnection(){
        this.storage.close();
    }

    @Test
    public void testCreate() throws Exception{
        final int id = storage.add(new User(-1,"hibernate",null));
        final User user = storage.get(id);
        assertEquals(id,user.getId());
        assertEquals(id,storage.findByLogin("hibernate").getId());
        storage.delete(id);
        assertNull(storage.get(id));
    }

    @Test
    public void testEdit()throws Exception{
        final int id = storage.add(new User(-1,"hibernate",null));
        assertEquals(id,storage.findByLogin("hibernate").getId());
        User user =  storage.get(id);
        user.setLogin("newHibernate");
        storage.edit(user);
        assertEquals(id,storage.findByLogin("newHibernate").getId());
        storage.delete(id);
        assertNull(storage.get(id));
    }

    @Test
    public void testCreateUser()throws Exception{
        Role role = new Role();
        role.setName("admin");
        User user = new User();
        user.setLogin("test");
        user.setEmail("test@test");
        user.setRole(role);
        final int id = storage.add(user);
        user = storage.get(id);
        Message message = new Message();
        message.setUser(user);
        message.setText("text");
        HashSet<Message> messages = new HashSet<Message>();
        messages.add(message);
        user.setMessages(messages);
        storage.edit(user);
        assertEquals(1, storage.get(id).getMessages().size());
        storage.delete(id);
    }

}