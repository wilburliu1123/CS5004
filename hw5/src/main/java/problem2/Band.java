package problem2;

import java.util.*;

public class Band extends Creator{

  private String name;
  private Set<RecordingArtist> members;

  /**
   * Constructor of the band object. Given the name of the band. members need to be added through
   * addMember method.
   *
   * @param name the name of the band
   */
  public Band(String name) {
    this.name = name;
    this.members = new HashSet<>();
  }

  /**
   * This method allows user to add member to the band.
   *
   * @param person recodingArtist that need to be added to the band
   */
  public void addMember(RecordingArtist person) {
    this.members.add(person);
  }

  /**
   * Remove a member from the band, don't do anything if the person is not in the band
   *
   * @param person the person that need to be removed from the band
   */
  public void removeMember(RecordingArtist person) {
    if(this.members.contains(person)) {
      this.members.remove(person);
    }
    return;
  }

  /**
   * Getter for band name
   *
   * @return the name of the band
   */
  public String getName() {
    return this.name;
  }

  /**
   * Setter for name of the band
   *
   * @param name new name for this band
   */

  public void setName(String name) {
    this.name = name;
  }

  /**
   * this method will return true if this band contains given artist. False otherwise
   * @param artist given artist to be searched
   * @return true if its members contain this artist, false otherwise
   */
  public boolean containsMember(Creator artist) {
    return this.members.contains(artist);
  }

  /**
   * Override equals method to compare a given object to current band object. Return true only if
   * given object is a band and it has same name and members compare to current band object
   *
   * @param o given object
   * @return true only if given object is a band and it has same name and members compare to current
   * band object false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Band)) {
      return false;
    }
    Band band = (Band) o;
    return this.getName().equals(band.getName()) && Objects.equals(this.members, band.members);
  }

  /**
   * Override hashCode method to generate unique hashCode of this Band object
   *
   * @return a unique hashcode of this band object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getName(), this.members);
  }

  /**
   * Override toString method to generate string representation of Band object
   *
   * @return a string representation of this band object
   */
  @Override
  public String toString() {
    String res = "Band{" +
        "name='" + name + '\'' +
        ", members: \n";
    for (RecordingArtist artist : this.members) {
      res += artist.toString();
    }
    return res;
  }
}
