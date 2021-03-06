package problem2;

import java.util.Objects;

public class LinkedListOfStrings implements IListOfStrings {

  private Node head;
  private int numNodes;

  public LinkedListOfStrings() {
    this.head = null;
    this.numNodes = 0;
  }

  /**
   * Creates an empty list.
   *
   * @return An empty list.
   */
  public static LinkedListOfStrings createEmpty() {
    return new LinkedListOfStrings();
  }

  /**
   * Add an item to the list.
   *
   * @param item The item to add.
   */
  @Override
  public void add(String item) {
    Node newNode = new Node(item, null);
    if (this.head == null) {
      this.head = newNode;
    } else {
      Node currNode = this.head;
      while (currNode.getNextNode() != null) {
        currNode = currNode.getNextNode();
      }
      currNode.setNextNode(newNode);
    }
    this.numNodes++;
  }

  /**
   * Inserts an item at the specified index.
   *
   * @param item  The item to insert.
   * @param index The index that the item will be inserted at. This must be an index that is already
   *              occupied.
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  @Override
  public void insert(String item, int index) throws IndexOutOfBoundsException {
    this.checkBounds(index);
    Node newNode = new Node(item, null);
    if (index == 0) {
      newNode.setNextNode(this.head);
      this.head = newNode;
    } else {
      int i = 0;
      Node currNode = this.head;
      while (i < index - 1) {
        i++;
        currNode = currNode.getNextNode();
      }
      newNode.setNextNode(currNode.getNextNode());
      currNode.setNextNode(newNode);
    }
    this.numNodes++;
  }

  /**
   * Helper method used by get and insert. Checks if the provided index is in bounds.
   *
   * @param index The index to use.
   * @throws IndexOutOfBoundsException
   */
  private void checkBounds(int index) throws IndexOutOfBoundsException {
    if (index >= this.numNodes || index < 0) {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Gets the item at the specified index.
   *
   * @param index The index to retrieve.
   * @return The item at the specified index.
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  @Override
  public String get(int index) throws IndexOutOfBoundsException {
    this.checkBounds(index);
    Node currNode = this.head;
    int i = 0;
    while (i < index) {
      i++;
      currNode = currNode.getNextNode();
    }
    return currNode.getItem();
  }

  /**
   * The number of items in the list.
   *
   * @return The number of items in the list.
   */
  @Override
  public int size() {
    return this.numNodes;
  }

  /**
   * Returns true if list is empty, false otherwise.
   *
   * @return true if list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return this.size() == 0;
  }

  /**
   * Check if a string is in the list or not
   *
   * @param item the item you want to loop up in the list
   * @return true if the item is in the list, false otherwise
   */
  @Override
  public boolean contains(String item) {
    Node curNode = this.head;
    while (curNode != null) {
      if (curNode.getItem().equals(item)) {
        return true;
      }
      curNode = curNode.getNextNode();
    }
    return false;
  }

  /**
   * Check if current list of string contains all items from another list of strings
   *
   * @param listOfStrings another list of strings that is compared with current list
   * @return true if all item in another list is in current list, false otherwise
   */
  @Override
  public boolean containsAll(IListOfStrings listOfStrings) {
    Node curNode = this.head;
    while (curNode != null) {
      if (!listOfStrings.contains(curNode.getItem())) {
        return false;
      }
      curNode = curNode.getNextNode();
    }
    return true;
  }

  /**
   * Filter current list of strings such that each string in the list will be less or equal to the
   * length passed in
   *
   * @param length the length you want all strings in the list to be less than or equal to
   * @return a list of strings that has length less or equal to the length required
   */
  @Override
  public IListOfStrings filterLargerThan(int length) {
    IListOfStrings res = LinkedListOfStrings.createEmpty();
    Node curNode = this.head;
    while (curNode != null) {
      if (curNode.getItem().length() <= length) {
        res.add(curNode.getItem());
      }
      curNode = curNode.getNextNode();
    }
    return res;
  }

  /**
   * check if current list of strings has any duplicate strings
   *
   * @return true if it contains duplicate, false otherwise
   */
  @Override
  public boolean hasDuplicates() {
    IListOfStrings res = LinkedListOfStrings.createEmpty();
    Node curNode = this.head;
    while (curNode != null) {
      if (res.contains(curNode.getItem())) {
        return false;
      }
      res.add(curNode.getItem());
    }
    return true;
  }

  /**
   * Check the current list and remove all duplicate.
   *
   * @return a list that does not contain duplicate
   */
  @Override
  public IListOfStrings removeDuplicates() {
    IListOfStrings res = LinkedListOfStrings.createEmpty();
    Node curNode = this.head;
    while (curNode != null) {
      if (!res.contains(curNode.getItem())) {
        res.add(curNode.getItem());
      }
    }
    return res;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkedListOfStrings that = (LinkedListOfStrings) o;
    return numNodes == that.numNodes &&
        Objects.equals(head, that.head);
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, numNodes);
  }

  @Override
  public String toString() {
    return "LinkedListOfStrings{" +
        "head=" + head +
        ", numNodes=" + numNodes +
        '}';
  }
}

