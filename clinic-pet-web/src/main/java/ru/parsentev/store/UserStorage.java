package ru.parsentev.store;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.parsentev.models.User;
import ru.parsentev.service.HibernateUtil;

import java.util.Collection;

/**
 * Hibernate storage
 * Created by art on 11.06.16.
 */
public class UserStorage implements Storage {

    private final SessionFactory factory;

    public UserStorage(){
        factory = HibernateUtil.getSessionFactory();
    }

    /**
     * Command interface
     * @param <T>
     */
    public interface Command<T>{
        T proccess(Session session);
    }

    /**
     * Transaction method
     * @param commnd command interface
     * @param <T>
     * @return
     */
    private <T> T transaction(final Command<T> commnd){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            return commnd.proccess(session);
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Collection<User> values() {
       return transaction(new Command<Collection<User>>() {
           @Override
           public Collection<User> proccess(Session session) {
               return session.createQuery("from User").list();
           }
       });
    }

    @Override
    public int add(final User user) {
        return transaction(new Command<Integer>() {
            @Override
            public Integer proccess(Session session) {
                session.save(user);
                return user.getId();
            }
        });
    }

    @Override
    public void edit(final User user) {
        transaction(new Command() {
            @Override
            public Object proccess(Session session) {
                session.update(user);
                return null;
            }
        });
    }

    @Override
    public void delete(final int id) {
        transaction(new Command() {
            @Override
            public Object proccess(Session session) {
                session.delete(get(id));
                return null;
            }
        });
    }

    @Override
    public User get(final int id) {
        return transaction(new Command<User>() {
            @Override
            public User proccess(Session session) {
                return (User) session.get(User.class, id);
            }
        });
    }

    @Override
    public User findByLogin(final String login) {
        return transaction(new Command<User>() {
            @Override
            public User proccess(Session session) {
                final Query query = session.createQuery("from User as user where user.login=:login");
                query.setString("login",login);
                return (User)query.iterate().next();
            }
        });

    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        this.factory.close();
    }
}
