package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LockerTest {
  MailItem mailItem;
  Locker locker;
  Recipient recipient;
  @Before
  public void setUp() throws Exception {
    recipient = new Recipient("John", "Smith", "J.smith@gmail.com");
    mailItem = new MailItem(1, 1, 1, recipient);
    locker = new Locker(3, 3, 3);
  }

  @Test(expected = IllegalLengthException.class)
  public void constructorTest() throws IllegalLengthException {
    locker = new Locker(0, 1, 1);
  }

  @Test(expected = IllegalLengthException.class)
  public void constructorTest2() throws IllegalLengthException {
    locker = new Locker(1, 0, 1);
  }

  @Test(expected = IllegalLengthException.class)
  public void constructorTest3() throws IllegalLengthException {
    locker = new Locker(1, 1, 0);
  }

  @Test
  public void getWidth() {
    assertEquals(3, locker.getWidth());
  }

  @Test
  public void getHeight() {
    assertEquals(3, locker.getHeight());
  }

  @Test
  public void getDepth() {
    assertEquals(3, locker.getDepth());
  }

  @Test
  public void getMailItem() throws IllegalLengthException, LockerOccupiedException {
    MailItem test = new MailItem(1, 1, 1, recipient);
    assertEquals(null, locker.getMailItem());
    locker.addMail(test);
    assertEquals(test, locker.getMailItem());
  }

  @Test
  public void addMail() throws IllegalLengthException, LockerOccupiedException {
    MailItem test = new MailItem(2, 1, 1, recipient);
    locker.addMail(test);
    assertEquals(test, locker.getMailItem());
  }

  @Test(expected = LockerOccupiedException.class)
  public void addMail2() throws IllegalLengthException, LockerOccupiedException {
    MailItem test = new MailItem(2, 1, 1, recipient);
    locker.addMail(test);
    MailItem test2 = new MailItem(2, 2, 1, recipient);
    locker.addMail(test2);
  }

  @Test(expected = IllegalLengthException.class)
  public void addMail3() throws IllegalLengthException, LockerOccupiedException {
    MailItem test = new MailItem(4, 1, 1, recipient);
    locker.addMail(test);
  }

  @Test(expected = IllegalLengthException.class)
  public void addMail4() throws IllegalLengthException, LockerOccupiedException {
    MailItem test = new MailItem(3, 4, 1, recipient);
    locker.addMail(test);
  }

  @Test(expected = IllegalLengthException.class)
  public void addMail5() throws IllegalLengthException, LockerOccupiedException {
    MailItem test = new MailItem(3, 3, 4, recipient);
    locker.addMail(test);
  }

  @Test
  public void pickupMail()
      throws LockerOccupiedException, IllegalLengthException, LockerEmptyException, RecipientNotMatchException {
    MailItem test = new MailItem(1, 1, 1, recipient);
    locker.addMail(mailItem);
    assertEquals(test, locker.pickupMail(recipient));
  }

  @Test(expected = LockerEmptyException.class)
  public void pickupMail2()
      throws LockerOccupiedException, IllegalLengthException, LockerEmptyException, RecipientNotMatchException {
    MailItem test = new MailItem(1, 1, 1, recipient);
    assertNotEquals(test, locker.pickupMail(recipient));
  }

  @Test(expected = RecipientNotMatchException.class)
  public void pickupMail3()
      throws LockerOccupiedException, IllegalLengthException, LockerEmptyException, RecipientNotMatchException {
    Recipient notSameRecipient = new Recipient("Will", "Smith", "J.smith@gmail.com");
    MailItem test = new MailItem(1, 1, 1, notSameRecipient);
    locker.addMail(test);
    assertNotEquals(test, locker.pickupMail(recipient));
  }
}