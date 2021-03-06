package problem1;

import java.time.LocalDate;

public interface Perishable {
  static final int MAX_ALLOWED_QUANTITY = 100;

  /**
   * Get order date
   * @return An integer represent the number of days since May 15, 2021
   */
  public Integer orderDate(LocalDate today);
  /**
   * Get Expiration date
   * @return An integer represent the number of days since May 15, 2021
   */
  public Integer ExpirationDate(LocalDate today);

}
