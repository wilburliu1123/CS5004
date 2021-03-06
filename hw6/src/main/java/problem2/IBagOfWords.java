package problem2;

/**
 * Interface for BagOfWords
 */
public interface IBagOfWords {

  /**
   * Generate a new empty BagOfWords.
   * @return An empty BagOfWords.
   */
  static IBagOfWords emptyBagOfWords() {
    return new EmptyBagOfWords();
  }

  /**
   * Check if the BagOfWords is empty.
   *
   * @return True if the BagOfWords is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * this method will return the size of the BagOfWords. Duplicate element will be counted as separate
   * elements
   *
   * @return the size of the BagOfWords
   */
  Integer size();

  /**
   * Add a String to BagOfWords.
   *
   * @param s the String we want to add to BagOfWords.
   * @return a new BagOfWords for immutable property. new BagOfWords will contain all existing element
   * plus given String
   */
  IBagOfWords add(String s);

  /**
   * Check if the BagOfWords contains given String.
   *
   * @param s given integer to be checked
   * @return return true if it contains the String, false otherwise
   */
  Boolean contains(String s);


}
