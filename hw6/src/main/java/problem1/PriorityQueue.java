package problem1;

import java.util.Objects;

/**
 * An non-empty node for a priority queue
 */
public class PriorityQueue implements IPriorityQueue {

  /**
   * Field for non-empty node
   */
  private int priority;
  private String value;
  private IPriorityQueue rest;
  private static int ONE = 1;
  /**
   * This constant is used for hashcode implementation
   */
  private static int PRIME_NUMBER = 31;

  /**
   * Constructor for this Priority Queue node, priority is given element's priority. value is the
   * String of this element. rest is the rest elements in this PQ
   *
   * @param priority given element's priority
   * @param value    this element (string)
   * @param rest     is the rest elements in this PQ
   */
  public PriorityQueue(int priority, String value, IPriorityQueue rest) {
    this.priority = priority;
    this.value = value;
    this.rest = rest;
  }

  /**
   * Getter for current element's priority
   *
   * @return current element's priority
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Getter for current element's value
   *
   * @return current element's value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Getter for rest elements for this PQ
   *
   * @return rest of elements for this PQ
   */
  public IPriorityQueue getRest() {
    return this.rest;
  }


  /**
   * Check if the priority queue is empty. Since this is implementation of non-empty PQ, this will
   * always return false;
   *
   * @return False in this non-empty PQ
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * This method adds the given element (A priority and A value) to the PQ.
   *
   * @param priority an integer represent the priority of given element.
   * @param value    the value of given element. It is String in our implementation.
   * @return A new Priority Queue since this ADT is immutable
   */
  @Override
  public IPriorityQueue add(Integer priority, String value) {
    if (priority.compareTo(this.priority) >= ZERO) {
      return new PriorityQueue(priority, value, this);
    }
    return this.rest.add(priority, value);
  }


  /**
   * Returns the value in the PQ that has the highest priority. Since the add method will guarantee
   * the given PQ first value has highest priority, this method will return this.value
   *
   * @return return the value (String) that has highest priority.
   * @throws EmptyQueueException this exception will be thrown if the Queue is Empty
   */
  @Override
  public String peek() throws EmptyQueueException {
    return this.value;
  }

  /**
   * This method will return a copy of the PQ without the element with highest priority. If multiple
   * element has same priority, we will remove the last element inserted. If the Priority Queue is
   * Empty, EmptyQueueException will be thrown
   *
   * @return A copy of PQ without element with highest priority.
   * @throws EmptyQueueException This exception will be thrown if the Queue is empty
   */
  @Override
  public IPriorityQueue pop() throws EmptyQueueException {
    if (this.rest.isEmpty()) {
      return new EmptyPriorityQueue();
    }
    PriorityQueue that = (PriorityQueue) this.rest;
    return new PriorityQueue(that.getPriority(), that.getValue(), that.getRest());
  }

  /**
   * Override the equals method to compare given object with current Priority Queue. Return true
   * only given object has same element in same insertion order with current PQ.
   *
   * @param o given object to be compared with.
   * @return true if all elements in this PQ is exactly same as given object. False otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PriorityQueue)) {
      return false;
    }
    PriorityQueue that = (PriorityQueue) o;
    if (!this.isEmpty() && !that.isEmpty() && !this.value.equals(that.value)) {
      return false;
    }
    return this.rest.equals(that.rest);
  }

  /**
   * Override hashCode method for current Priority Queue. Generate a unique hashcode for current PQ
   *
   * @return a unique hashcode for current PQ
   */
  @Override
  public int hashCode() {
    int res = PRIME_NUMBER * Objects.hashCode(this.priority);
    res += Objects.hashCode(this.value);
    return res + this.rest.hashCode();
  }

  /**
   * Override toString method for this PQ. Generate String representation of current PQ
   *
   * @return a String representation of current PQ
   */
  @Override
  public String toString() {
    return "{priority=" + this.priority +
        ", value='" + this.value + '\'' +
        ", " + this.rest +
        '}';
  }
}
