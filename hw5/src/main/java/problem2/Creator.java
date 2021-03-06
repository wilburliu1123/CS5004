package problem2;

import java.util.Objects;

public abstract class Creator {
  protected String firstName;
  protected String lastName;

  /**
   * override equals method to compare an object with person object. Return true only if the given
   * object is a Person and it has same first and last name with current Person.
   * @param o Given object
   * @return true only if given object is a Person and it's first name and last name is same with
   * current person
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Creator)) {
      return false;
    }
    Creator creator = (Creator) o;
    return this.firstName.equals(creator.firstName) && this.lastName.equals(creator.lastName);
  }

  /**
   * Override hashCode method to generate unique hashcode for each person object
   * @return return a unique hashCode for each person object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName);
  }

}
