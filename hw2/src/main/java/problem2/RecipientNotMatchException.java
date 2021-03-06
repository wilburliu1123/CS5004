package problem2;

public class RecipientNotMatchException extends Exception {

  /**
   * RecipientNotMatchException extends Exception class that will throw an exception when the
   * recipient information does not match from an mail item.
   */
  public RecipientNotMatchException() {
    super("Recipient information does not match");
  }
}
