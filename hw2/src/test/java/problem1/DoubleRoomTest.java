package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoubleRoomTest {
  DoubleRoom doubleRoom;
  Amount amount;
  @Before
  public void setUp() throws Exception {
    amount = new Amount(199, 99);
    doubleRoom = new DoubleRoom(amount);
  }
  @Test
  public void constructorTest() throws IllegalPriceException {
    Amount price = new Amount(299, 99);
    doubleRoom = new DoubleRoom(price);
  }
  @Test
  public void isAvailable() {
    assertEquals(true, doubleRoom.isAvailable());
    doubleRoom.bookRoom(2);
    assertEquals(false, doubleRoom.isAvailable());
  }

  @Test
  public void bookRoom() {
    assertEquals(true, doubleRoom.bookRoom(1));

    assertEquals(false, doubleRoom.bookRoom(3));
    assertEquals(false, doubleRoom.bookRoom(-1));
    doubleRoom.bookRoom(1);
    assertEquals(false, doubleRoom.bookRoom(1));
  }
  @Test
  public void bookRoom2() {
    assertEquals(true, doubleRoom.bookRoom(2));
  }
}