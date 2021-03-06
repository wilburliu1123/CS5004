package problem1;

import java.util.Objects;

public abstract class Service {

  /**
   * This is an abstract body for all kinds of services. Each service will implement their own
   * field and methods if necessary.
   * Enum Size gives three category of the property size: small, medium and large.
   * HOURLY_RATE is the base rate for services except for specialist service.
   * There are six constant that represent its corresponding number.
   * ZERO is the constant for 0
   * ONE is the constant for 1
   * TWO is the constant for 2
   * THREE is the constant for 3
   * FOUR is constant for 4
   * TEN is constant for 10
   * FIFTY_PERCENT is constant for 50%
   * TEN_PERCENT is constant for 10%
   * ZERO_PERCENT is constant for 0%
   * FIVE_PERCENT is constant for 5%
   * SEVEN_PERCENT is constant for 7%
   * large property
   */
  public enum Size {
    SMALL, MEDIUM, LARGE
  }
  protected String address;
  protected Size propertySize;
  protected boolean isMonthly;
  protected Integer previousServices;
  protected static final Integer HOURLY_RATE = 80;
  protected static final int TEN = 10;
  protected static final int ZERO = 0;
  protected static final int ONE = 1;
  protected static final int TWO = 2;
  protected static final int THREE = 3;
  protected static final int FOUR = 4;
  protected static final double FIFTY_PERCENT = 0.5;
  protected static final double TEN_PERCENT = 0.1;
  protected static final double ZERO_PERCENT = 0.0;
  protected static final double FIVE_PERCENT = 0.05;
  protected static final double SEVEN_PERCENT = 0.07;

  /**
   * discount method returns the discount for this service. If this service is the 10th service
   * for this property, it will discount 50% from the current price. (This exclude the monthly
   * discount) If this service is being done on monthly bases. It will get 10% discount.
   * if this service is the 10th service, then it will get 50% discount.
   * Otherwise, it will get 0% discount rate. Specialist service will override this method since
   * they don't get any discount.
   * @return discount percentage
   */
  protected double discount() {
    if (this.isMonthly && (this.previousServices + ONE) % TEN == ZERO) {
      return ONE - FIFTY_PERCENT;
    } else if (this.isMonthly) {
      return ONE - TEN_PERCENT;
    } else if ((this.previousServices + ONE) % TEN == ZERO) {
      return ONE - FIFTY_PERCENT;
    } else {
      return ONE - ZERO_PERCENT;
    }
  }

  /**
   * Abstract method that will return a double represent the cost of this service. Implemented in
   * child class
   * @return the cost of current service
   */
  public abstract double calculatePrice();

  @Override
  public boolean equals(Object o) {
    Service service = (Service) o;
    return isMonthly == service.isMonthly && Objects.equals(address, service.address)
        && propertySize == service.propertySize && Objects
        .equals(previousServices, service.previousServices);
  }

  /**
   * Override hashcode to compute for this object.
   * @return hashcode for this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(address, propertySize, isMonthly, previousServices);
  }
}
