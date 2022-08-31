package repository;

import model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional(rollbackFor = { SQLException.class })
public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveAccount(Account a) {
        entityManager.persist(a);
    }

    public List<Account> getAllJoinFetch() {
        TypedQuery<Account> query = entityManager.createQuery(
                "select a from Account a join fetch a.transactionsWithSource", Account.class);
       return query.getResultList();
    }

    public List<Account> getAll() {
        TypedQuery<Account> query = entityManager.createQuery(
                        "select a from Account a", Account.class);
        return query.getResultList();
    }

    public Account get(Long id) {
        return entityManager.find(Account.class, id);
    }

    public Account updateDescription(Long id, String descr) {
        Account account = entityManager.find(Account.class, id);
        account.setDescription(descr);
        entityManager.flush();

        return account;
    }
}
