package problem3;

public class Amount {
    private int dollar;
    private int cents;
    /**
     * Constructor that creates a new Amount object with dollar and cents.
     * @param dollar - first name of this account owner.
     * @param cents - last name of this account owner.
     */
    public Amount(int dollar, int cents) {
        this.dollar = dollar;
        this.cents = cents;
    }
    /**
     * return dollar amount
     * @return dollar amount.
     * */
    public int getDollar() {
        return dollar;
    }
    /**
     * return cents amount
     * @return cents amount.
     * */
    public int getCents() {
        return cents;
    }


}
