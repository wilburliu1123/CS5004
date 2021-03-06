package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public class MonthlyDonation implements IDonation {

  private LocalDateTime creationDate;
  private int amount;
  private LocalDateTime cancelDate;

  /**
   * constructor for MonthlyDonation object. No cancelDate is set during construction. User can set
   * cancel date later when they needed.
   *
   * @param creationDate creation date for this monthly donation
   * @param amount       amount of money that is being donated
   */
  public MonthlyDonation(LocalDateTime creationDate, int amount) {
    this.creationDate = creationDate;
    this.amount = amount;
  }

  /**
   * This method will set an end date for this monthly donation, given cancel date must be later
   * than creation date. Otherwise it will throw an processedDateException
   *
   * @param endDate given date the donor want to cancel their monthly donation
   * @throws ProcessedDateException this exception will be thrown if given end date is earlier than
   *                                creation date
   */
  public void setEndDate(LocalDateTime endDate) throws ProcessedDateException {
    if (endDate.compareTo(this.creationDate) >= 0) {
      this.cancelDate = endDate;
    } else {
      throw new ProcessedDateException();
    }
  }

  /**
   * This method will get yearly donation amount of given year. If given year is earlier than the
   * creation date of this donation, return 0;
   *
   * @param year given year that user want to get the yearly donation amount
   * @return the annual amount of money being donated
   */
  @Override
  public int getYearlyAmount(int year) {
    if (this.creationDate.getYear() > year) {
      return 0;
    }
    if (this.creationDate.getYear() == year) {
      // if cancel date is not null and if cancelDate is equal to creation date.
      // We will calculate the yearly amount based on cancel date. If it is null, calculate based on creation date
      if (this.cancelDate != null && this.cancelDate.getYear() == year) {
        return (this.cancelDate.getMonthValue() - this.creationDate.getMonthValue() + ONE)
            * this.amount;
      }
      return (TWELVE - this.creationDate.getMonthValue() + ONE) * this.amount;
    } else {
      //if creation date is less than given year. Check if cancelDate is the same year. if it is,
      // return that yearly amount until cancellation date. If not, return 12 * monthly amount
      if (this.cancelDate != null && this.cancelDate.getYear() == year) {
        return (this.cancelDate.getMonthValue()) * this.amount;
      }
      return TWELVE * this.amount;
    }
  }

  /**
   * Get the date and time the donation was made.
   *
   * @return A LocalDateTime object that represent the date and time this donation was made.
   */
  @Override
  public LocalDateTime getCreation() {
    return this.creationDate;
  }

  /**
   * This method will return the end date of this donation
   *
   * @return A LocalDateTime object that represent the end date of this donation
   */
  @Override
  public LocalDateTime getEndDate() {
    return this.cancelDate;
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
    if (!(o instanceof MonthlyDonation)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return this.amount == that.amount && this.creationDate.equals(that.creationDate) && Objects
        .equals(this.cancelDate, that.cancelDate);
  }

  /**
   * Override toString method to generate a string representation of this object
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "creationDate=" + this.creationDate +
        ", amount=" + this.amount +
        ", cancelDate=" + this.cancelDate +
        '}';
  }

  /**
   * Override hashCode method to generate unique hashcode
   *
   * @return a unique hashcode for current monthly donation
   */
  @Override
  public int hashCode() {
    return Objects.hash(creationDate, amount, cancelDate);
  }
}
