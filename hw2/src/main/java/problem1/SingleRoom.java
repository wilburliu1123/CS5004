package problem1;

public class SingleRoom extends Room{
  private final static int MAX_OCCUPANCY = 1;
  private int numOfGuests;
  private final static int MIN_NUM = 0;
  public SingleRoom(Amount price) throws IllegalPriceException {
    super(price, MAX_OCCUPANCY);
    this.numOfGuests = MIN_NUM;
  }

}
