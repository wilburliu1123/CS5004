package problem1;

import java.util.Objects;

public class InteriorCleaning extends Interior {


  /**
   * Interior cleaning constructor, initialize all variable and calculate FEE constant based on
   * how many pets this property has. discount is also being calculate for this service at this
   * constructor.
   * @param address the address of this property
   * @param propertySize the size of the property that will be serviced.
   * @param isMonthly is the field that describe whether this property is being serviced monthly
   * @param previousServices is the number of service that has been done on this property.
   * @param numOfPets is the number of pets on this property.
   */
  public InteriorCleaning(String address, Size propertySize, boolean isMonthly, Integer previousServices, int numOfPets) {
    this.address = address;
    this.propertySize = propertySize;
    this.isMonthly = isMonthly;
    this.previousServices = previousServices;
    this.pets = numOfPets;
    if (this.propertySize == Size.SMALL) {
      this.hourNeeded = ONE;
    } else if (this.propertySize == Size.MEDIUM) {
      this.hourNeeded = TWO;
    } else {
      this.hourNeeded = FOUR;
    }
    calculateFee(numOfPets);
  }



  /**
   * this method will calculate how much it will cost for a interior cleaning to be done on this house
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
    if (!(o instanceof InteriorCleaning)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    InteriorCleaning that = (InteriorCleaning) o;
    return this.hourNeeded == that.hourNeeded;
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.hourNeeded);
  }
  /**
   * toString return string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "InteriorCleaning{" +
        "pets=" + pets +
        ", hourNeeded=" + hourNeeded +
        ", address='" + address + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthly=" + isMonthly +
        ", previousServices=" + previousServices +
        '}';
  }
}
