package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AmountTest {
  Amount amount;
  @Before
  public void setUp() throws Exception {
    amount = new Amount(99, 99);
  }


  @Test(expected = IllegalPriceException.class)
  public void constructTest() throws IllegalPriceException {
    amount = new Amount(0, 123);
  }

  @Test(expected = IllegalPriceException.class)
  public void constructorTest2() throws IllegalPriceException {
    amount = new Amount(0, -1);
  }

  @Test(expected = IllegalPriceException.class)
  public void dollarTest() throws IllegalPriceException {
    amount = new Amount(-1, 0);
  }

  @Test
  public void getDollar() {
    assertEquals(99, amount.getDollar());
  }

  @Test
  public void getCents() {
    assertEquals(99, amount.getCents());
  }
}