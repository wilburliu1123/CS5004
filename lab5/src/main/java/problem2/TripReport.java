package problem2;

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
   * overloaded constructor for TripReport
   * @param vehicle vehicle used in this trip
   * @param distance total distance for this trip
   * @param speed avg speed of a trip. if it is bigger than vehicle's max speed. it will be set to
   *              vehicle's max speed.
   *
   */
  public TripReport(Vehicle vehicle, float speed, float distance) {
    this.vehicle = vehicle;
    this.distance = distance;
    if (speed > vehicle.maxSpeed) {
      this.speed = vehicle.maxSpeed;
    } else {
      this.speed = speed;
    }
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
