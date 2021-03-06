package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RiceTest {
  Rice rice;
  @Before
  public void setUp() throws Exception {
    rice = new Rice("rice", 1.99, 200);
  }

  @Test(expected = IllegalArgumentException.class)
  public void contructorTest() {
    Rice test = new Rice("test", 1.1, 251);
  }
  @Test
  public void makeOrder() {
    assertEquals((Integer) 20, rice.makeOrder(10));
  }
}