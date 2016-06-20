package ru.parsentev.store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.parsentev.models.User;

import static org.junit.Assert.*;

/**
 * Hibernate test
 * Created by art on 12.06.16.
 */
public class HibernateStorageTest {

    private HibernateStorage storage = null;

    @Before
    public void setConnection() {
        this.storage = new HibernateStorage();
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

}