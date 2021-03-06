package problem3;
/**
 * Account is a simple object that has first name, last name of the owner and its dollar and cents in its balance
 */
public class Account {
    private String firstName;
    private String lastName;
    private Amount balance;
    private static final int DOLLAR_UNIT = 100;
    private static final int MIN_BALANCE = 0;
    private static final int MAX_CENTS = 99;
    /**
     * Constructor that creates a new Account object with firstName and lastName of the account owner
     * dollar and cents amount stored in this account.
     * @param firstName - first name of this account owner.
     * @param lastName - last name of this account owner.
     * @param balance - Amount of this account's balance.
     */

    public Account(String firstName, String lastName, Amount balance) {
        if (balance.getDollar() < MIN_BALANCE) {
            throw new IllegalArgumentException("dollar amount needs to be positive");
        } else if (balance.getCents() < MIN_BALANCE || balance.getCents() > MAX_CENTS) {
            throw new IllegalArgumentException("cents amount needs to between 0 and 99");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    /**
     * return first name of this account owner
     * @return the first name of this account owner.
     * */
    public String getFirstName() {
        return firstName;
    }
    /**
     * return last name of this account owner
     * @return the last name of this account owner.
     * */
    public String getLastName() {
        return lastName;
    }
    /**
     * return dollar amount of this account.
     * @return the dollar amount of this account.
     * */
    public int getDollarAmount() {
        return balance.getDollar();
    }
    /**
     * return cents amount of this account.
     * @return the cents amount of this account.
     * */
    public int getCentsAmount() {
        return balance.getCents();
    }
    /**
     * this method returns a new Account object when deposit is requested.
     *
     * @return A new Account object that is being deposited.
     */
    public Account deposit(Amount amount) {
        int finalDollar = balance.getDollar() + amount.getDollar() + (balance.getCents() + amount.getCents()) / DOLLAR_UNIT;
        int finalCents = (balance.getCents() + amount.getCents()) % DOLLAR_UNIT;
        Amount finalAmount = new Amount(finalDollar, finalCents);
        return new Account(firstName, lastName, finalAmount);
    }

    /**
     * this method returns a new Account object when withdraw is requested.
     *
     * @return A new Account object that is being withdraw.
     */
    public Account withdraw(Amount amount) {
        int finalDollar = balance.getDollar() - amount.getDollar();
        int finalCents = balance.getCents() - amount.getCents();
        if (finalCents < MIN_BALANCE) {
            finalDollar--;
            finalCents += DOLLAR_UNIT;
        }
        Amount finalAmount = new Amount(finalDollar, finalCents);
        return new Account(firstName, lastName, finalAmount);
    }
}
