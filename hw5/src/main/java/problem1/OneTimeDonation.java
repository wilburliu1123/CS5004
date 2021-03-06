package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public class OneTimeDonation implements IDonation {

  private LocalDateTime createDate;
  private LocalDateTime endDate;
  private int amount;

  /**
   * Constructor for OneTimeDonation given createDate and amount for this one time donation
   * Because it is a one time donation, end date will set equal to createDate
   * @param createDate given Creation date
   * @param amount amount of money being donated
   */
  public OneTimeDonation(LocalDateTime createDate, int amount) {
    this.createDate = createDate;
    this.endDate = createDate;
    this.amount = amount;
  }

  /**
   * This method will get yearly donation amount of given year.
   *
   * @param year given year
   * @return the annual amount of money being donated
   */
  @Override
  public int getYearlyAmount(int year) {
    if (this.createDate.getYear() == year) {
      return this.amount;
    }
    return 0;
  }

  /**
   * Get the date and time the donation was made.
   *
   * @return A LocalDateTime object that represent the date and time this donation was made.
   */
  @Override
  public LocalDateTime getCreation() {
    return this.createDate;
  }

  /**
   * This method will return the end date of this donation
   *
   * @return A LocalDateTime object that represent the end date of this donation
   */
  @Override
  public LocalDateTime getEndDate() {
    return this.endDate;
  }

  /**
   * One time donation should not be able to change its endDate, so this method will immediatly
   * return when called
   * @param endDate given end date
   * @throws ProcessedDateException exception inherited from IDonation
   */
  @Override
  public void setEndDate(LocalDateTime endDate) throws ProcessedDateException {
    return;
  }

  /**
   * Override hashCode method to generate unique hashcode
   *
   * @return a unique hashcode for current One time donation
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.createDate, this.getEndDate(), this.amount);
  }

  /**
   * Override equals method to compare with given object
   *
   * @param o given object
   * @return true only if hashcode, class type and all field are the same. False otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OneTimeDonation)) {
      return false;
    }
    OneTimeDonation that = (OneTimeDonation) o;
    return this.amount == that.amount && this.createDate.equals(that.createDate) && this
        .getEndDate().equals(that.getEndDate());
  }

  /**
   * Override toString method to generate a string representation of this object
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return "OneTimeDonation{" +
        "createDate=" + this.createDate +
        ", EndDate=" + this.endDate +
        ", amount=" + this.amount +
        '}';
  }
}
