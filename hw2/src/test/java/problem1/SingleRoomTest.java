package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SingleRoomTest {
  private SingleRoom room;
  private Amount amount;
  @Before
  public void setUp() throws Exception {
    amount = new Amount(199, 99);
    room = new SingleRoom(amount);
  }

  @Test
  public void constructorTest() throws IllegalPriceException {
    Amount amount1 = new Amount(299, 19);
    room = new SingleRoom(amount1);
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