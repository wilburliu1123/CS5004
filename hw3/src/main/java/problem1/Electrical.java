package problem1;

public class Electrical extends SpecialistService {

  /**
   * @param MAX_NUM_OF_EMPLOYEE is the constant of maximum employee allowed for electrical service
   * @param PERMITTING_FEE is constant cost for every electrical service
   */
  private static final int MAX_NUM_OF_EMPLOYEE = 4;
  private static final int PERMITTING_FEE = 50;

  /**
   * Constructor for electrical service for this property, initialize property address, the size of
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
   * @param isComplexWork    whether this is a complex work or not
   * @throws MaxElectricalWorkerException if the number of employee is greater than 4, this will
   *                                      throw a MaxElectricalWorkerException
   */
  public Electrical(String address, Size propertySize, boolean isMonthly, Integer previousServices,
      int numOfEmployee, boolean isComplexWork)
      throws MaxElectricalWorkerException {
    if (numOfEmployee > MAX_NUM_OF_EMPLOYEE) {
      throw new MaxElectricalWorkerException();
    }
    this.address = address;
    this.propertySize = propertySize;
    this.isMonthly = isMonthly;
    this.previousServices = previousServices;
    this.numberOfLicensedEmployee = numOfEmployee;
    if (numberOfLicensedEmployee < 1) {
      this.numberOfLicensedEmployee = ONE;
    }
    this.isComplexWork = isComplexWork;
    if (this.isComplexWork && !meetComplexWorkRequirement()) {
      this.setMinEmployee();
    }
  }


  /**
   * Override the Specialist Service class's calculate price method. There is a permitting fee of 50
   * for every electrical work.
   *
   * @return the cost of this service
   */
  @Override
  public double calculatePrice() {
    return PERMITTING_FEE + this.numberOfLicensedEmployee * BASE_RATE_PER_EMPLOYEE;
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
    return "Electrical" + super.toString();
  }
}
