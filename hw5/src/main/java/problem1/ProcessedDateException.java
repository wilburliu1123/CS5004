package problem1;

public class ProcessedDateException extends Exception {


  /**
   * Constructs a new exception with "Processed date is earlier than creation date" as its detail
   * message.
   */
  public ProcessedDateException() {
    super("Processed date is earlier than creation date");
  }
}
