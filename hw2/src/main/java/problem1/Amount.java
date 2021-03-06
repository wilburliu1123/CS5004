package problem1;

import problem2.IllegalLengthException;

public class Amount {
  private int dollar;
  private int cents;
  private static final int MIN_AMOUNT = 0;
  private static final int MAX_AMOUNT = 99;
  /**
   * Amount class for store dollar and cents. Exception will be thrown if the dollar or cents is
   * less than 0, or cents is greater than 99
   * @param dollar dollar amount
   * @param cents cents amount
   * @throws IllegalPriceException if dollar or cents is less than 0, or cents are greater than 99,
   * this IllegalPriceException will be thrown
   */
  public Amount(int dollar, int cents) throws IllegalPriceException {
    if (dollar < MIN_AMOUNT || cents < MIN_AMOUNT || cents > MAX_AMOUNT) {
      throw new IllegalPriceException();
    }
    this.dollar = dollar;
    this.cents = cents;
  }

  /**
   * getter for amount class
   * @return dollar
   */
  public int getDollar() {
    return this.dollar;
  }

  /**
   * getter for cents
   * @return cents
   */
  public int getCents() {
    return this.cents;
  }

}
