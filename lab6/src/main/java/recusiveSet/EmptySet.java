package recusiveSet;

import java.util.HashMap;

public class EmptySet implements ISet {

  /**
   * Check if the set is empty.
   *
   * @return True if the set is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Add an integer to set.
   *
   * @param n the integer we want to add
   * @return a new set for immutable set
   */
  @Override
  public ISet add(Integer n) {
    return new ConsSet(n, this);
  }

  /**
   * Check if the set contains given integer.
   *
   * @param n given integer to be checked
   * @return return true if it contains the integer, false otherwise
   */
  @Override
  public Boolean contains(Integer n) {
    return false;
  }

  /**
   * Remove given integer from the set.
   *
   * @param n given integer
   * @return a new set for immutable implementation
   */
  @Override
  public ISet remove(Integer n) {
    return this;
  }

  /**
   * this method will return the size of the set
   *
   * @return the size of the set
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Generate a hashcode for EmptySet
   * @return return 31 for this empty node.
   */
  @Override
  public int hashCode() {
    return 31;
  }

  /**
   * Override equals to compare obj with current empty node
   * @param obj given object
   * @return true if given obj is an empty node
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    return super.equals(obj);
  }

  /**
   * return string representation of current empty node
   * @return string representation of current empty node
   */
  @Override
  public String toString() {
    return "EmptySet{}";
  }
}
