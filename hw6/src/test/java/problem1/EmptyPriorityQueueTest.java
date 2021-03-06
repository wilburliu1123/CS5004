package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyPriorityQueueTest {
  IPriorityQueue pq;
  @Before
  public void setUp() throws Exception {
    pq = IPriorityQueue.createEmpty();
  }

  @Test
  public void createEmpty() {
    assertTrue(pq.isEmpty());
  }


  @Test
  public void isEmpty() {
    pq = pq.add(1, "W");
    assertFalse(pq.isEmpty());
  }

  @Test
  public void add() throws EmptyQueueException {
    IPriorityQueue test = pq.add(1, "w");
    pq.add(2, "W");
    assertEquals(test.peek(), "w");
    // test immutability
    assertTrue(pq.isEmpty());
  }


  @Test(expected = EmptyQueueException.class)
  public void peek() throws EmptyQueueException {
    pq.peek();
  }

  @Test
  public void pop() throws EmptyQueueException {
    pq = pq.add(1, "w");
    pq = pq.pop();
    assertTrue(pq.isEmpty());
  }

  @Test(expected = EmptyQueueException.class)
  public void testPopException() throws EmptyQueueException {
    pq.pop();
  }

  @Test
  public void testHashCode() {
    assertEquals(pq.hashCode(), 53);
  }

  @Test
  public void testEquals() {
    Object o = null;
    assertFalse(pq.equals(o));
    o = new Object();
    assertFalse(pq.equals(o));
    IPriorityQueue test = IPriorityQueue.createEmpty();
    assertTrue(pq.equals(test));
    assertTrue(pq.equals(pq));
  }

  @Test
  public void testToString() {
    assertTrue(pq.toString().equals("EmptyPriorityQueue{}"));
  }
}