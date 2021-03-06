package problem2;

import problem1.EmptyPriorityQueue;

/**
 * A node for Empty Bag of words. Implemented BagOfWords interface
 */
public class EmptyBagOfWords implements IBagOfWords {

  /**
   * Prime number used for hashcode
   */
  private static int NIGHTY_SEVEN = 97;

  /**
   * Check if the BagOfWords is empty. Since this is a empty bag of words, we will always return
   * true
   *
   * @return True if the BagOfWords is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * this method will return the size of the BagOfWords. Duplicate element will be counted as
   * separate elements. Since this is empty bag of words, we will always return 0
   *
   * @return the size of the BagOfWords
   */
  @Override
  public Integer size() {
    return 0;
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
   * Check if the BagOfWords contains given String. Since this is an empty bag of words. It will
   * return false
   *
   * @param s given integer to be checked
   * @return return true if it contains the String, false otherwise
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  /**
   * Override hashcode method to generate hashCode for current empty bag of words. 97 was chosen for
   * this empty bag of words
   *
   * @return 97
   */
  @Override
  public int hashCode() {
    return NIGHTY_SEVEN;
  }

  /**
   * Override equals method to compare given object to current empty bag of words. Return true only
   * if given object is an empty bag of words.
   *
   * @param o given object to be compared with.
   * @return True only if given object is an empty bag of words. False otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    EmptyBagOfWords that = (EmptyBagOfWords) o;
    return that.isEmpty();
  }

  /**
   * Override toString method to generate string representation of given empty bag of words
   *
   * @return a string representation of EmptyBagOfWords.
   */
  @Override
  public String toString() {
    return "EmptyBagOfWords{}";
  }
}
