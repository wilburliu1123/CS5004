package problem2;

import java.util.Objects;

public class Recipient {
  private String firstName;
  private String lastName;
  private String emailAddress;

  /**
   * Constructor for recipient object
   * @param firstName first name of this recipient
   * @param lastName last name of this recipient
   * @param emailAddress email address of this recipient
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * Getter for firstName field
   * @return firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Getter for lastName field
   * @return lastName
   */

  public String getLastName() {
    return this.lastName;
  }
  /**
   * Getter for emailAddress field
   * @return emailAddress
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }

  /**
   * Override equals method to compare two recipient object
   * @param o An object that is being compared
   * @return true if two recipient have same firstName, lastName, and email address
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return this.getFirstName().equals(recipient.getFirstName()) && this.getLastName()
        .equals(recipient.getLastName()) && this.getEmailAddress().equals(recipient.getEmailAddress());
  }

  /**
   * Override hashCode method for recipient object
   * @return a unique hash code for this recipient object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getLastName(), this.getEmailAddress());
  }
}
