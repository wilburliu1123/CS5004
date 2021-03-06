package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Service.Size;

public class PaintingTest {
  Painting painting;
  @Before
  public void setUp() throws Exception {
    painting = new Painting("12345 Washington State", Size.SMALL, true, 9, 0);
  }
  @Test
  public void constructorTestLargeHouse() {
    Painting test = new Painting("random road", Size.LARGE, false, 9, 0);
  }
  @Test
  public void constructorTestMediumHouse() {
    Painting test = new Painting("random road", Size.MEDIUM, false, 9, 0);
  }
  @Test
  public void calculateFee() {
    assertEquals(1.0, painting.fee, 0.001);
  }

  @Test
  public void discount() {
    assertEquals(0.5, painting.discount(), 0.001);
  }

  @Test
  public void calculatePrice() {
    assertEquals(640.0, painting.calculatePrice(), 0.001);
  }

  @Test
  public void testHashCode() {
    Painting test = new Painting("12345 Washington State", Size.SMALL, true, 9, 0);
    assertSame(test.hashCode(), painting.hashCode());
  }

  @Test
  public void testEquals() {
    Painting test = new Painting("12345 Washington State", Size.SMALL, true, 9, 0);
    assertTrue(painting.equals(test));
  }
  @Test
  public void testDiffHourNeeded() {
    Painting test = new Painting("12345 Washington State", Size.LARGE, true, 9, 0);
    assertFalse(painting.equals(test));
    assertNotEquals(painting.hourNeeded, test.hourNeeded);
  }
  @Test
  public void testMediumSize() {
    Painting test = new Painting("12345 Washington State", Size.MEDIUM, true, 9, 0);
    assertFalse(painting.equals(test));
  }
  @Test
  public void testNull() {
    Object o = null;
    assertFalse(painting.equals(o));
  }
  @Test
  public void testDiffClass() {
    Object o = new Object();
    assertFalse(painting.equals(o));
  }
  @Test
  public void testReflexive() {
    assertTrue(painting.equals(painting));
  }

  @Test
  public void testIsMonthly() {
    Interior test = new Painting("12345 Washington State", Size.SMALL, false, 9, 0);
    assertFalse(painting.equals(test));
  }
  @Test
  public void testSuper() {
    Interior test = new Painting("12345 Washington State", Size.SMALL, false, 9, 0);
    assertEquals(test, test);
    assertFalse(test.equals(""));
  }

  @Test
  public void testDiffNumOfServices() {
    Painting test = new Painting("12345 Washington State", Size.SMALL, true, 8, 0);
    assertFalse(painting.equals(test));
  }
  @Test
  public void testDiffNumOfPets() {
    Painting test = new Painting("12345 Washington State", Size.SMALL, true, 9, 1);
    assertFalse(painting.equals(test));
  }

  @Test
  public void testDiffAddress() {
    Painting test = new Painting("123456 Washington State", Size.SMALL, true, 9, 0);
    assertFalse(painting.equals(test));
  }

  @Test
  public void testSuperClass() {
    Service test = new Painting("123456 Washington State", Size.SMALL, true, 9, 0);
    assertTrue(test.equals(test));
    assertFalse(test.equals("test"));
  }

  @Test
  public void testDiffHour() {
    Painting test = new Painting("123456 Washington State", Size.LARGE, true, 9, 0);
    assertFalse(painting.equals(test));
  }

  @Test
  public void testToString() {
    assertEquals("Painting{pets=0, hourNeeded=16, address='12345 Washington State', propertySize=SMALL, isMonthly=true, previousServices=9}", painting.toString());
  }
}