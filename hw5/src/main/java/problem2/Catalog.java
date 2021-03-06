package problem2;

import java.util.*;

public class Catalog {

  private List<Item> items;
  private static final int ZERO = 0;

  /**
   * Instantiate a catalog without specifying the items in the library. Items can be added later by
   * using addItem method.
   */
  public Catalog() {
    this.items = new ArrayList<>();
  }

  /**
   * Instantiate a catalog with specifying the items in the library. Items can be added/remove later
   * by using addItem/removeItem method.
   *
   * @param items given items to be searched in the list of items in this catalog
   */
  public Catalog(List<Item> items) {
    this.items = items;
  }

  /**
   * Add item to current items in this catalog
   *
   * @param item given item that need to be added to the items list
   */
  public void addItem(Item item) {
    this.items.add(item);
  }

  /**
   * Remove an item from the items list in this catalog. Do nothing if the items is not in the list
   *
   * @param item given item that need to be removed
   */
  public void removeItem(Item item) {
    for (int i = ZERO; i < this.items.size(); i++) {
      if (this.items.get(i).equals(item)) {
        this.items.remove(i);
      }
    }
  }

  /**
   * Search through current items list. if there is an item has title contains the given keyword,
   * add it to the result. return result when finish traverse all items
   *
   * @param keyword given keyword being searched
   * @return A list of items that all containing given keyword. return empty list if none of the
   * item contains the given keyword.
   */
  public List<Item> search(String keyword) {
    List<Item> res = new ArrayList<>();
    String newKeyword = keyword.toLowerCase();
    for (int i = ZERO; i < this.items.size(); i++) {
      Item cur = this.items.get(i);
      if (cur.getTitle().contains(newKeyword)) {
        res.add(cur);
      } else if (cur.getTitle().toLowerCase().contains(newKeyword)) {
        res.add(cur);
      }
    }
    return res;
  }

  /**
   * Overloaded search method for a given author. Return all books that has this author as the
   * creator. Return empty list if no item's author is same as given one
   * @param author given author to be searched
   * @return A list of books that has given author as its creator
   */
  public List<Item> search(Author author) {
    List<Item> res = new ArrayList<>();
    for (int i = ZERO; i < this.items.size(); i++) {
      Item cur = this.items.get(i);
      if (cur.containsCreator(author)) {
        res.add(cur);
      }
    }
    return res;

  }

  /**
   * Overloaded search method for a given Recording artist. Return all music that has this
   * artist as the creator. Return empty list if no item's creator is same as given one.
   * Band is also searched. If the music has a band as its creator and this band contains this given
   * artist, the music will be added to the result list as well.
   * @param artist given artist that need to be searched
   * @return A list of items that has given artist as its creator
   */
  public List<Item> search(RecordingArtist artist) {
    List<Item> res = new ArrayList<>();
    for (int i = ZERO; i < this.items.size(); i++) {
      Item cur = this.items.get(i);
      if (cur.containsCreator(artist)) {
        res.add(cur);
      }
    }
    return res;
  }

  /**
   * Override equals method to compare an object with Catalog
   * @param o given object to be compared with
   * @return true only if given object is a catalog and all items are same
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Catalog)) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(items, catalog.items);
  }

  /**
   * Override hashCode method to generate unique hashcode for current Catalog
   * @return a unique hashCode
   */
  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  /**
   * Override toString method to generate string representation of current catalog object
   * @return A string representation of current Catalog
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "items=" + items +
        '}';
  }
}
