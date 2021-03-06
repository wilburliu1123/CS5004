package problem2;

public class Boat extends Vehicle{
  /**
   * constructor for Boat
   * @param id id for this boat
   * @param avgSpeed avg speed for this boat
   * @param maxSpeed max speed for this boat
   */
  public Boat(String id, float avgSpeed, float maxSpeed) {
    this.id = id;
    this.avgSpeed = avgSpeed;
    this.maxSpeed = maxSpeed;
  }

}
