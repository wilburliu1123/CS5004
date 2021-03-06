package problem1;

import java.util.HashMap;

public class Plumbing extends SpecialistService {

  /**
   * @param PERMITTING_FEE for every plumbing service, there is a constant fee that costs 20
   */
  private static final int PERMITTING_FEE = 20;

  /**
   * Contructor for plumbing service for this property, initialize property address, the size of
   * this property, whether this is a monthly service number of previous services, number of
   * licensed employee for this job, and whether this is a complex work. If this job is complex
   * work, additional check is required. For small and medium property, a minimum of 2 employee is
   * required for large property, a minimum of 3 employee is required. The maximum worker allowed is
   * 4, if the number of employee is greater than 4, then the constructor will throw an exception
   *
   * @param address          the address of this property
   * @param propertySize     the size of this property
   * @param isMonthly        Whether the service is monthly or not
   * @param previousServices number of previous services
   * @param numOfEmployee    the number of employee for this job
   * @param isComplexWork    whether this is a complex work
   */
  public Plumbing(String address, Size propertySize, boolean isMonthly, Integer previousServices,
      int numOfEmployee, boolean isComplexWork) {
    this.address = address;
    this.propertySize = propertySize;
    this.isMonthly = isMonthly;
    this.previousServices = previousServices;
    this.numberOfLicensedEmployee = numOfEmployee;
    if (numberOfLicensedEmployee < ONE) {
      this.numberOfLicensedEmployee = ONE;
    }
    this.isComplexWork = isComplexWork;
    if (this.isComplexWork && !meetComplexWorkRequirement()) {
      this.setMinEmployee();
    }
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
   * Indicates whether some other object is "equal to" this one.
   * @param obj is the object that is being compared to
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Plumbing" + super.toString();
  }

  /**
   * override the calculatePrice method from super class to calculate the price
   * @return the cost of this service
   */
  @Override
  public double calculatePrice() {
    return PERMITTING_FEE + this.numberOfLicensedEmployee * BASE_RATE_PER_EMPLOYEE;
  }

}
