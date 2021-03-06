package lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PosnTest {
  Posn posn;
  @Before
  public void setUp() throws Exception {
    posn = new Posn(1,2);
  }

  @Test
  public void getX() {
    assertEquals((Integer) 1, posn.getX());
  }

  @Test
  public void getY() {
    assertEquals((Integer) 2, posn.getY());
  }

  @Test
  public void testEquals() {
    Posn test = new Posn(1, 2);
    assertTrue(test.equals(posn));
    assertTrue(posn.equals(posn));
    Name o = new Name("random", "??");
    assertFalse(posn.equals(o));
    Posn test2 = new Posn(3, 2);
    assertFalse(posn.equals(test2));
  }

  @Test
  public void testHashCode() {
    Posn test2 = new Posn(1, 2);
    assertEquals(test2.hashCode(), posn.hashCode());
  }
  @Test
  public void testString() {
    assertEquals("Posn{x=1, y=2}", posn.toString());
  }
}