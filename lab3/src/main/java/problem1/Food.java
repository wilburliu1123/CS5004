package problem1;

import java.util.Objects;

/**
 * Abstract class for all food items. Include fields name, currentPricePerUnit,  availableNum
 * and maximum number is allowed.
 */
public abstract class Food {
  protected String name;
  protected Double currentPricePerUnt;
  protected Integer availableNum;
  protected Integer maxAllowed;

  public String getName() {
    return this.name;
  }

  public Double getCurrentPricePerUnt() {
    return this.currentPricePerUnt;
  }

  public Integer getAvailableNum() {
    return this.availableNum;
  }

  public Integer getMaxAllowed() {
    return this.maxAllowed;
  }

  public Integer makeOrder(int unit) {
    if (unit > maxAllowed || unit > availableNum) {
      throw new IllegalArgumentException("Exceed maximum allowed quantity");
    }
    return (int) Math.round(this.currentPricePerUnt * unit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Food food = (Food) o;
    return getName().equals(food.getName()) && getCurrentPricePerUnt()
        .equals(food.getCurrentPricePerUnt()) && getAvailableNum().equals(food.getAvailableNum())
        && getMaxAllowed().equals(food.getMaxAllowed());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCurrentPricePerUnt(), getAvailableNum(), getMaxAllowed());
  }


}
