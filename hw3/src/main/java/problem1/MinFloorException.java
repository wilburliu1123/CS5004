package problem1;

public class MinFloorException extends Exception{
  /**
   * MinFloorException extends Exception class that will throw a message when the floor is less
   * than 1
   */
  public MinFloorException() {
    super("Floor number is wrong, floor need to be greater or equal to 1");
  }

}
