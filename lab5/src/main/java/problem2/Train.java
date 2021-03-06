package problem2;

public class Train extends Vehicle {
  /**
   * constructor for train
   * @param id id for this train
   * @param avgSpeed avg speed for this train
   * @param maxSpeed max speed for this train
   */
  public Train(String id, float avgSpeed, float maxSpeed) {
    this.id = id;
    this.avgSpeed = avgSpeed;
    this.maxSpeed = maxSpeed;
  }
}
