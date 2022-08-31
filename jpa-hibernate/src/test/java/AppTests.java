import model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.AccountRepository;
import repository.TransactionsRepository;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/context.xml")
public class AppTests {

    @Autowired
    AccountRepository accRepo;

    @Autowired
    TransactionsRepository transRepo;

    @Test
    void testSelectAllAccountsWithJoinFetchTest() {
        List<Account> accounts = accRepo.getAllJoinFetch();
        /*один запрос с join*/

        accounts.forEach(a -> System.out.println(a.getDescription() + " " + a.getTransactionsWithSource().size()));
        /*здесь уже нет обращений к бд, все запрощенные данные выводятся из полученных выше объектов*/
    }

    @Test
    void SelectAllAccountsTest() {
        List<Account> accounts = accRepo.getAll();
        /*один запрос к Account*/

        accounts.forEach(a -> System.out.println(a.getDescription() + " " + a.getTransactionsWithSource().size()));
        /*для каждого account +1 запрос по transactions*/
        /*если указать над списком транзакций @LazyCollection(LazyCollectionOption.EXTRA), то вместо запроса
        * всех транзакций по каждому счету, будет выполнен запрос select count*/
    }

    @Test
    @Commit
    void changeAccountDescriptionTest() {
        accRepo.updateDescription(11L,"Updated account description");
    }

}
