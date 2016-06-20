package ru.parsentev.test;

import org.hibernate.SessionFactory;
import ru.parsentev.service.HibernateUtil;

/**
 * Created by art on 11.06.16.
 */
public class Test {

    public static void main(String[] args){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    }
}
