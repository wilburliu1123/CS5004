package problem1;

import static org.junit.Assert.*;

import org.graalvm.compiler.nodes.calc.FloatLessThanNode;
import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  FleetManager fleetManager;
  Vehicle bus;
  @Before
  public void setUp() throws Exception {
    fleetManager = new FleetManager();
    bus = new Bus("Bus1", 15, 30);
  }

  @Test
  public void drive() {
    TripReport report = FleetManager.drive(30, bus);
    assertEquals(30, report.getDistance(), 0.01);
    assertEquals(bus, report.getVehicle());
    assertEquals(2, report.getDuration());
    assertEquals(15, report.getSpeed(), 0.01);
    assertEquals(30, report.getVehicle().getMaxSpeed(), 0.01);
  }
}