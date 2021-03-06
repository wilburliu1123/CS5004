package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pledge implements IDonation {

  private LocalDateTime creationDate;
  private LocalDateTime processedDate;
  int amount;

  /**
   * Constructor that doesn't require a processed date. It could be used for bequests pledge where
   * end date is not certain and the processed date could be set by using setProcessedDate method
   *
   * @param creationDate creationDate keeps track of the creation of this pledge
   * @param amount       amount is the amount where donor is pledged
   */
  public Pledge(LocalDateTime creationDate, int amount) {
    this.creationDate = creationDate;
    this.amount = amount;
  }

  /**
   * constructor for a pledge with certain processing date. This means the processing date is
   * certain but subject to be changed.
   *
   * @param creationDate  creation of this pledge
   * @param processedDate estimate processedDate
   * @param amount        amount of money that will be donated
   * @throws ProcessedDateException this exception will be thrown if the processedDate is ealier
   *                                than creation date
   */
  public Pledge(LocalDateTime creationDate, LocalDateTime processedDate, int amount)
      throws ProcessedDateException {
    if (processedDate.compareTo(creationDate) < ZERO) {
      throw new ProcessedDateException();
    }
    this.creationDate = creationDate;
    this.processedDate = processedDate;
    this.amount = amount;
  }

  /**
   * this method allows user to change the processing date for this pledge, if the processedDate is
   * earlier than the creation date. It will throw an ProcessedDateException
   *
   * @param processedDate new processedDate for this pledge
   * @throws ProcessedDateException Exception will be thrown if the processedDate is ealier than
   *                                creation date
   */
  @Override
  public void setEndDate(LocalDateTime processedDate) throws ProcessedDateException {
    if (processedDate.compareTo(this.creationDate) < ZERO) {
      throw new ProcessedDateException();
    }
    this.processedDate = processedDate;
  }

  /**
   * This method allows user to remove the current Processing date.
   */
  public void removeProcessingDate() {
    this.processedDate = null;
  }

  /**
   * This method will get yearly donation amount of given year.
   *
   * @param year the number of year inquiry is asking
   * @return the annual amount of money being donated only if the given year is same as processed
   * year. Otherwise, return 0
   */
  @Override
  public int getYearlyAmount(int year) {
    if (this.processedDate != null && this.processedDate.getYear() == year) {
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
    return this.creationDate;
  }

  /**
   * This method will return the end date of this donation
   *
   * @return A LocalDateTime object that represent the end date of this donation
   */
  @Override
  public LocalDateTime getEndDate() {
    return this.processedDate;
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
    if (!(o instanceof Pledge)) {
      return false;
    }
    Pledge pledge = (Pledge) o;
    return this.amount == pledge.amount && this.creationDate.equals(pledge.creationDate) && Objects
        .equals(this.processedDate, pledge.processedDate);
  }

  /**
   * Override hashCode method to generate unique hashcode
   *
   * @return a unique hashcode for current non profit object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.creationDate, this.processedDate, this.amount);
  }

  /**
   * Override toString method to generate a string representation of this object
   *
   * @return a string representation of this object
   */

  @Override
  public String toString() {
    return "Pledge{" +
        "creationDate=" + this.creationDate +
        ", processedDate=" + this.processedDate +
        ", amount=" + this.amount +
        '}';
  }
}
