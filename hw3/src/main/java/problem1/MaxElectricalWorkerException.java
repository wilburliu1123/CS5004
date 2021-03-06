package problem1;

public class MaxElectricalWorkerException extends Exception{
  /**
   * MaxElectricalWorker extends Exception class that will throw a message when the licensed employee
   * is greater than 4
   */
  public MaxElectricalWorkerException() {
    super("Maximum number of 4 licensed employee is allowed");
  }

}
