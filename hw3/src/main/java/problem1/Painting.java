package problem1;

import java.util.Objects;

public class Painting extends Interior {

  /**
   * @param SIXTEEN is constant for 16 hours that painting is done on small and medium property
   * @param TWENTY_FOUR is constant for 24 hours this painting might take for large property
   */
  private static final int SIXTEEN = 16;
  private static final int TWENTY_FOUR = 24;

  /**
   * Constructor for Painting class, it will create Painting object that has address, property size
   * whether the service is monthly or not, number of previous services, and number of pets in this
   * property. It will calculate how many hours is needed to do this job based on the
   * property size and what is the fee based on how many pets this property has(inherited from Interior class)
   *
   * @param address the address of this property
   * @param propertySize the size of this property
   * @param isMonthly Weather the service is monthly or not
   * @param previousServices number of previous services
   * @param numOfPets is the number of pets on this property.
   */
  public Painting(String address, Size propertySize, boolean isMonthly, Integer previousServices,
      int numOfPets) {
    this.address = address;
    this.propertySize = propertySize;
    this.isMonthly = isMonthly;
    this.previousServices = previousServices;
    this.pets = numOfPets;
    if (this.propertySize == Size.SMALL || this.propertySize == Size.MEDIUM) {
      this.hourNeeded = SIXTEEN;
    } else {
      this.hourNeeded = TWENTY_FOUR;
    }
    calculateFee(numOfPets);
  }

  /**
   * Calculate price will return the cost of this painting service
   * @return the cost of this painting service
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
    if (!(o instanceof Painting)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Painting painting = (Painting) o;
    return this.hourNeeded == painting.hourNeeded;
  }

  /**
   * Override hashcode to compute for this object.
   * @return hashcode for this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(hourNeeded);
  }
  /**
   * toString return string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Painting{" +
        "pets=" + pets +
        ", hourNeeded=" + hourNeeded +
        ", address='" + address + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthly=" + isMonthly +
        ", previousServices=" + previousServices +
        '}';
  }
}
