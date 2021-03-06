package problem2;

import java.util.Objects;

public class Music implements Item{
  private String title;
  private RecordingArtist recordingArtist;
  private Band band;
  private int year;

  /**
   * Constructor for this music that has a recordingArtist as creator
   * @param title title of this music
   * @param year year when this music was released
   * @param recordingArtist creator of this music
   */
  public Music(String title, int year, RecordingArtist recordingArtist) {
    this.title = title;
    this.year = year;
    this.recordingArtist = recordingArtist;
  }

  /**
   * Constructor for music object that has a band as creator
   * @param title title of the music
   * @param year year when music was released
   * @param band the creator of this music
   */
  public Music(String title, int year, Band band) {
    this.title = title;
    this.year = year;
    this.band = band;
  }

  /**
   * This method will return the creator of the item. Author if the item is a book. RecordingArtist
   * or band if it is a music
   *
   * @return creator of this item
   */
  @Override
  public Creator getCreator() {
    return this.band == null ? this.recordingArtist : this.band;
  }

  /**
   * This method will return the title of the item
   *
   * @return the title of the item
   */
  @Override
  public String getTitle() {
    return this.title;
  }

  /**
   * this method would return the year when this item is released or published
   *
   * @return the year of this item is released or published
   */
  @Override
  public int getYearReleased() {
    return this.year;
  }

  /**
   * This method will let individual item to determine if given creator is same as its creator.
   * Return true if the given creator is same as its creator. False other wise.
   *
   * @param creator given creator
   * @return true if given creator is the creator of this item. False otherwise.
   */
  @Override
  public boolean containsCreator(Creator creator) {
    return this.band == null ? this.recordingArtist.equals(creator) : this.band.containsMember(creator);
  }

  /**
   * Override equals method inorder to compare given object with current Music. Return true only if
   * given object is a music and it has same release year and recording artist/band with current
   * music object
   * @param o given object being compared with
   * @return true only if given object is a music and it has same release year and recording
   * artist/band with current music object
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Music)) {
      return false;
    }
    Music music = (Music) o;
    return this.year == music.year && this.getTitle().equals(music.getTitle()) && Objects
        .equals(this.recordingArtist, music.recordingArtist) && Objects.equals(this.band, music.band);
  }

  /**
   * Override hashCode method to generate unique hash code for current music object
   * @return a unique hashcode for current music object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getTitle(), this.recordingArtist, this.band, this.year);
  }

  /**
   * Override toString method to generate string representation of current music object
   * @return a string representation of current music object
   */
  @Override
  public String toString() {
    return "Music{" +
        "title='" + this.title + '\'' +
        ", recordingArtist=" + this.recordingArtist +
        ", band=" + this.band +
        ", year=" + this.year +
        '}';
  }
}
