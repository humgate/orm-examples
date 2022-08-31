package com.humgate;

import com.humgate.model.Account;
import com.humgate.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Transaction.class);

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();

        Query<Account> query = session.createQuery(
                "select a from Account a", Account.class);

        List<Account> accounts = query.getResultList();

        accounts.forEach(a -> System.out.println(a.getDescription() + " " + a.getTransactionsWithSource().size()));

    }
}
