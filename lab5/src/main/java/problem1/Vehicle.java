package problem1;

public abstract class Vehicle {
  protected String id;
  protected Float avgSpeed;
  protected Float maxSpeed;

  /**
   * getter for id of this vehicle
   * @return id of this vehicle
   */
  public String getId() {
    return id;
  }

  /**
   * setter for id
   * @param id id of this vehicle
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * getter for avg speed
   * @return avg speed of this vehicle
   */
  public Float getAvgSpeed() {
    return avgSpeed;
  }

  /**
   * setter for avg speed
   * @param avgSpeed given avg speed
   */
  public void setAvgSpeed(Float avgSpeed) {
    this.avgSpeed = avgSpeed;
  }

  /**
   * getter for max speed
   * @return vehicle's max speed
   */
  public Float getMaxSpeed() {
    return maxSpeed;
  }

  /**
   * setter for max speed
   * @param maxSpeed given max speed user want to change to
   */
  public void setMaxSpeed(Float maxSpeed) {
    this.maxSpeed = maxSpeed;
  }
}
