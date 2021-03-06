package problem1;

public class TripReport {
  private Vehicle vehicle;
  private float distance;
  private float speed;
  private int duration;

  /**
   * constructor for TripReport
   * @param vehicle vehicle used in this trip
   * @param distance total distance for this trip
   */
  public TripReport(Vehicle vehicle, float distance) {
    this.vehicle = vehicle;
    this.distance = distance;
    this.speed = vehicle.getAvgSpeed();
    this.duration = Math.round(this.distance / this.speed);
  }

  /**
   * getter for vehicle
   * @return the vehicle used during this trip
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * getter for trip distance
   * @return distance of this trip
   */
  public float getDistance() {
    return distance;
  }

  /**
   * getter for average speed of this trip
   * @return average speed of this trip
   */
  public float getSpeed() {
    return speed;
  }

  /**
   * getter for duration
   * @return duration of this trip
   */
  public int getDuration() {
    return duration;
  }


}
