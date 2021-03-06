package problem1;

/**
 * This is an customized Exception that will be thrown if the Queue is empty and we try to peek at
 * it
 */
public class EmptyQueueException extends Exception{

  /**
   * Constructor for this exception
   */
  public EmptyQueueException() {
    super("Current PriorityQueue is Empty.");
  }
}
