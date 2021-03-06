package problem2;

public class IllegalLengthException extends Exception {

  /**
   * IllegalLengthException extends Exception class that will throw a message when the length is not
   * greater or equal to 1
   */
  public IllegalLengthException() {
    super("The length you entered must be greater or equal to 1");
  }
}
