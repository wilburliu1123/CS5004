package lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AthleteTest {
  Athlete athlete;
  Name name;
  @Before
  public void setUp() throws Exception {
    name = new Name("James", "Harden");
    athlete = new Athlete(name, 6.20, 210.10, "Rockets");
  }
  @Test
  public void constructorTest() {
    athlete = new Athlete(name, 6.20, 210.10);
  }
  @Test
  public void getAthletesName() {
    Name test = new Name("James", "Harden");
    assertEquals(test, athlete.getAthletesName());
  }

  @Test
  public void getHeight() {
    assertEquals((Double)6.20, athlete.getHeight());
  }

  @Test
  public void getWeight() {
    assertEquals((Double) 210.10, athlete.getWeight());
  }

  @Test
  public void testEquals() {
    name = new Name("James", "Harden");
    Athlete test = new Athlete(name, 6.20, 210.10, "Rockets");
    assertEquals(test, athlete);
    Runner runner = new Runner(name, 6.1, 6.2, "Rocket", 6.2, 6.2, "");
    assertNotEquals(test, runner);
  }
  @Test
  public void testEquals2() {
    name = new Name("James", "Harden");
    Athlete test = new Athlete(name, 6.20, 210.00, "Rockets");
    assertNotEquals(test, athlete);
  }

  @Test
  public void testHashCode() {
    name = new Name("James", "Harden");
    Athlete test = new Athlete(name, 6.20, 210.10, "Rockets");
    assertNotSame(test.hashCode(), athlete.hashCode());
  }
}