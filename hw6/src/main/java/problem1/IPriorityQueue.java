package problem1;

/**
 * Interface for Priority Queue ADT.
 */
public interface IPriorityQueue {

  /**
   * A constant that will be used for class that implements this interface
   */
  static int ZERO = 0;

  /**
   * Static method that will create an empty PQ.
   *
   * @return an Empty priorityQueue
   */
  static IPriorityQueue createEmpty() {
    return new EmptyPriorityQueue();
  }

  /**
   * Check if the priority queue is empty. Returns true if the PQ is empty. False otherwise
   *
   * @return true if PQ contains no elements. False otherwise.
   */
  Boolean isEmpty();

  /**
   * This method adds the given element (A priority and A value) to the PQ.
   *
   * @param priority an integer represent the priority of given element.
   * @param value    the value of given element. It is String in our implementation.
   * @return A new Priority Queue since this ADT is immutable
   */
  IPriorityQueue add(Integer priority, String value);

  /**
   * Returns the value in the PQ that has the highest priority.
   *
   * @return return the value (String) that has highest priority.
   * @throws EmptyQueueException this exception will be thrown if the Queue is Empty
   */
  String peek() throws EmptyQueueException;

  /**
   * This method will return a copy of the PQ without the element with highest priority. If multiple
   * element has same priority, we will remove the last element inserted. If the Priority Queue is
   * Empty, EmptyQueueException will be thrown
   *
   * @return A copy of PQ without element with highest priority.
   * @throws EmptyQueueException This exception will be thrown if the Queue is empty
   */

  IPriorityQueue pop() throws EmptyQueueException;


}
