package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FamilyRoomTest {
  FamilyRoom familyRoom;
  Amount amount;
  @Before
  public void setUp() throws Exception {
    amount = new Amount(299, 99);
    familyRoom = new FamilyRoom(amount);
  }

  @Test
  public void constructorTest() throws IllegalPriceException {
    Amount amount1 = new Amount(399, 99);
    familyRoom = new FamilyRoom(amount1);
  }

  @Test
  public void isAvailable() {
    assertEquals(true, familyRoom.isAvailable());
    familyRoom.bookRoom(4);
    assertEquals(false, familyRoom.isAvailable());
  }

  @Test
  public void bookRoom() {
    assertEquals(true, familyRoom.bookRoom(1));
  }
  @Test
  public void bookRoom2() {
    assertEquals(true, familyRoom.bookRoom(2));
  }
  @Test
  public void bookRoom3() {
    assertEquals(false, familyRoom.bookRoom(5));
    assertEquals(true, familyRoom.bookRoom(4));
  }

  @Test
  public void bookRoom4() {
    assertEquals(false, familyRoom.bookRoom(-1));
    assertEquals(true, familyRoom.bookRoom(3));
  }
  @Test
  public void bookRoom5() {
    familyRoom.bookRoom(1);
    assertEquals(false, familyRoom.bookRoom(1));
  }
}