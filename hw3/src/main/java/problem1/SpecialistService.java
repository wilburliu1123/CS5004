package problem1;

import java.util.Objects;

public abstract class SpecialistService extends Service {

  /**
   * Specialist service keep track of how many number of licensed employee and whether the work is
   * complex or not.
   *
   * BASE_RATE_PER_EMPLOYEE is a constant the base rate per employee of this specialist
   * service
   * NO_DISCOUNT is a constant that override the super class (Service) discount value since
   * there is no discount on any Specialist Service.
   */
  protected int numberOfLicensedEmployee;
  protected boolean isComplexWork;

  protected static final int BASE_RATE_PER_EMPLOYEE = 200;
  protected static final double NO_DISCOUNT = 1.0;

  /**
   * setMinEmployee method will set the minimum required licensed worker for this job if the current
   * number of employee does not meet the requirement. Minimum requirement of SMALL and MEDIUM house
   * is 2 licensed worker, 3 is required for LARGE house
   */
  protected void setMinEmployee() {
    if (this.propertySize == Size.SMALL || this.propertySize == Size.MEDIUM) {
      this.numberOfLicensedEmployee = TWO;
    } else {
      this.numberOfLicensedEmployee = THREE;
    }
  }

  /**
   * checkMeetComplexWorkRequirement method will check whether the current amount of worker has met
   * the requirement for this job. Every complex specialist job requires minimum of 2 employee for
   * small or medium house. 3 employee for large size property. It will return true if the current
   * amount of worker has meet the requirement, false otherwise.
   * @return true if the number of licensed employee meet the requirements, false otherwise
   */
  protected boolean meetComplexWorkRequirement() {
    if ((this.propertySize == Size.SMALL || this.propertySize == Size.MEDIUM) && (
        this.numberOfLicensedEmployee
            >= TWO)) {
      return true;
    } else if (this.propertySize == Size.LARGE && this.numberOfLicensedEmployee >= THREE) {
      return true;
    }
    return false;
  }

  /**
   * All specialist service has no discount according to the rule.
   *
   * @return 100% or 1.0 since all specialist service has no discount
   */
  @Override
  protected double discount() {
    return NO_DISCOUNT;
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecialistService that = (SpecialistService) o;
    return numberOfLicensedEmployee == that.numberOfLicensedEmployee
        && this.isComplexWork == that.isComplexWork;
  }
  /**
   * Override hashcode to compute for this object.
   * @return hashcode for this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(numberOfLicensedEmployee, isComplexWork);
  }
  /**
   * toString return string representation of this object
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return "Service{" +
        "address='" + address + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthly=" + isMonthly +
        ", previousServices=" + previousServices +
        ", numberOfLicensedEmployee=" + numberOfLicensedEmployee +
        ", isComplexWork=" + isComplexWork +
        '}';
  }
}
