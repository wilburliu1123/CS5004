package problem3;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class ATMTest {
    private List<Account> testList;
    private Amount amount1, amount2, amount3;
    private Account account1, account2, account3;
    private ATM atm;
    @Before
    public void setUp() throws Exception {
        amount1 = new Amount(1110, 99);
        amount2 = new Amount(311100, 13);
        amount3 = new Amount(1_000_000_000, 99);
        account1 = new Account("Joe", "Wood", amount1);
        account2 = new Account("Steve", "Hawkins", amount2);
        account3 = new Account("Richman", "Golden", amount3);
        testList = new ArrayList<>();
        testList.add(account1);
        testList.add(account2);
        testList.add(account3);
        atm = new ATM(testList);
    }

    @Test
    public void deposit() {
        Amount amount = new Amount(100, 0);
        Account verify = atm.deposit(account1, amount);
        assertEquals(1210, verify.getDollarAmount());
        amount = new Amount(0, 1);
        verify = atm.deposit(account1, amount);
        assertEquals(1111, verify.getDollarAmount());
        assertEquals(0, verify.getCentsAmount());
        amount = new Amount(99, 95);
        verify = atm.deposit(account2, amount);
        assertEquals(311200, verify.getDollarAmount());
        assertEquals(8, verify.getCentsAmount());
    }

    @Test
    public void withdraw() {
        Amount amount = new Amount(11100, 13);
        Account verify = atm.withdraw(account2, amount);
        assertEquals(311100, account2.getDollarAmount());
        assertEquals(300000, verify.getDollarAmount());
        assertEquals(0, verify.getCentsAmount());
        amount = new Amount(99, 99);
        verify = atm.withdraw(account2, amount);
        assertEquals(14, verify.getCentsAmount());
        assertEquals(311000, verify.getDollarAmount());
    }
}