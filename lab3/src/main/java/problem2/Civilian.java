package problem2;

public class Civilian extends Piece{
  double wealth;
  public Civilian(Name name, int age, double wealth) {
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("Age must between 0-128");
    }
    this.name = name;
    this.age = age;
    this.wealth = wealth;
  }
  public void increaseWealth(double amount) {
    this.wealth += amount;
  }
  public void decreaseAmount(double amount) {
    this.wealth -= amount;
  }
}
