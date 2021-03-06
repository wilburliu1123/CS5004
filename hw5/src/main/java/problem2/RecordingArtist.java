package problem2;

public class RecordingArtist extends Creator {

  /**
   * Constructor for recodingArtist class
   * @param firstName first name of recording artist
   * @param lastName last name of recording artist
   */
  public RecordingArtist(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * override equals method to compare an object with person object. Return true only if the given
   * object is a Person and it has same first and last name with current Person.
   *
   * @param o Given object
   * @return true only if given object is a Person and it's first name and last name is same with
   * current person
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * Override hashCode method to generate unique hashcode for each person object
   *
   * @return return a unique hashCode for each person object
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Override toString method to generate string representation of current person object
   *
   * @return a string representation of current person object.
   */
  @Override
  public String toString() {
    return "RecordingArtist{" +
        "firstName='" + this.firstName + '\'' +
        ", lastName='" + this.lastName + '\'' +
        '}';
  }
}
