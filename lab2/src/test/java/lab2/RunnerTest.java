package lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
  Runner runner;
  @Before
  public void setUp() throws Exception {
    Name name = new Name("James", "William");
    runner = new Runner(name, 6.10, 190.10, "Runner club", 30.40, 120.5, "IDK");

  }
  @Test
  public void constructorTest() {
    Name name = new Name("James", "William");
    runner = new Runner(name, 6.10, 190.10, 30.40, 120.5, "IDK");
  }
  @Test
  public void getBest5KTime() {
    assertEquals((Double) 30.40, runner.getBest5KTime());
  }

  @Test
  public void getBestHalfMarathon() {
    assertEquals((Double) 120.5, runner.getBestHalfMarathon());
  }

  @Test
  public void getFavRunningEvent() {
    assertEquals("IDK", runner.getFavRunningEvent());
  }

  @Test
  public void testEquals() {
    Name name = new Name("James", "William");
    Runner test = new Runner(name, 6.10, 190.10, "Runner club", 30.40, 120.5, "IDK");
    assertEquals(test, runner);
  }
  @Test
  public void testHashCode() {
    Name name = new Name("James", "William");
    Runner test = new Runner(name, 6.10, 190.10, "Runner club", 30.40, 120.5, "IDK");
    assertNotSame(test.hashCode(), runner.hashCode());
  }
}