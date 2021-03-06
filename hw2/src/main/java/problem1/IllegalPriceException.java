package problem1;

public class IllegalPriceException extends Exception {
  /**
   * Inherited from exception class this will throw an exception if the input for price is invalid
   */
  public IllegalPriceException() {
    super("Input price is invalid, must be greater than 0");
  }
}
