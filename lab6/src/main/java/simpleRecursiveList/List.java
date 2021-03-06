package simpleRecursiveList;

/**
 * Represents a List of Integers
 */
public interface List {

    /**
     * Returns the total number of elements in the list.
     *
     * @return number of elements in this list
     */
    Integer size();


    /**
     * Returns true if empty and false otherwise
     *
     */
    Boolean isEmpty();

    /**
     * Given a new element {@code element} prepend it to this list
     *
     * @param element new element to add to the list
     * @return updated list with {@code element} prependeds
     */
    List add(Integer element);


    /**
     * Return the last element of this list.
     *
     * @return the last element of this list.
     */
    Integer last();

    /**
     * This method will return element at given index. if the index is invalid, it will throw InvalidCallException
     * @param index given index we trying to return
     * @return return the element at given index
     * @throws InvalidCallException this exception will be thrown if given index is out of boundary
     */
    Integer elementAt(Integer index) throws InvalidCallException;

    /**
     * this method will return true if the given element is in the list. False otherwise.
     * @param element given element we need to check if it is in the list
     * @return true if element is in the list, false otherwise.
     */
    Boolean contains(Integer element);
}
