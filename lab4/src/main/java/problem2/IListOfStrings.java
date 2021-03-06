package problem2;

public interface IListOfStrings {

  /**
   * Add an item to the list.
   * @param item The item to add.
   */
  void add(String item);

  /**
   * Inserts an item at the specified index.
   * @param item The item to insert.
   * @param index The index that the item will be inserted at. This must be an index that is already occupied.
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  void insert(String item, int index) throws IndexOutOfBoundsException;

  /**
   * Gets the item at the specified index.
   * @param index The index to retrieve.
   * @return The item at the specified index.
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  String get(int index) throws IndexOutOfBoundsException;

  /**
   * The number of items in the list.
   * @return The number of items in the list.
   */
  int size();

  /**
   * Returns true if list is empty, false otherwise.
   * @return true if list is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Check if a string is in the list or not
   * @param item the item you want to loop up in the list
   * @return true if the item is in the list, false otherwise
   */
  boolean contains(String item);

  /**
   * Check if current list of string contains all items from another list of strings
   * @param listOfStrings another list of strings that is compared with current list
   * @return true if all item in another list is in current list, false otherwise
   */
  boolean containsAll(IListOfStrings listOfStrings);

  /**
   * Filter current list of strings such that each string in the list will be less or equal to the
   * length passed in
   * @param length the length you want all strings in the list to be less than or equal to
   * @return a list of strings that has length less or equal to the length required
   */
  IListOfStrings filterLargerThan(int length);

  /**
   * check if current list of strings has any duplicate strings
   * @return true if it contains duplicate, false otherwise
   */
  boolean hasDuplicates();

  /**
   * Check the current list and remove all duplicate.
   * @return a list that does not contain duplicate
   */
  IListOfStrings removeDuplicates();

}
