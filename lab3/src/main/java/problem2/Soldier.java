package problem2;

public class Soldier extends Piece{
  double stamina;
  public Soldier(Name name, int age, double stamina) {
    if (stamina < 0 || stamina > 100) {
      throw new IllegalArgumentException("stamina must be between 0 - 100");
    }
    this.name = name;
    this.age = age;
    this.stamina = stamina;
  }
  public void increaseStamina(double amount) {
    this.stamina += amount;
  }

  public void decreaseStamina(double amount) {
    this.stamina -= amount;
  }

}
