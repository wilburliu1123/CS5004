package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoatTest {
  Boat boat;
  @Before
  public void setUp() throws Exception {
    boat = new Boat("boat1", 1.51f, 15);
  }

  @Test
  public void getId() {
    assertEquals("boat1", boat.getId());
  }

  @Test
  public void setId() {
    boat.setId("boat2");
    assertEquals("boat2", boat.getId());
  }

  @Test
  public void getAvgSpeed() {
    assertEquals(1.51f, boat.getAvgSpeed(), 0.001f);
  }

  @Test
  public void setAvgSpeed() {
    boat.setAvgSpeed(1.62f);
    assertEquals(1.62f, boat.getAvgSpeed(), 0.001f);
  }

  @Test
  public void getMaxSpeed() {
    assertEquals(15, boat.getMaxSpeed(), 0.001);
  }

  @Test
  public void setMaxSpeed() {
    boat.setMaxSpeed(17.5f);
    assertEquals(17.5f, boat.getMaxSpeed(), 0.01f);
  }
}