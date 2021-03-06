package problem1;

public class Rice extends Food implements Non_perishable{
  /**
   * Constructor for Rice, initialize its name, current price per unit, available quantity, and
   * Maximum allowed quantity
   * @param name name of this food
   * @param pricePerUnit price per unit
   * @param availableNum available quantity
   */
  public Rice(String name, Double pricePerUnit, Integer availableNum) {
    if (availableNum > MAX_ALLOWED_QUANTITY) {
      throw new IllegalArgumentException("Exceed Maximum quantity allowed");
    }
    this.name = name;
    this.currentPricePerUnt = pricePerUnit;
    this.availableNum = availableNum;
    this.maxAllowed = MAX_ALLOWED_QUANTITY;
  }
}
