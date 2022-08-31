package com.humgate;

import com.humgate.model.Account;
import com.humgate.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Hello world!
 *
 */
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

        TypedQuery<Account> query = session.createQuery(
                "select a from Account a join fetch a.transactionsWithSource", Account.class);

        List<Account> accounts = query.getResultList();

        accounts.forEach(a -> System.out.println(a.getDescription() + " " + a.getTransactionsWithSource().size()));

    }
}
