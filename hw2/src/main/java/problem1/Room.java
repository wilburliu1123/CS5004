package problem1;

public class Room {
  private static int maxOccupancyOCCUPANCY;
  private Amount price;
  private int numOfGuests;
  private final static int MIN_NUM = 0;
  /**
   * Constructor of Room object. Price Exceptions are handled in Amount class. If the price is less
   * than 0, it will be handled when Amount class is created.
   * @param price price of this room.
   * @param maxOccupancyOCCUPANCY maximum number of people that can stay in this room.
   * numOfGuests is set to 0 by default. When room is booked this can be changed.
   */
  public Room(Amount price, int maxOccupancyOCCUPANCY) {
    this.price = price;
    this.maxOccupancyOCCUPANCY = maxOccupancyOCCUPANCY;
    this.numOfGuests = MIN_NUM;
  }

  /**
   * isAvailable is checking wether this room has guests or not
   * @return true if there is no guest in this room, false otherwise.
   */
  public boolean isAvailable() {
    return this.numOfGuests == MIN_NUM;
  }

  /**
   * bookRoom method allows you to book a room (change its number of guests) if this room is
   * available and the incoming number of guests is less than the current maximmum occupancy
   * @param numOfGuests this should be a int greater than 0
   * @return true if the room is booked successfully, false otherwise.
   */
  public boolean bookRoom(int numOfGuests) {
    if (this.isAvailable() && numOfGuests > MIN_NUM && numOfGuests <= this.maxOccupancyOCCUPANCY) {
      this.numOfGuests = numOfGuests;
      return true;
    }
    return false;
  }

}
