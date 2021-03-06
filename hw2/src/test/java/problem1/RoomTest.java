package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {
  private Room room;
  private Amount amount;
  @Before
  public void setUp() throws Exception {
    amount = new Amount(99, 99);
    room = new Room(amount, 1);
  }

  @Test(expected = IllegalPriceException.class)
  public void constructorTest() throws IllegalPriceException {
    Amount amount1 = new Amount(0, 1123);
  }

  @Test(expected = IllegalPriceException.class)
  public void constructorTest2() throws IllegalPriceException {
    Amount amount1 = new Amount(-1, 0);
  }
  @Test(expected = IllegalPriceException.class)
  public void constructorTest3() throws IllegalPriceException {
    Amount amount1 = new Amount(0, -1);
  }

  @Test
  public void isAvailable() {
    assertEquals(true, room.isAvailable());
    room.bookRoom(1);
    assertEquals(false, room.isAvailable());
  }

  @Test
  public void bookRoom() {
    assertEquals(false, room.bookRoom(3));
    assertEquals(true, room.bookRoom(1));
    room.bookRoom(1);
    assertEquals(false, room.bookRoom(1));
  }
  @Test
  public void bookRoom2() {
    assertEquals(false, room.bookRoom(-1));
  }
}