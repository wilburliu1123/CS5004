package problem1;

import java.util.*;

public class FleetManager{

  /**
   * driver for generate a trip report.
   * @param distance distance of the trip
   * @param vehicle vehicle used during the trip
   * @return An TripReport object.
   */
  public static TripReport drive(float distance, Vehicle vehicle) {
    return new TripReport(vehicle, distance);
  }
}
