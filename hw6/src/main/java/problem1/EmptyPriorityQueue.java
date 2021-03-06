package problem1;

/**
 * This is an empty node for priority queue
 */
public class EmptyPriorityQueue implements IPriorityQueue {

  /**
   * This constant is used for hashcode implementation
   */
  private static int PRIME_NUMBER = 53;


  /**
   * Check if the priority queue is empty. Returns true if the PQ is empty. False otherwise
   *
   * @return true if PQ contains no elements. False otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * This method adds the given element (A priority and A value) to the PQ.
   *
   * @param priority an integer represent the priority of given element.
   * @param value the value of given element. It is String in our implementation.
   * @return A new Priority Queue since this ADT is immutable
   */
  @Override
  public IPriorityQueue add(Integer priority, String value) {
    return new PriorityQueue(priority, value, this);
  }

  /**
   * Since this is empty priority Queue, it will always throw this exception
   *
   * @return return the value (String) that has highest priority.
   * @throws EmptyQueueException this exception will be thrown if the Queue is Empty
   */
  @Override
  public String peek() throws EmptyQueueException {
    throw new EmptyQueueException();
  }

  /**
   * Since this is an empty PQ, we will always throw EmptyQueueException
   * This method will return a copy of the PQ without the element with highest priority. If multiple
   * element has same priority, we will remove the last element inserted. If the Priority Queue is
   * Empty, EmptyQueueException will be thrown
   *
   * @return A copy of PQ without element with highest priority.
   * @throws EmptyQueueException This exception will be thrown if the Queue is empty
   */
  @Override
  public IPriorityQueue pop() throws EmptyQueueException {
    throw new EmptyQueueException();
  }

  /**
   * Override hashCode method to generate a hashcode for this current Empty Queue. 53 is chosen for
   * this hashcode
   * @return 53 as its hashcode
   */
  @Override
  public int hashCode() {
    return PRIME_NUMBER;
  }

  /**
   * Override equals method to compare given object to this empty PQ.
   * @param o given object
   * @return true if given object is an empty PQ. False otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    EmptyPriorityQueue obj = (EmptyPriorityQueue) o;
    return obj.isEmpty();
  }

  /**
   * Implement toString method
   * @return A string representation of this empty PQ
   */
  @Override
  public String toString() {
    return "EmptyPriorityQueue{}";
  }
}
