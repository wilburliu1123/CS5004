package problem1;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Fruit extends Food implements Perishable{
  /**
   * Constructor for Fruit, initialize its name, current price per unit, available quantity, and
   * Maximum allowed quantity
   * @param name name of this food
   * @param currentPrice price per unit
   * @param availableNum available quantity
   */
  public Fruit(String name, Double currentPrice, Integer availableNum) {
    if (availableNum > MAX_ALLOWED_QUANTITY) {
      throw new IllegalArgumentException("Exceed Maximum quantity allowed");
    }
    this.name = name;
    this.currentPricePerUnt = currentPrice;
    this.availableNum = availableNum;
    this.maxAllowed = MAX_ALLOWED_QUANTITY;
  }

  /**
   * Get order date
   *
   * @return An integer represent the number of days since May 15, 2021
   */
  @Override
  public Integer orderDate(LocalDate today) {
    LocalDate may = LocalDate.of(2021, Month.MAY, 15);
    if (ChronoUnit.DAYS.between(may, today) < 0) {
      throw new IllegalArgumentException("Order day is earlier than 2021 May 15th");
    }
    return (int) ChronoUnit.DAYS.between(may, today);
  }

  /**
   * Get Expiration date
   *
   * @return An integer represent the number of days since May 15, 2021
   */
  @Override
  public Integer ExpirationDate(LocalDate today) {
    LocalDate may = LocalDate.of(2021, Month.MAY, 15);
    if (ChronoUnit.DAYS.between(may, today) < 0) {
      throw new IllegalArgumentException("Order day is earlier than 2021 May 15th");
    }
    return (int) ChronoUnit.DAYS.between(may, today);
  }
}
