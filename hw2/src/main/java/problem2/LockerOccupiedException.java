package problem2;

public class LockerOccupiedException extends Exception {

  /**
   * LockerOccupiedException extends Exception class that will throw an exception when the lock
   * object already has an mail item in it
   */
  public LockerOccupiedException() {
    super("This locker is currently being occupied");
  }
}
