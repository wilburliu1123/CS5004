package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Service.Size;

public class GardeningTest {
  Gardening gardening;
  @Before
  public void setUp() throws Exception {
    gardening = new Gardening("12345 Seattle WA", Size.SMALL, true, 8);
  }

  @Test
  public void calculatePrice() {
    assertEquals(92.0, gardening.calculatePrice(), 0.0001);
  }
  @Test
  public void testHashCode() {
    Gardening test = new Gardening("12345 Seattle WA", Size.SMALL, true, 8);
    assertSame(test.hashCode(), gardening.hashCode());
  }

  @Test
  public void testEquals() {
    Gardening test = new Gardening("12345 Seattle WA", Size.SMALL, true, 8);
    assertTrue(gardening.equals(test));
  }
  @Test
  public void testNull() {
    Object o = null;
    assertFalse(gardening.equals(o));
  }
  @Test
  public void testDiffClass() {
    Object o = new Object();
    assertFalse(gardening.equals(o));
  }
  @Test
  public void testReflexive() {
    assertTrue(gardening.equals(gardening));
  }

  @Test
  public void testToString() {
    assertEquals("Gardening{hourNeeded=1, address='12345 Seattle WA', propertySize=SMALL, isMonthly=true, previousServices=8}", gardening.toString());
  }
  
}