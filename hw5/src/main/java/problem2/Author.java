package problem2;

public class Author extends Creator {

  /**
   * Constructor for Author object. Assign given firstname and lastname to curernt author's first
   * and last name.
   * @param firstName first name of the author
   * @param lastName last name of the author
   */
  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * override equals method to compare an object with Author object. Return true only if the given
   * object is a Author and it has same first and last name with current Author.
   *
   * @param o Given object
   * @return true only if given object is a Author and it's first name and last name is same with
   * current Author
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * Override hashCode method to generate unique hashcode for each Author object
   *
   * @return return a unique hashCode for each Author object
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Override toString to generate a string representation of current Author object
   * @return A string representation of current author object
   */
  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
