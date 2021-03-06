package problem2;

public interface Item {

  /**
   * This method will return the creator of the item. Author if the item is a book. RecordingArtist
   * or band if it is a music
   * @return creator of this item
   */
  Creator getCreator();

  /**
   * This method will return the title of the item
   * @return the title of the item
   */
  String getTitle();

  /**
   * this method would return the year when this item is released or published
   * @return the year of this item is released or published
   */
  int getYearReleased();

  /**
   * This method will let individual item to determine if given creator is same as its creator.
   * Return true if the given creator is same as its creator. False other wise.
   * @param creator given creator
   * @return true if given creator is the creator of this item. False otherwise.
   */
  boolean containsCreator(Creator creator);
}
