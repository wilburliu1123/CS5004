package problem2;

public class Locker {

  private int width;
  private int height;
  private int depth;
  MailItem mailItem;
  private static final int MIN_LENGTH = 1;
  /**
   * Constructor for locker object
   * @param width the width of this locker
   * @param height the height of this locker
   * @param depth the depth of this locker
   * @throws IllegalLengthException The locker's width or height or depth has to be greater than 1,
   * other wise this IllegalLengthException will be thrown.
   */
  public Locker(int width, int height, int depth) throws IllegalLengthException {
    if (width < MIN_LENGTH || height < MIN_LENGTH || depth < MIN_LENGTH) {
      throw new IllegalLengthException();
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
  }

  /**
   * Getter for width.
   * @return width.
   */
  public int getWidth() {
    return this.width;
  }
  /**
   * Getter for height.
   * @return height.
   */
  public int getHeight() {
    return this.height;
  }
  /**
   * Getter for depth.
   * @return depth.
   */
  public int getDepth() {
    return this.depth;
  }

  /**
   * Getter for mailItem.
   * @return mailItem.
   */
  public MailItem getMailItem() {
    return this.mailItem;
  }

  /**
   * addMail method will add a mail item into the locker if locker is empty and the mail item
   * is within the boundary of this locker. i.e., mail item width, height, and depth have to be
   * less or equal to this locker object. Otherwise it will throw an IllegalLengthException
   * @param item mail item that is going to be add to the locker
   * @throws IllegalLengthException if mail item width, height, and depth are
   * greater than this locker corresponding field. It will throw an IllegalLengthException.
   * @throws LockerOccupiedException If this locker is not empty. It will throw a
   * LockerOccupiedException
   */
  public void addMail(MailItem item) throws IllegalLengthException, LockerOccupiedException {
    if (item.getDepth() > this.depth || item.getHeight() > this.height ||
        item.getWidth() > this.width) {
      throw new IllegalLengthException();
    } else if (this.mailItem != null) {
      throw new LockerOccupiedException();
    } else {
      this.mailItem = item;
    }
  }

  /**
   * pickupMail method will allow a recipient to pick up his item and empty the locker if all
   * condition is matched. Exception will thrown if recipient doesn't match or locker is empty.
   * @param recipient the recipient that is request to retrieve his/her item.
   * @return MailItem that is retrieved by the recipient.
   * @throws RecipientNotMatchException If recipient information does not match the mailItem's
   * description, it will throw RecipientNotMatchException Exception.
   * @throws IllegalLengthException Since pickupMail is returning a mailItem object, and we
   * need to clear the locker. we need to copy this mailItem object and return it. So this exeption
   * has to be included in this method.
   * @throws LockerEmptyException If the locker is Empty, this LockerEmptyException will be thrown
   */
  public MailItem pickupMail(Recipient recipient)
      throws RecipientNotMatchException, LockerEmptyException, IllegalLengthException {
    if (this.mailItem != null && this.mailItem.getRecipient().equals(recipient)) {
      MailItem copyMailItem = new MailItem(this.mailItem.getWidth(), this.mailItem.getHeight(),
          this.mailItem.getDepth(), this.mailItem.getRecipient());
      this.mailItem = null;
      return copyMailItem;
    } else if (this.mailItem == null) {
      throw new LockerEmptyException();
    } else {
      throw new RecipientNotMatchException();
    }
  }
}
