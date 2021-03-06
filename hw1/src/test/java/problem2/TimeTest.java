package problem2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TimeTest {

  private Time time;

  @Before
  public void setUp() throws Exception {
    time = new Time(10, 0, 0);
  }

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void constructorTest() throws Exception {
    exceptionRule.expect(Exception.class);
    exceptionRule.expectMessage("Wrong seconds input, seconds needs to between 0 and 59");
    Time test = new Time(4, 8, -55);
    exceptionRule.expect(Exception.class);
    exceptionRule.expectMessage("Wrong hour input, hour needs to between 0 and 23");
    test = new Time(24, 0, 0);
    exceptionRule.expect(Exception.class);
    exceptionRule.expectMessage("Wrong minutes input, minutes needs to between 0 and 59");
    test = new Time(4, 61, 0);
  }

  @Test
  public void getHour() {
    assertEquals(10, time.getHour());
  }

  @Test
  public void setHour() throws Exception {
    time.setHour(12);
    assertEquals(12, time.getHour());
    exceptionRule.expect(Exception.class);
    exceptionRule.expectMessage("Wrong hour input, hour needs to between 0 and 23");
    time.setHour(24);
  }

  @Test
  public void getMinutes() {
    assertEquals(0, time.getMinutes());
  }

  @Test
  public void setMinutes() throws Exception {
    time.setMinutes(59);
    assertEquals(59, time.getMinutes());
    exceptionRule.expect(Exception.class);
    exceptionRule.expectMessage("Wrong minutes input, minutes needs to between 0 and 59");
    time.setMinutes(60);
  }

  @Test
  public void getSeconds() {
    assertEquals(0, time.getSeconds());
  }

  @Test
  public void setSeconds() throws Exception {
    time.setSeconds(33);
    assertEquals(33, time.getSeconds());
    exceptionRule.expect(Exception.class);
    exceptionRule.expectMessage("Wrong seconds input, seconds needs to between 0 and 59");
    time.setSeconds(67);
  }


  @Test
  public void testEquals() throws Exception {
    Time test = new Time(10, 0, 0);
    assertEquals(time, time);
    assertEquals(test, time);
    Trip trip = new Trip("", "", test, time);
    assertNotEquals(trip, time);
    Object o = new Object();
    assertNotEquals(o, time);
    Time test2 = null;
    assertNotEquals(test2, time);
  }
}