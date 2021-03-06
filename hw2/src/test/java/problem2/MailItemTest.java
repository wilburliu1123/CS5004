package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailItemTest {
  MailItem mailItem;
  Recipient recipient;
  @Before
  public void setUp() throws Exception {
    recipient = new Recipient("William", "Smith", "Will.Smith@gmail.com");
    mailItem = new MailItem(1, 1, 1, recipient);
  }

  @Test(expected = IllegalLengthException.class)
  public void constructorTest() throws IllegalLengthException {
    mailItem = new MailItem(0, 1, 1, recipient);
  }

  @Test(expected = IllegalLengthException.class)
  public void constructorTest2() throws IllegalLengthException {
    mailItem = new MailItem(1, 0, 1, recipient);
  }
  @Test(expected = IllegalLengthException.class)
  public void constructorTest3() throws IllegalLengthException {
    mailItem = new MailItem(1, 1,0, recipient);
  }
  @Test
  public void getWidth() {
    assertEquals(1, mailItem.getWidth());
  }

  @Test
  public void getHeight() {
    assertEquals(1, mailItem.getHeight());
  }

  @Test
  public void getDepth() {
    assertEquals(1, mailItem.getDepth());
  }

  @Test
  public void getRecipient() {
    Recipient test = new Recipient("William", "Smith", "Will.Smith@gmail.com");
    assertEquals(test, mailItem.getRecipient());
  }
  @Test
  public void testEquals() throws IllegalLengthException {
    Recipient testR = new Recipient("William", "Smith", "Will.Smith@gmail.com");
    MailItem test = new MailItem(1,1,1, testR);
    assertEquals(test, mailItem);
  }

  @Test
  public void testEquals2() throws IllegalLengthException {
    assertEquals(mailItem, mailItem);
  }

  @Test
  public void testEquals3() throws IllegalLengthException {
    Object o = null;
    assertFalse(mailItem.equals(o));
  }

  @Test
  public void testEquals4() throws IllegalLengthException {
    Object o = new Object();
    assertFalse(mailItem.equals(o));
  }

  @Test
  public void testEquals5() throws IllegalLengthException {
    Recipient testR = new Recipient("William", "Smith", "Will.Smith@gmail.com");
    MailItem test = new MailItem(2,1,1, testR);
    assertNotEquals(test, mailItem);
  }

  @Test
  public void testEquals6() throws IllegalLengthException {
    Recipient testR = new Recipient("William", "Smith", "Will.Smith@gmail.com");
    MailItem test = new MailItem(1,2,1, testR);
    assertNotEquals(test, mailItem);
  }

  @Test
  public void testEquals7() throws IllegalLengthException {
    Recipient testR = new Recipient("William", "Smith", "Will.Smith@gmail.com");
    MailItem test = new MailItem(1,1,2, testR);
    assertNotEquals(test, mailItem);
  }

  @Test
  public void testEquals8() throws IllegalLengthException {
    Recipient testR = new Recipient("William1", "Smith", "Will.Smith@gmail.com");
    MailItem test = new MailItem(1,1,1, testR);
    assertNotEquals(test, mailItem);
  }

  @Test
  public void testHashCode() throws IllegalLengthException {
    Recipient testR = new Recipient("William", "Smith", "Will.Smith@gmail.com");
    MailItem test = new MailItem(1,1,1, testR);
    assertNotSame(test.hashCode(), mailItem);
  }
}