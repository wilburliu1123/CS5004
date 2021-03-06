package problem1;

public class DoubleRoom extends Room{

  private final static int MAX_OCCUPANCY = 2;
  private int numOfGuests;
  private final static int MIN_NUM = 0;
  public DoubleRoom(Amount price) throws IllegalPriceException {
    super(price, MAX_OCCUPANCY);
    this.numOfGuests = MIN_NUM;
  }


}
