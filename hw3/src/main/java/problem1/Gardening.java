package problem1;

public class Gardening extends Exterior {

  /**
   * @param REMOVAL_FEE is a constant that every gardening service cost
   */
  private static final int REMOVAL_FEE = 20;

  /**
   * Constructor for Gardening class, it will create gardening object that has address, property
   * size whether the service is monthly or not, and number of previous services. It will calculate
   * how many hours is needed to do this job based on the property size (inherited from
   * Exterior class)
   *
   * @param address          the address of this property
   * @param propertySize     the size of this property
   * @param isMonthly        Weather the service is monthly or not
   * @param previousServices number of previous services
   */
  public Gardening(String address, Size propertySize, boolean isMonthly, Integer previousServices) {
    this.address = address;
    this.propertySize = propertySize;
    this.isMonthly = isMonthly;
    this.previousServices = previousServices;
    this.getHourNeeded(propertySize);
  }

  /**
   * this method will calculate how much it will cost for a gardening to be done on this house
   *
   * @return the cost of this service.
   */
  @Override
  public double calculatePrice() {
    return this.REMOVAL_FEE + this.hourNeeded * HOURLY_RATE * discount();
  }
  /**
   * Overriding equal class
   * @param o object that is being passed to compare with
   * @return true if two objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }
  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
  /**
   * toString return string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Gardening" + super.toString();
  }
}
