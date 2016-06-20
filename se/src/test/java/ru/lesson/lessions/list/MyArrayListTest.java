package ru.lesson.lessions.list;

import org.junit.Test;
import ru.lesson.lessions.Animals.Cat;
import ru.lesson.lessions.Client;

import static org.junit.Assert.*;

/**
 * Created by art on 29.05.16.
 */
public class MyArrayListTest {

    @Test
    public void size() throws Exception {
        MyArrayList<Client> clients = new MyArrayList<Client>();
        /*clients.add(new Client("147","Brown", new Cat("Digy")));
        clients.add(new Client("147","Brown", new Cat("Digy")));

        assertEquals(clients.size(),2);*/
    }

    @Test
    public void add() throws Exception {
        MyArrayList<Client> clients = new MyArrayList<Client>();
        /*clients.add(new Client("147","Brown", new Cat("Digy")));
        clients.add(new Client("147","Brown", new Cat("Digy")));

        assertEquals(clients.size(),2);*/
    }

    @Test
    public void add1() throws Exception {
        MyArrayList<Client> clients = new MyArrayList<Client>();
        /*clients.add(new Client("147","Brown", new Cat("Digy")));
        clients.add(new Client("147","Brown", new Cat("Digy")));

        clients.add(1,new Client("147","Bob", new Cat("Digy")));

        assertTrue("Bob".equals(clients.get(1).getName()));*/
    }

    @Test
    public void remove() throws Exception {
        MyArrayList<String> clients = new MyArrayList<String>();
        clients.add("Artiom");
        clients.add("Oksana");

        String name = clients.remove("Artiom");
        assertTrue("Artiom".equals(name));
        assertEquals(clients.size(),1);
    }

    @Test
    public void contains() throws Exception {
        MyArrayList<String> clients = new MyArrayList<String>();
        clients.add("Artiom");
        clients.add("Oksana");

        assertTrue(clients.contains("Artiom"));
    }

    @Test
    public void isEmpty() throws Exception {
        MyArrayList<String> clients = new MyArrayList<String>();
        clients.add("Artiom");
        clients.add("Oksana");

        assertFalse(clients.isEmpty());

        clients.clear();

        assertTrue(clients.isEmpty());
    }

    @Test
    public void get() throws Exception {
        MyArrayList<String> clients = new MyArrayList<String>();
        clients.add("Artiom");
        clients.add("Oksana");

        String name = clients.get(1);

        assertTrue("Oksana".equals(name));
    }

    @Test
    public void clear() throws Exception {
        MyArrayList<String> clients = new MyArrayList<String>();
        clients.add("Artiom");
        clients.add("Oksana");

        clients.clear();

        assertTrue(clients.isEmpty());
    }


}