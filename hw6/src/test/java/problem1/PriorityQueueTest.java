package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
  IPriorityQueue pq;
  @Before
  public void setUp() throws Exception {
    pq = IPriorityQueue.createEmpty();
    pq = pq.add(1, "W");
  }

  @Test
  public void getPriority() {
    PriorityQueue that = (PriorityQueue) pq;
    assertEquals(that.getPriority(), 1);
  }

  @Test
  public void getValue() {
    PriorityQueue that = (PriorityQueue) pq;
    assertEquals(that.getValue(), "W");
  }

  @Test
  public void getRest() {
    PriorityQueue that = (PriorityQueue) pq;
    EmptyPriorityQueue empty = new EmptyPriorityQueue();
    assertEquals(that.getRest(), empty);
  }

  @Test
  public void createEmpty() {
    IPriorityQueue test = IPriorityQueue.createEmpty();
  }

  @Test
  public void isEmpty() {
    assertFalse(pq.isEmpty());
  }

  @Test
  public void add() throws EmptyQueueException {
    pq = pq.add(2, "I");
    assertEquals(pq.peek(), "I");
  }

  @Test
  public void peek() throws EmptyQueueException {
    assertEquals(pq.peek(), "W");
  }

  @Test
  public void pop() throws EmptyQueueException {
    pq = pq.add(6, "WILL");
    pq = pq.pop();
    assertFalse(pq.isEmpty());
    assertEquals(pq.peek(), "W");
  }

  @Test(expected = EmptyQueueException.class)
  public void testPopException() throws EmptyQueueException {
    //test immutability
    pq.pop();
    assertTrue(pq.peek().equals("W"));
    pq = pq.pop();
    assertTrue(pq.isEmpty());
    pq.pop(); //this will throw exception
  }

  @Test
  public void testEquals() {
    assertTrue(pq.equals(pq));
    Object o = null;
    assertFalse(pq.equals(o));
    o = new Object();
    assertFalse(pq.equals(o));
  }

  @Test
  public void testSamePQ() {
    IPriorityQueue test = IPriorityQueue.createEmpty();
    test = test.add(1, "W");
    assertTrue(pq.equals(test));
  }

  @Test
  public void testDiffPQ() {
    IPriorityQueue test = IPriorityQueue.createEmpty();
    test = test.add(2, "W");
    assertTrue(pq.equals(test));
    test = test.add(1, "I");
    assertFalse(pq.equals(test));
    test = test.add(3, "L");
    assertFalse(pq.equals(test));
  }

  @Test
  public void testHashCode() {
    IPriorityQueue test = IPriorityQueue.createEmpty();
    test = test.add(1, "W");
    assertEquals(pq.hashCode(), test.hashCode());
    test = test.add(1, "I");
    test = test.add(3, "L");
    assertFalse(pq.hashCode() == test.hashCode());

  }

  @Test
  public void testToString() {
    IPriorityQueue test = IPriorityQueue.createEmpty();
    //Hello
    test = test.add(1, "o");
    test = test.add(2, "l");
    test = test.add(2, "l");
    test = test.add(3, "e");
    test = test.add(4, "H");
    assertEquals("{priority=4, value='H', "
        + "{priority=3, value='e', {priority=2, value='l', "
        + "{priority=2, value='l', {priority=1, value='o', "
        + "EmptyPriorityQueue{}}}}}}", test.toString());
  }
}