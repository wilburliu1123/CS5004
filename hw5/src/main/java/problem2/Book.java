package problem2;

import java.util.Objects;

public class Book implements Item {

  private Author author;
  private String name;
  private int year;

  /**
   * constructor for Book object. Given author, year created and name of the book
   * @param author given author of the book
   * @param year year this book was published
   * @param name name of the book
   */
  public Book(Author author, int year, String name) {
    this.author = author;
    this.year = year;
    this.name = name;
  }

  /**
   * This method will return the creator of the item. Author if the item is a book. RecordingArtist
   * or band if it is a music
   *
   * @return creator of this item
   */
  @Override
  public Creator getCreator() {
    return this.author;
  }

  /**
   * This method will return the title of the item
   *
   * @return the title of the item
   */
  @Override
  public String getTitle() {
    return this.name;
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

    return this.author.equals(creator);
  }

  /**
   * Override equals method to compare an object with current book object. Return true only if given
   * object is a book and has same release year and author and name with current book
   * @param o given object being compare to
   * @return true only if given object is a book and has same release year and author
   * and name with current book. False otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return this.year == book.year && this.author.equals(book.author) && this.name.equals(book.name);
  }

  /**
   * Override hashCode method for book object, generate unique hashcode for current book object
   * @return a unique hashcode for current object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.author, this.name, this.year);
  }

  /**
   * Override toString method for current book object to generate string representation of current
   * book object
   * @return the string representation of current book object
   */

  @Override
  public String toString() {
    return "Book{" +
        "author=" + this.author +
        ", name='" + this.name + '\'' +
        ", year=" + this.year +
        '}';
  }
}
