package problem1;

import java.util.Objects;

public abstract class Exterior extends Service{

  /**
   * hourNeeded is the hour that is needed for this service
   */
  protected int hourNeeded;




  /**
   * This method is intended for all exterior services. It will get the hours needed to do the job
   * based on how large the property is. For small house, hour needed is one. For Medium house, hour
   * needed is Two. For large house, hour needed is four.
   * @param size the size of the property.
   */
  protected void getHourNeeded(Size size) {
    if (size == Size.SMALL) {
      this.hourNeeded = ONE;
    } else if (size == Size.MEDIUM) {
      this.hourNeeded = TWO;
    } else {
      this.hourNeeded = FOUR;
    }
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
    if (!(o instanceof Exterior)) {
      return false;
    }
    Exterior exterior = (Exterior) o;
    return this.hourNeeded == exterior.hourNeeded;
  }
  /**
   * Override hashcode to compute for this object.
   * @return hashcode for this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.hourNeeded);
  }
  /**
   * toString return string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "{" +
        "hourNeeded=" + hourNeeded +
        ", address='" + address + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthly=" + isMonthly +
        ", previousServices=" + previousServices +
        '}';
  }
}
