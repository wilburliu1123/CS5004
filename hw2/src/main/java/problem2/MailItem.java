package problem2;

import java.util.Objects;

public class MailItem {
  private int width;
  private int height;
  private int depth;
  private Recipient recipient;
  private static final int MIN_LENGTH = 1;

  /**
   * constructor for MailItem object
   * @param width The width of this mail item
   * @param height The height of this mail item
   * @param depth the depth of this mail item
   * @param recipient the recipient object of this mail item
   * @throws IllegalLengthException if width or height or depth is less than 1
   */
  public MailItem(int width, int height, int depth, Recipient recipient)
      throws IllegalLengthException {
    if (width < MIN_LENGTH || height < MIN_LENGTH || depth < MIN_LENGTH) {
      throw new IllegalLengthException();
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Getter for width
   * @return width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Getter for height
   * @return height
   */

  public int getHeight() {
    return this.height;
  }
  /**
   * Getter for depth
   * @return depth
   */

  public int getDepth() {
    return this.depth;
  }

  /**
   * Getter for recipient
   * @return recipient object
   */

  public Recipient getRecipient() {
    return this.recipient;
  }
  /**
   * Override equals method to compare two MailItem object
   * @param o An object that is being compared
   * @return true if two MailItem have same width, height, and Recipient object.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    MailItem mailItem = (MailItem) o;
    return this.getWidth() == mailItem.getWidth() && this.getHeight() == mailItem.getHeight()
        && this.getDepth() == mailItem.getDepth() && this.getRecipient().equals(mailItem.getRecipient());
  }

  /**
   * Override hashCode method for MailItem object
   * @return a unique hash code for this MailItem object
   */

  @Override
  public int hashCode() {
    return Objects.hash(this.getWidth(), this.getHeight(), this.getDepth(), this.getRecipient());
  }
}
