package problem1;

public class Bus extends Vehicle{

  /**
   * constructor for this bus
   * @param id if for this bus
   * @param avgSpeed avg speed for this bus
   * @param maxSpeed max speed for this bus
   */
  public Bus(String id, float avgSpeed, float maxSpeed) {
    this.id = id;
    this.avgSpeed = avgSpeed;
    this.maxSpeed = maxSpeed;
  }

}
