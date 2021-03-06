package problem1;

import java.util.Objects;

public class WindowCleaning extends Exterior {

  /**
   * @param numOfFloor window cleaning service needs to keep track of number of floors
   * @param fee is the fee that applies when window service is being done.
   * @param FIVE_PERCENT is constant for 5% in this class for fee calculation
   * @param MAX_FLOOR is the maximum floor allowed to be serviced. If the property has more floor,
   * it will throw an exception
   */
  private Integer numOfFloor;
  private double fee = 1;
  private static final Integer MAX_FLOOR = 3;



  /**
   * Constructor for Window Cleaning class, it will create window cleaning object that has address,
   * property size whether the service is monthly or not, number of previous services and number of
   * floor. If the property has more than 3 floor, this object cannot be created. It will throw an
   * MaximumFloorException. It will calculate how many hours of hours is needed to do this job based
   * on the property size (inherited from Exterior class)
   *
   * @param address          the address of this property
   * @param propertySize     the size of this property
   * @param isMonthly        Weather the service is monthly or not
   * @param previousServices number of previous services
   * @param numOfFloor       number of floor that will be serviced
   * @throws MaxFloorException if the floor is greater than 3, this exception will be thrown
   * @throws MinFloorException if the floor is less than 1, this exception will be thrown
   */
  public WindowCleaning(String address, Size propertySize, boolean isMonthly,
      Integer previousServices, Integer numOfFloor)
      throws MaxFloorException, MinFloorException {
    if (numOfFloor > MAX_FLOOR) {
      throw new MaxFloorException();
    } else if (numOfFloor < ONE) {
      throw new MinFloorException();
    }
    this.address = address;
    this.propertySize = propertySize;
    this.isMonthly = isMonthly;
    this.previousServices = previousServices;
    this.numOfFloor = numOfFloor;
    if (numOfFloor > ONE) {
      this.fee += FIVE_PERCENT;
    }
    this.getHourNeeded(propertySize);
  }

  /**
   * this method will calculate how much it will cost for a window cleaning to be done on this
   * house
   *
   * @return the cost of this service.
   */
  @Override
  public double calculatePrice() {
    return this.fee * (this.hourNeeded * HOURLY_RATE) * discount();
  }

  /**
   * Overriding equal class
   * @param o object that is being passed to compare with
   * @return true if two objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return this.numOfFloor.equals(that.numOfFloor);
  }

  /**
   * Override hashcode to compute for this object.
   * @return hashcode for this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.numOfFloor, this.fee);
  }

  /**
   * toString return string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "This Window Cleaning service needs " +
         + this.hourNeeded +
        " hours, it has " + this.numOfFloor +
        " floor, with a cost of " + this.calculatePrice();
  }
}
