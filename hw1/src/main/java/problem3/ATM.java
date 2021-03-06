package problem3;

import java.util.*;

/**
 * Trip is a simple object that has a list of account that is stored in it and deposit and withdraw functionality.
 */
public class ATM {
    private List<Account> accounts;
    /**
     * Constructor that creates a new ATM object with list of accounts that are being stored in it.
     *
     * @param accounts - a list of accounts stored in this ATM.
     */
    public ATM(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * this method returns a new Account object when deposit is requested.
     *
     * @return A new Account object that is being deposited.
     */
    public Account deposit(Account account, Amount amount) {
        return account.deposit(amount);
    }

    /**
     * this method returns a new Account object when withdraw is requested.
     *
     * @return A new Account object that is being withdraw.
     */
    public Account withdraw(Account account, Amount amount) {
        return account.withdraw(amount);
    }
}
