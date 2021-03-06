package problem1;

public class InvalidIndexException extends Exception{

  /**
   * Constructs a new InvalidIndexException if the CourseCatalog does not have the index given.
   */
  public InvalidIndexException() {
    super("This index doesn't exist in the CourseCatalog");
  }
}
