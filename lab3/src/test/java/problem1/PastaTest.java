package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PastaTest {
  Pasta pasta;
  @Before
  public void setUp() throws Exception {
    pasta = new Pasta("pasta", 3.5, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorTest() {
    Pasta test = new Pasta("test", 5.5, 251);
  }

  @Test
  public void getName() {
    assertEquals("pasta", pasta.getName());
  }

  @Test
  public void getCurrentPricePerUnt() {
    assertEquals((Double) 3.5, pasta.getCurrentPricePerUnt());
  }

  @Test
  public void getAvailableNum() {
    assertEquals((Integer)20, pasta.getAvailableNum());
  }

  @Test
  public void getMaxAllowed() {
    assertEquals((Integer) 250, pasta.getMaxAllowed());
  }

  @Test
  public void makeOrder() {
    assertEquals((Integer) 35, pasta.makeOrder(10));
  }

  @Test
  public void testEquals() {
    Object o = null;
    assertFalse(pasta.equals(o));
  }

  @Test
  public void testEquals2() {
    Object o = new Object();
    assertFalse(pasta.equals(o));
  }

  @Test
  public void testEquals3() {
    assertTrue(pasta.equals(pasta));
  }

  @Test
  public void testEquals4() {
    Pasta same = new Pasta("pasta", 3.5, 20);
    assertTrue(pasta.equals(same));
  }

  @Test
  public void testEquals5() {
    Pasta same = new Pasta("pasta", 3.0, 20);
    assertFalse(pasta.equals(same));
  }

  @Test
  public void testEquals6() {
    Pasta same = new Pasta("pasta", 3.5, 21);
    assertFalse(pasta.equals(same));
  }

  @Test
  public void testEquals7() {
    Pasta same = new Pasta("pasta1", 3.5, 20);
    assertFalse(pasta.equals(same));
  }

  @Test
  public void testHashCode() {
    Pasta same = new Pasta("pasta1", 3.5, 20);
    assertNotSame(same.hashCode(), pasta.hashCode());
  }
}