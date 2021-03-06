package lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {
  BaseballPlayer baseballPlayer;
  Name name;
  @Before
  public void setUp() throws Exception {
    name = new Name("James", "Harden");
    baseballPlayer = new BaseballPlayer(name, 6.20, 210.10, "Rockets",  0.0, 0);
  }

  @Test
  public void constructorTest() {
    name = new Name("James", "Harden");
    baseballPlayer = new BaseballPlayer(name, 6.20, 210.10, "NBA","Rockets",  0.0, 0);
  }

  @Test
  public void getTeam() {
    assertEquals("Rockets", baseballPlayer.getTeam());
  }

  @Test
  public void getAvgBatting() {
    assertEquals((Double)0.0, baseballPlayer.getAvgBatting());
  }

  @Test
  public void getHomeRun() {
    assertEquals((Integer) 0, baseballPlayer.getHomeRun());
  }
}