package recusiveSet;

/**
 * The interface Set.
 */
public interface ISet {

  /**
   * Generate a new emptySet.
   */
  static ISet emptySet() {
    return new EmptySet();
  }

  /**
   * Check if the set is empty.
   *
   * @return True if the set is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Add an integer to set.
   *
   * @param n the integer we want to add
   * @return a new set for immutable set
   */
  ISet add(Integer n);

  /**
   * Check if the set contains given integer.
   *
   * @param n given integer to be checked
   * @return return true if it contains the integer, false otherwise
   */
  Boolean contains(Integer n);

  /**
   * Remove given integer from the set.
   *
   * @param n given integer
   * @return a new set for immutable implementation
   */
  ISet remove(Integer n);

  /**
   * this method will return the size of the set
   *
   * @return the size of the set
   */
  Integer size();

}
