package problem1;

import static org.junit.Assert.*;

import java.time.Clock;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class VegetableTest {
  Vegetable spinach;
  @Before
  public void setUp() throws Exception {
    spinach = new Vegetable("Spinach", 4.5, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorTest() {
    Vegetable test = new Vegetable("test", 10.1, 101);
  }

  @Test(expected = IllegalArgumentException.class)
  public void orderDate() {
    Clock cl = Clock.systemUTC();
    LocalDate lt = LocalDate.now(cl);
    assertEquals((Integer) 0, spinach.orderDate(lt));
  }

  @Test
  public void orderDate2() {
    LocalDate lt = LocalDate.of(2021, 05, 15);
    assertEquals((Integer) 0, spinach.orderDate(lt));
  }

  @Test(expected = IllegalArgumentException.class)
  public void expirationDate() {
    Clock cl = Clock.systemUTC();
    LocalDate lt = LocalDate.now(cl);
    assertEquals((Integer) 0, spinach.ExpirationDate(lt));
  }

  @Test
  public void expirationDate2() {
    LocalDate lt = LocalDate.of(2021, 05, 15);
    assertEquals((Integer) 0, spinach.ExpirationDate(lt));
  }


  @Test
  public void makeOrder() {
    assertEquals((Integer) 45, spinach.makeOrder(10));
  }

  @Test(expected = IllegalArgumentException.class)
  public void makeOrder2() {
    assertEquals((Integer) 45, spinach.makeOrder(101));
  }

  @Test(expected = IllegalArgumentException.class)
  public void makeOrder3() {
    Vegetable test = new Vegetable("Spinach", 4.5, 90);
    assertEquals((Integer) 45, spinach.makeOrder(101));
  }

}