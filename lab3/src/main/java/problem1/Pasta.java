package problem1;

public class Pasta extends Food implements Non_perishable{
  /**
   * Constructor for Pasta, initialize its name, current price per unit, available quantity, and
   * Maximum allowed quantity
   * @param name name of this food
   * @param pricePerUnit price per unit
   * @param availableNum available quantity
   */
  public Pasta(String name, Double pricePerUnit, Integer availableNum) {
    if (availableNum > MAX_ALLOWED_QUANTITY) {
      throw new IllegalArgumentException("Exceed Maximum quantity allowed");
    }
    this.name = name;
    this.currentPricePerUnt = pricePerUnit;
    this.availableNum = availableNum;
    this.maxAllowed = MAX_ALLOWED_QUANTITY;
  }

}
