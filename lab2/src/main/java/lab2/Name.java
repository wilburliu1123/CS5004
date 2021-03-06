package lab2;

import java.util.Objects;

public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructor for Name class based upon all of the provided input parameters.
   *
   * @param firstName - firstname
   * @param lastName  - last name of this object
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Constructor for Name class based upon all of the provided input parameters.
   *
   * @param firstName  - firstname
   * @param lastName   - last name of this object
   * @param middleName - firstname
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    if (name.middleName == null) return this.firstName.equals(name.firstName) &&
        this.lastName.equals(name.lastName);
    return this.firstName.equals(name.firstName) && this
        .middleName.equals(name.middleName) && this.lastName.equals(name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, middleName, lastName);
  }
}
