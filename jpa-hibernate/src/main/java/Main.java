import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import repository.AccountRepository;
import repository.TransactionsRepository;

@Transactional
public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("context.xml");
        var transRepo = context.getBean(TransactionsRepository.class);
        var accRepo = context.getBean(AccountRepository.class);


//        var source = new Account(111, "Acc 111");
//        accRepo.saveAccount(source);
//        var target = new Account(112, "Acc 112");
//        accRepo.saveAccount(target);
//        transRepo.saveTransaction(new Transaction(new BigDecimal("100"),source,target, Instant.now()));
//        transRepo.saveTransaction(new Transaction(new BigDecimal("200"),target,source, Instant.now()));
//
//        source = new Account(114, "Acc 114");
//        accRepo.saveAccount(source);
//
//        target = new Account(115, "Acc 115");
//        accRepo.saveAccount(target);
//        transRepo.saveTransaction(new Transaction(new BigDecimal("300"),source,target, Instant.now()));


//          List<Transaction>transactions = transRepo.getAllTransactions();
//          transactions.forEach(t ->System.out.println(t.getSource()));
//        List<Account> accounts = accRepo.getAll();
//        accounts.forEach(a -> System.out.println(a.getDescription() + " " + a.getTransactionsWithSource().size()));


    }
}
