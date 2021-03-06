package problem3;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;
    private Amount amount;
    @Before
    public void setUp() throws Exception {
        amount = new Amount(1000, 0);
        account = new Account("Wilbur", "Liu", amount);
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void constructorTest() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("dollar amount needs to be positive");
        amount = new Amount(-1100, 99);
        account = new Account("", "", amount);
    }
    @Test
    public void constructorTest2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("cents amount needs to between 0 and 99");
        amount = new Amount(1100, 1110);
        account = new Account("", "", amount);
    }

    @Test
    public void getFirstName() {
        assertEquals("Wilbur", account.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Liu", account.getLastName());
    }

    @Test
    public void getDollarAmount() {
        assertEquals(1000, account.getDollarAmount());
    }

    @Test
    public void getCentsAmount() {
        assertEquals(0, account.getCentsAmount());
    }

    @Test
    public void deposit() {
        Amount amount = new Amount(100, 23);
        Account res = account.deposit(amount);
        assertEquals(1100, res.getDollarAmount());
        assertEquals(23, res.getCentsAmount());
    }
    @Test
    public void withdraw() {
        Amount amount = new Amount(99, 99);
        Account res = account.withdraw(amount);
        assertEquals(900, res.getDollarAmount());
        assertEquals(1, res.getCentsAmount());
    }
}