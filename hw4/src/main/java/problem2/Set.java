package problem2;

import java.util.Objects;

public class Set implements ISet{
  /**
   * Constants of 0 and 1. Initial slots is set to 3 for easier test cases(resize purpose).
   */
  private Integer[] integers;
  private static final int NUM_SLOTS = 3;
  private static final int ZERO = 0;
  private static final int ONE = 1;
  private int size;

  /**
   * Constructor for empty set
   */
  public Set() {
    this.integers = new Integer[NUM_SLOTS];
    this.size = ZERO;
  }

  /**
   * Constructor for new set
   */
  private Set(Integer[] integers, int size) {
    this.integers = integers;
    this.size = size;
  }

  /**
   * Creates and returns an empty Set
   *
   * @return returns an empty Set
   */
  public static ISet emptySet() {
    ISet set = new Set();
    return set;
  }

  /**
   * Check is current Set is empty. Return true if it is empty, false otherwise
   *
   * @return true if it is empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return this.size == ZERO;
  }
  /**
   * Helper function that checks if there is room in the integers array to add a new integer to the
   * list.
   * @return true if there is space available, false otherwise
   */
  private boolean inSizeRange() {
    return (this.size + ONE <= this.integers.length);
  }

  /**
   * Increase the size of the integers array. This involves creating a temporary new array, adding the
   * existing data to the new array, then setting the data array to the new array.
   * @return a new items array
   */
  private Integer[] resize() {
    int newSize = this.size + NUM_SLOTS;
    Integer[] newItems = new Integer[newSize];
    this.copy(this.integers, newItems);
    return newItems;
  }
  /**
   * Adds the given integer to current set if and only if that Integer is not already in the set.
   *
   * @param n integer that needs to be added
   */
  @Override
  public ISet add(Integer n) {
    Integer[] newIntegers;
    if (!this.inSizeRange()) {
      newIntegers = this.resize();
    } else {
      newIntegers = new Integer[this.integers.length];
      this.copy(this.integers, newIntegers);
    }
    if (!this.contains(n)) {
      newIntegers[this.size] = n;
      return new Set(newIntegers, this.size + ONE);
    }
    return this;
  }

  /**
   * Helper function used by add and remove methods. Copies the items from one array to another.
   * @param from The array to copy from.
   * @param to The array to copy to.
   * @param fromStart The index in the "from" array to start copying from.
   * @param fromEnd The index in the "from" array to end at (exclusive).
   * @param toStart The index in the "to" array to start copying to.
   */
  private void copy(Integer[] from, Integer[] to, int fromStart, int fromEnd, int toStart) {
    int idx = toStart;
    if (idx >= ZERO) {
      for (int i = fromStart; i < fromEnd; i++) {
        to[idx] = from[i];
        idx++;
      }
    }
  }
  /**
   * Helper method to copy the entirety of the "from" array to the "to" array.
   * @param from The array to copy from.
   * @param to The array to copy to.
   */
  private void copy(Integer[] from, Integer[] to) {
    this.copy(from, to, ZERO, from.length, ZERO);
  }

  /**
   * check if given integer is in the Set
   *
   * @param n given integer that is being checked
   * @return true if the given integer is in the Set, false otherwise
   */
  @Override
  public Boolean contains(Integer n) {
    for (int i = ZERO; i < this.size; i++) {
      if (this.integers[i].equals(n)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is.
   *
   * @param n Given Integer that is going to be removed.
   * @return A copy of the Set with given Integer removed. If Integer is not in Set, return as it is
   */
  @Override
  public ISet remove(Integer n) {
    if (!this.contains(n)) {
      return this;
    }
    Integer[] newIntegers = new Integer[this.integers.length];
    this.copy(this.integers, newIntegers);
    for (int i = ZERO; i < this.size; i++) {
      if (this.integers[i] == n) {
        this.copy(this.integers, newIntegers, i + ONE, this.size, i);
      }
    }
    return new Set(newIntegers, this.size - ONE);
  }

  /**
   * Gets the number of items in the Set
   *
   * @return the number of items in the Set
   */
  @Override
  public Integer size() {
    return this.size;
  }

  /**
   * helper function to compare current set to given set.
   * @param set A given set
   * @return true if both set contains the same number, false otherwise.
   */
  private boolean same(ISet set) {
    if(set.size() != this.size)
      return false;
    for (int i = ZERO; i < this.size; i++) {
      if (!set.contains(this.integers[i])) {
        return false;
      }
    }
    return true;
  }
  /**
   * Override equals method in order to compare two Set. Return true if both object are Set and they
   * contains same Integer within them
   * @param o object being compare to
   * @return true if both are set and they contains same Integer. False otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set set1 = (Set) o;
    return this.size == set1.size && this.same(set1);
  }

  /**
   * Override hashcode method to generate unique hashcode for this Set object
   * @return a unique hashcode
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(this.size);
    result = 31 * result;
    for (int i = ZERO; i < this.size; i++) {
      result += Objects.hashCode(this.integers[i]);
    }
    return result;
  }

  /**
   * Override toString method to represent Set in string form
   * @return A string representation of this Set (what Integer it contains)
   */
  @Override
  public String toString() {
    String res = "Set has{";
    for (int i = ZERO; i < this.size; i++) {
      res += "\nInteger: " + this.integers[i];
    }
    return res + "\n size: " + this.size + "}";
  }
}
