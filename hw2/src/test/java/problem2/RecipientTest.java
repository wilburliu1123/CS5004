package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {
  Recipient recipient;
  @Before
  public void setUp() throws Exception {
    recipient = new Recipient("Steve", "Hawkin", "Steve.Hawkin@gmail.com");
  }

  @Test
  public void getFirstName() {
    assertEquals("Steve", recipient.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Hawkin", recipient.getLastName());
  }

  @Test
  public void getEmailAddress() {
    assertEquals("Steve.Hawkin@gmail.com", recipient.getEmailAddress());
  }

  @Test
  public void testEquals() {
    Recipient test = new Recipient("Steve", "Hawkin", "Steve.Hawkin@gmail.com");
    assertEquals(test, recipient);
  }

  @Test
  public void testEquals0() {
    Recipient test = new Recipient("Steve1", "Hawkin", "Steve.Hawkin@gmail.com");
    assertNotEquals(test, recipient);
  }

  @Test
  public void testEquals1() {
    Recipient test = new Recipient("Steve", "random", "Steve.Hawkin@gmail.com");
    assertNotEquals(test, recipient);
  }
  @Test
  public void testEquals2() {
    Recipient test = new Recipient("Steve", "Hawkin", "Steve.Hawkin1@gmail.com");
    assertNotEquals(test, recipient);
  }

  @Test
  public void testEquals3() {
    assertEquals(recipient, recipient);
  }

  @Test
  public void testEquals4() {
    Object o = null;
    assertFalse(recipient.equals(o));
  }

  @Test
  public void testEquals5() {
    Object o = new Object();
    assertFalse(recipient.equals(o));
  }

  @Test
  public void testHashCode() {
    Recipient test = new Recipient("Steve", "Hawkin", "Steve.Hawkin@gmail.com");
    assertNotSame(test.hashCode(), recipient.hashCode());
  }
}