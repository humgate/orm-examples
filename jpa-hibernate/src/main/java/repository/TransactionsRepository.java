package repository;

import model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional(rollbackFor = { SQLException.class })
public class TransactionsRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Transaction> getAllTransactionsJointFetch() { // 1 select
        return entityManager
                .createQuery("select t from Transaction t join fetch t.source join fetch t.target", Transaction.class)
                .getResultList();
    }

    public List<Transaction> getAllTransactions() {// n + 1 select
        return entityManager
                .createQuery("select t from Transaction t", Transaction.class)
                .getResultList();
    }

    public void saveTransaction(Transaction t) {
        entityManager.persist(t);
    }

    public void saveTwoTransactions(Transaction one, Transaction two) throws SQLException {
        entityManager.persist(one);
        if (two.getSource().getNumber() == 234) throw new SQLException("Thrown after first object persist call");
        entityManager.persist(two);
    }

}
