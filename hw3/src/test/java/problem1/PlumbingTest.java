package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Service.Size;

public class PlumbingTest {
  Plumbing plumbing;
  @Before
  public void setUp() throws Exception {
    plumbing = new Plumbing("12345 Seattle WA", Size.SMALL, false, 8, 2, true);
  }

  @Test
  public void constructorTest() {
    Plumbing test = new Plumbing("12345 Seattle WA", Size.SMALL, false, 8, 0, true);
  }
  @Test
  public void testMeetMinRequirement() {
    Plumbing test = new Plumbing("12345 Seattle WA", Size.SMALL, false, 8, 1, false);
  }
  @Test
  public void calculatePrice() {
    assertEquals(420.0, plumbing.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice2() {
    Plumbing test = new Plumbing("12345 Seattle WA", Size.SMALL, false, 9, 2, true);
    assertEquals(420.0, test.calculatePrice(), 0.001);
  }

  @Test
  public void testHashCode() {
    Plumbing test = new Plumbing("12345 Seattle WA", Size.SMALL, false, 9, 2, true);
    assertNotSame(test.hashCode(), plumbing.hashCode());
  }

  @Test
  public void testEquals() {
    Plumbing test = new Plumbing("12345 Seattle WA", Size.SMALL, false, 9, 2, true);
    assertTrue(plumbing.equals(test));
  }
  @Test
  public void testNull() {
    Object o = null;
    assertFalse(plumbing.equals(o));
  }
  @Test
  public void testDiffClass() {
    Object o = new Object();
    assertFalse(plumbing.equals(o));
  }
  @Test
  public void testReflexive() {
    Object o = new Object();
    assertTrue(plumbing.equals(plumbing));
  }

  @Test
  public void testToString() {
    assertEquals("PlumbingService{address='12345 Seattle WA', propertySize=SMALL, isMonthly=false, previousServices=8, numberOfLicensedEmployee=2, isComplexWork=true}", plumbing.toString());
  }

}