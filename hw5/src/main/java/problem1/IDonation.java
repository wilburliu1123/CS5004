package problem1;

import java.time.LocalDateTime;

public interface IDonation {

  public static final int ZERO = 0;
  public static final int TWELVE = 12;
  public static final int ONE = 1;

  /**
   * This method will get yearly donation amount of given year.
   * @param year given year to get yearly amount
   * @return the annual amount of money being donated
   */
  int getYearlyAmount(int year);

  /**
   * Get the date and time the donation was made.
   *
   * @return A LocalDateTime object that represent the date and time this donation was made.
   */
  LocalDateTime getCreation();

  /**
   * This method will return the end date of this donation
   *
   * @return A LocalDateTime object that represent the end date of this donation
   */
  LocalDateTime getEndDate();

  void setEndDate(LocalDateTime endDate) throws ProcessedDateException;
}
