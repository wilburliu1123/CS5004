package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  Vehicle bus;
  FleetManager fleetManager;
  @Before
  public void setUp() {
    fleetManager = new FleetManager();
    bus = new Bus("bus1", 20, 40);
  }

  @Test
  public void testDrive() {
    TripReport report = FleetManager.drive(30, bus);
    assertEquals("bus1", bus.getId());
    assertEquals(bus, report.getVehicle());
    assertEquals(40, report.getVehicle().getMaxSpeed(), 0.01);
    assertEquals(20, report.getSpeed(), 0.01);
    assertEquals(2, report.getDuration());
    assertEquals(30, report.getDistance(), 0.01);

  }

  @Test
  public void testDrive1() {
    Bus test = new Bus("1", 20, 40);
    TripReport report = FleetManager.drive(30.00f, test);
    assertEquals("1", test.getId());
    assertEquals(test, report.getVehicle());
    assertEquals(40, report.getVehicle().getMaxSpeed(), 0.01);
    assertEquals(20, report.getSpeed(), 0.01);
    assertEquals(2, report.getDuration());
    assertEquals(30, report.getDistance(), 0.01);
  }

  @Test
  public void testDrive2() {
    Bus test = new Bus("1", 30, 40);
    TripReport report = FleetManager.drive(40.00f, 50, test);
    assertEquals(test, report.getVehicle());
    assertEquals(40, report.getVehicle().getMaxSpeed(), 0.01);
    assertEquals(40, report.getSpeed(), 0.01);
    assertEquals(1, report.getDuration());
    assertEquals(40, report.getDistance(), 0.01);
  }

  @Test
  public void testDrive3() {
    TripReport report = FleetManager.drive(bus, 30);
    assertEquals("bus1", bus.getId());
    assertEquals(bus, report.getVehicle());
    assertEquals(40, report.getVehicle().getMaxSpeed(), 0.01);
    assertEquals(20, report.getSpeed(), 0.01);
    assertEquals(2, report.getDuration());
    assertEquals(30, report.getDistance(), 0.01);
  }
  @Test
  public void testDrive4() {
    Train test = new Train("1", 30, 40);
    TripReport report = FleetManager.drive(40.00f, test,40);
    assertEquals(test, report.getVehicle());
    assertEquals(40, report.getVehicle().getMaxSpeed(), 0.01);
    assertEquals(40, report.getSpeed(), 0.01);
    assertEquals(1, report.getDuration());
    assertEquals(40, report.getDistance(), 0.01);
  }
}