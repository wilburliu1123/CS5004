package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Service.Size;

public class InteriorCleaningTest {
  InteriorCleaning interiorCleaning;
  @Before
  public void setUp() throws Exception {
    interiorCleaning = new InteriorCleaning("12345 Washinton State", Size.SMALL, true, 7, 0);
  }

  @Test
  public void testMediumSize() {
    InteriorCleaning test = new InteriorCleaning("12345 Washinton State", Size.MEDIUM, true, 7, 2);
  }

  @Test
  public void testLargeSize() {
    InteriorCleaning test = new InteriorCleaning("12345 Washinton State", Size.LARGE, true, 7, 3);
  }

  @Test
  public void discount() {
    assertEquals(0.9, interiorCleaning.discount(), 0.001);
  }
  @Test
  public void testBothMonthlyAnd10thService() {
    interiorCleaning = new InteriorCleaning("12345 Washinton State", Size.SMALL, true, 9, 0);
    assertEquals(0.5, interiorCleaning.discount(), 0.001);
  }
  @Test
  public void testNoDiscount() {
    interiorCleaning = new InteriorCleaning("12345 Washinton State", Size.SMALL, false, 11, 0);
    assertEquals(1.0, interiorCleaning.discount(), 0.001);
  }
  @Test
  public void test10thService() {
    interiorCleaning = new InteriorCleaning("12345 Washinton State", Size.SMALL, false, 9, 0);
    assertEquals(0.5, interiorCleaning.discount(), 0.001);
  }
  @Test
  public void calculatePrice() {
    assertEquals(72.0, interiorCleaning.calculatePrice(), 0.001);
  }
  @Test
  public void testHashCode() {
    InteriorCleaning test = new InteriorCleaning("12345 Washinton State", Size.SMALL, true, 7, 0);
    assertNotSame(test.hashCode(), interiorCleaning.hashCode());
  }

  @Test
  public void testEquals() {
    InteriorCleaning test = new InteriorCleaning("12345 Washinton State", Size.SMALL, true, 7, 0);
    assertTrue(test.equals(interiorCleaning));
  }
  @Test
  public void testNull() {
    Object o = null;
    assertFalse(interiorCleaning.equals(o));
  }
  @Test
  public void testDiffClass() {
    Object o = new Object();
    assertFalse(interiorCleaning.equals(o));
  }
  @Test
  public void testReflexive() {
    assertTrue(interiorCleaning.equals(interiorCleaning));
  }

  @Test
  public void testSuper() {
    Service test = new InteriorCleaning("123456 Washinton State", Size.SMALL, true, 7, 0);
    assertFalse(interiorCleaning.equals(test));
  }

  @Test
  public void testToString() {
    assertEquals("InteriorCleaning{pets=0, hourNeeded=1, address='12345 Washinton State', propertySize=SMALL, isMonthly=true, previousServices=7}", interiorCleaning.toString());
  }
}