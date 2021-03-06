package problem1;

import java.util.Objects;

public abstract class Interior extends Service {

  /**
   * Abstract class for interior service on the house. Introduced FEE that will be implemented on
   * subclass and pets that each house has.
   */
  protected Integer pets;
  protected static Double fee;
  protected Integer hourNeeded;
  private static final int LESS_PETS = 2;
  private static final int MORE_PETS = 3;

  /**
   * This method will calculate the fee that caused by how many pets this property has. If there
   * is only one or two pets, the fee will be 5%. 3 or more will be 7%. 0% if there is none. (return
   * 1 in this case since we use this fee as a factor in child class.
   * @param pets number of pets on this property
   */
  protected void calculateFee(int pets) {
    if (this.pets > ZERO && this.pets <= LESS_PETS) {
      this.fee = ONE + FIVE_PERCENT;
    } else if (this.pets >= MORE_PETS){
      this.fee = ONE + SEVEN_PERCENT;
    } else {
      this.fee = (double) ONE;
    }
  }
  /**
   * Overriding equal class
   * @param o object that is being passed to compare with
   * @return true if two objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Interior interior = (Interior) o;
    return Objects.equals(pets, interior.pets);
  }
  /**
   * Override hashcode to compute for this object.
   * @return hashcode for this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), pets);
  }
}
