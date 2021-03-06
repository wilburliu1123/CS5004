package problem2;

import java.util.Objects;

/**
 * A node that represent non-empty BagOfWords. It has element and a pointer to rest of the elements
 * in this BagOfWords
 */
public class BagOfWords implements IBagOfWords{
  private String element;
  private IBagOfWords rest;
  private static int ONE = 1;
  /**
   * Constructor for BagOfWords
   * @param element given elements in this Bag of Words
   * @param rest the rest of words in this bag of words
   */
  public BagOfWords(String element, IBagOfWords rest) {
    this.element = element;
    this.rest = rest;
  }

  /**
   * Getter for element
   * @return current node element
   */
  public String getElement() {
    return this.element;
  }

  /**
   * Getter for the rest.
   * @return rest of words as IBagOfWords
   */
  public IBagOfWords getRest() {
    return this.rest;
  }

  /**
   * Check if the BagOfWords is empty. Since this class represent a non empty bag of words,
   * it will return false
   *
   * @return True if the BagOfWords is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * this method will return the size of the BagOfWords. Duplicate element will be counted as
   * separate elements
   *
   * @return the size of the BagOfWords
   */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  /**
   * Add a String to BagOfWords.
   *
   * @param s the String we want to add to BagOfWords.
   * @return a new BagOfWords for immutable property. new BagOfWords will contain all existing
   * element plus given String
   */
  @Override
  public IBagOfWords add(String s) {
    return new BagOfWords(s, this);
  }

  /**
   * Check if the BagOfWords contains given String.
   *
   * @param s given integer to be checked
   * @return return true if it contains the String, false otherwise
   */
  @Override
  public Boolean contains(String s) {
    if (this.element.equals(s)) return true;
    return this.rest.contains(s);
  }

  /**
   * implemented a remove method in order to compare two BagOfWords. This method will return a new
   * IBagOfWords with current element removed (highest priority). It guarantees immutability
   * @param s given string to be removed
   * @return new IBagOfWords with current element removed.
   */
  public IBagOfWords remove(String s) {
    if (!this.contains(s)) return this;
    if (this.rest.isEmpty()) {
      return new EmptyBagOfWords();
    }
    if (this.element.equals(s)) {
      return this.rest;
    } else {
        BagOfWords that = (BagOfWords) this.rest;
        return new BagOfWords(this.element, that.remove(s));
    }
  }
  /**
   * Override equals method to compare given object with current BagOfWords
   * @param o given object
   * @return true only if given object has exactly same elements as current BagOfWords. False otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BagOfWords)) {
      return false;
    }
    BagOfWords that = (BagOfWords) o;
    if (!this.size().equals(that.size())) return false;
    if (!that.contains(this.element)) return false;
    return this.rest.equals(that.remove(this.element));
  }

  /**
   * Override hashCode to generate hashcode for current BagOfWords
   * @return a hashcode that represent current BagOfWords
   */
  @Override
  public int hashCode() {
    int res = 31 * Objects.hashCode(this.size());
    res += Objects.hashCode(this.element);
    return res + this.rest.hashCode();
  }

  /**
   * Override toString method to generate string representation of current BagOfWords
   * @return a string representation of current BagOfWords
   */
  @Override
  public String toString() {
    return "{element='" + this.element + '\'' +
        ", " + this.rest +
        '}';
  }
}
