package problem2;

import java.util.ArrayList;
import java.util.List;

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

  /**
   * overloaded method to generate a trip report.
   * @param distance distance of the trip
   * @param vehicle vehicle used during the trip
   * @return An TripReport object.
   */
  public static TripReport drive(Vehicle vehicle, float distance) {
    return new TripReport(vehicle, distance);
  }

  /**
   * Overloaded method to generate a trip report.
   * @param distance distance of the trip
   * @param speed average speed of this trip
   * @param vehicle vehicle used during the trip
   * @return An TripReport object.
   */
  public static TripReport drive(float distance, float speed, Vehicle vehicle) {
    return new TripReport(vehicle, speed, distance);
  }

  /**
   * Overloaded method to generate a trip report
    * @param distance distance of the trip
   * @param vehicle vehicle used during the trip
   * @param speed average speed of the trip
   * @return A trip report object
   */
  public static TripReport drive(float distance, Vehicle vehicle, float speed) {
    return new TripReport(vehicle, speed, distance);
  }

}
