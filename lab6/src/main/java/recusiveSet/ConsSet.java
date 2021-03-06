package recusiveSet;

import java.util.Objects;

public class ConsSet implements ISet {
  private Integer first;
  private ISet rest;

  public ConsSet(Integer first, ISet rest) {
    this.first = first;
    this.rest = rest;
  }

  public Integer getFirst() {
    return first;
  }

  public ISet getRest() {
    return rest;
  }

  /**
   * Check if the set is empty.
   *
   * @return True if the set is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Add an integer to set.
   *
   * @param n the integer we want to add
   * @return a new set for immutable set
   */
  @Override
  public ISet add(Integer n) {
    if (!this.contains(n))
      return new ConsSet(n, this);
    return this;
  }

  /**
   * Check if the set contains given integer.
   *
   * @param n given integer to be checked
   * @return return true if it contains the integer, false otherwise
   */
  @Override
  public Boolean contains(Integer n) {
    if (this.first.equals(n)) return true;
    return this.rest.contains(n);
  }

  /**
   * Remove given integer from the set.
   *
   * @param n given integer
   * @return a new set for immutable implementation
   */
  @Override
  public ISet remove(Integer n) {
    if (!this.contains(n)) return this;
    // if head is what we want to remove
    if (this.first.equals(n)) {
      return this.rest;
    } else {
      return new ConsSet(this.first, this.rest.remove(n));
    }
  }

  /**
   * this method will return the size of the set
   *
   * @return the size of the set
   */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ConsSet)) {
      return false;
    }
    ConsSet consSet = (ConsSet) o;
    if (!this.size().equals(consSet.size())) return false;
    if (!consSet.contains(this.first)) return false;
    return this.rest.equals(consSet.remove(this.first));
  }

  @Override
  public int hashCode() {
    int res = 31 * Objects.hashCode(this.size());
    res += Objects.hashCode(this.first);
    return res + this.rest.hashCode();
  }

  @Override
  public String toString() {
    return "ConsSet{" +
        "first=" + first +
        ", rest=" + rest +
        '}';
  }
}
