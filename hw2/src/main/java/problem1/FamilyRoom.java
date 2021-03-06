package problem1;

public class FamilyRoom extends Room {
  private final static int MAX_OCCUPANCY = 4;
  private int numOfGuests;
  private final static int MIN_NUM = 0;
  public FamilyRoom(Amount price) throws IllegalPriceException {
    super(price, MAX_OCCUPANCY);
    this.numOfGuests = MIN_NUM;
  }
}
