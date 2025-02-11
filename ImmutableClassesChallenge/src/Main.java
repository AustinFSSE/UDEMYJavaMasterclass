
import dev.alm.BankAccount;
import dev.alm.BankCustomer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        BankAccount account =
//                new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

        BankCustomer joe = new BankCustomer("Joe", 500, 10000);
        System.out.println(joe);

        // accounts.clear() will not clear because BankAccount instantiation is not public.
        // meaning once the bank account is instantiated we will not be able to directly
        // manipulate the method with out providing methods to facilitate this
        List <BankAccount> accounts = joe.getAccounts();
        accounts.clear();
        System.out.println(joe);

    }
}