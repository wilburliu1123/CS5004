package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class MeatTest {
  Meat chicken;
  @Before
  public void setUp() throws Exception {
    chicken = new Meat("Chicken", 5.5, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorTest() {
    Meat beaf = new Meat("Beaf", 10.99, 101);
  }

  @Test
  public void makeOrder() {
    assertEquals((Integer) 55, chicken.makeOrder(10));
  }

  @Test(expected = IllegalArgumentException.class)
  public void makeOrder2() {
    assertEquals((Integer) 275, chicken.makeOrder(50));
  }

  @Test(expected = IllegalArgumentException.class)
  public void makeOrder3() {
    chicken.makeOrder(101);
  }

  @Test
  public void orderDate() {
    LocalDate lt = LocalDate.of(2021, 05, 16);
    assertEquals((Integer) 1, chicken.orderDate(lt));
  }

  @Test(expected = IllegalArgumentException.class)
  public void orderDate2() {
    LocalDate lt = LocalDate.now();
    assertEquals((Integer) 1, chicken.orderDate(lt));
  }

  @Test
  public void expirationDate() {
    LocalDate lt = LocalDate.of(2021, 05, 16);
    assertEquals((Integer) 1, chicken.ExpirationDate(lt));
  }

  @Test(expected = IllegalArgumentException.class)
  public void expirationDate2() {
    LocalDate lt = LocalDate.now();
    assertEquals((Integer) 1, chicken.ExpirationDate(lt));
  }

}