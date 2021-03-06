package problem1;

import static org.junit.Assert.*;

import java.time.Clock;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class FruitTest {
  Fruit apple;
  @Before
  public void setUp() throws Exception {
    apple = new Fruit("apple", 1.2, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorTest() {
    Fruit strawBerry = new Fruit("Star Berry", 5.5, 101);
  }

  @Test
  public void makeOrder() {
    assertEquals((Integer) 12, apple.makeOrder(10));
  }

  @Test(expected = IllegalArgumentException.class)
  public void makeOrder2() {
    assertEquals((Integer) 12, apple.makeOrder(12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void orderDate() {
    Clock cl = Clock.systemUTC();
    LocalDate lt = LocalDate.now(cl);
    assertEquals((Integer) 0, apple.orderDate(lt));
  }

  @Test
  public void orderDate2() {
    LocalDate lt = LocalDate.of(2021, 05, 16);
    assertEquals((Integer) 1, apple.orderDate(lt));
  }

  @Test
  public void expirationDate() {
    LocalDate lt = LocalDate.of(2021, 05, 20);
    assertEquals((Integer) 5, apple.ExpirationDate(lt));
  }

  @Test(expected = IllegalArgumentException.class)
  public void expirationDate2() {
    LocalDate lt = LocalDate.now();
    assertEquals((Integer) 5, apple.ExpirationDate(lt));
  }
}