package problem2;

public interface ISet {



  /**
   * Check is current Set is empty. Return true if it is empty, false otherwise
   * @return true if it is empty, false otherwise
   */
  Boolean isEmpty();

  /**
   * Adds the given integer to current set if and only if that Integer is not already in the set.
   * @param n integer that needs to be added
   * @return new set if given number is not in this set. Return this set if it already contains this
   * Integer
   */
  ISet add(Integer n);

  /**
   * check if given integer is in the Set
   * @param n given integer that is being checked
   * @return true if the given integer is in the Set, false otherwise
   */
  Boolean contains(Integer n);

  /**
   * Returns a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is.
   * @param n Given Integer that is going to be removed.
   * @return A copy of the Set with given Integer removed. If Integer is not in Set, return as it is
   */
  ISet remove(Integer n);

  /**
   * Gets the number of items in the Set
   * @return the number of items in the Set
   */
  Integer size();
}
