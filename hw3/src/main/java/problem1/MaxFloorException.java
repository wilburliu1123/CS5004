package problem1;

public class MaxFloorException extends Exception{
  /**
   * MaxFloorException extends Exception class that will throw a message when the floor is greater
   * than 3
   */
  public MaxFloorException() {
    super("Maximum floor exceeded. Max floor number is 3");
  }

}
