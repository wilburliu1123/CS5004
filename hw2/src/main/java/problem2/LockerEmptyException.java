package problem2;

public class LockerEmptyException extends Exception {

  /**
   * LockerEmptyException extends Exception class that will throw an exception when the locker
   * object does not have an mail item in it when somebody try to pick item up
   */
  public LockerEmptyException() {
    super("Locker is Empty");
  }
}
