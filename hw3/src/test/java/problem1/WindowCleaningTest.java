package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Service.Size;

public class WindowCleaningTest {
  WindowCleaning windowCleaning;
  @Before
  public void setUp() throws Exception {
    windowCleaning = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 2);
  }
  @Test(expected = MaxFloorException.class)
  public void constructorTest() throws MaxFloorException, MinFloorException {
    windowCleaning = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 4);
  }

  @Test
  public void constructorTest2() throws MaxFloorException, MinFloorException {
    windowCleaning = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 1);
  }

  @Test
  public void constructorTest3() throws MaxFloorException, MinFloorException {
    windowCleaning = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 3);
  }

  @Test(expected = MinFloorException.class)
  public void constructorTest4() throws MaxFloorException, MinFloorException {
    windowCleaning = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 0);
  }


  @Test
  public void getHourNeeded() {
    assertEquals(1, windowCleaning.hourNeeded);
  }

  @Test
  public void discount() {
    assertEquals(0.5, windowCleaning.discount(), 0.001);
  }

  @Test
  public void discount2() throws MaxFloorException, MinFloorException {
    WindowCleaning test = new WindowCleaning("12345 WA", Size.SMALL, true, 8, 2);
    assertEquals(0.9, test.discount(), 0.001);
  }

  @Test
  public void discount3() throws MaxFloorException, MinFloorException {
    WindowCleaning test = new WindowCleaning("12345 WA", Size.SMALL, false, 9, 2);
    assertEquals(0.5, test.discount(), 0.001);
  }

  @Test
  public void calculatePrice() {
    assertEquals(42, windowCleaning.calculatePrice(), 0.001);
  }
  @Test
  public void calculatePrice2() throws MaxFloorException, MinFloorException {
    WindowCleaning test = new WindowCleaning("12345 WA", Size.MEDIUM, false, 8, 2);
    assertEquals(168.0, test.calculatePrice(), 0.001);
  }
  @Test
  public void calculatePrice3() throws MaxFloorException, MinFloorException {
    WindowCleaning test = new WindowCleaning("12345 WA", Size.LARGE, false, 8, 2);
    assertEquals(336.0, test.calculatePrice(), 0.001);
  }
  @Test
  public void testEquals() throws MinFloorException, MaxFloorException {
    WindowCleaning test = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 2);
    assertTrue(test.equals(windowCleaning));
  }
  @Test
  public void testDiffClass() throws MinFloorException, MaxFloorException {
    Object o = new Object();
    assertFalse(windowCleaning.equals(o));
    Plumbing test = new Plumbing("12345 Seattle WA", Size.SMALL, false, 9, 2, true);
    assertFalse(windowCleaning.equals(test));
  }
  @Test
  public void testNull() throws MinFloorException, MaxFloorException {
    Object o = null;
    assertFalse(windowCleaning.equals(o));
  }
  @Test
  public void testReflexive() throws MinFloorException, MaxFloorException {
    assertTrue(windowCleaning.equals(windowCleaning));
  }
  @Test
  public void testSame() throws MinFloorException, MaxFloorException {
    WindowCleaning test = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 2);
    assertTrue(windowCleaning.equals(test));
  }
  @Test
  public void testHashCode() throws MinFloorException, MaxFloorException {
    WindowCleaning test = new WindowCleaning("12345 WA", Size.SMALL, true, 9, 2);
    assertNotSame(test.hashCode(), windowCleaning.hashCode());
  }
  @Test
  public void testToString() {
    assertEquals("This Window Cleaning service needs 1 hours, it has 2 floor, with a cost of 42.0", windowCleaning.toString());
  }
}