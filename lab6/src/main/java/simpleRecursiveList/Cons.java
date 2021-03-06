package simpleRecursiveList;

/**
 * Represents a non-emty list of integers
 *
 */
public class Cons implements List {
    private Integer first;
    private List rest;

    /**
     * Given an integer and a list create a new list with the
     * same elements as {@code rest} and with {@code first} prepended.
     *
     * @param first new element to add to the beginning of the list
     * @param rest the list we are going to use to add our new element
     */
    public Cons(Integer first, List rest) {
        this.first = first;
        this.rest = rest;
    }

    /**
     * Getter for property 'first'.
     *
     * @return Value for property 'first'.
     */
    public Integer getFirst() {
        return first;
    }

    /**
     * Getter for property 'rest'.
     *
     * @return Value for property 'rest'.
     */
    public List getRest() {
        return rest;
    }

    /**
     * this method will return the size of the list
     * @return the size the list
     */
    @Override
    public Integer size() {
        return 1 + this.getRest().size(); }

    /**
     * return true if the list is empty, since this is
     * @return false since this is element node (which means the list contains something)
     */
    @Override
    public Boolean isEmpty() {
        return false;
    }

    /**
     * implement add method.
     * @param element new element to add to the list
     * @return a new list (implement immutable)
     */
    @Override
    public List add(Integer element) {

        return new Cons(element, this);
    }

    /**
     * return last element of the list
     * @return last element of the list
     */
    @Override
    public Integer last() {
        if (this.rest.isEmpty()) {
            return this.first;
        } else {
            return this.rest.last();
        }

    }

    /**
     * This method will return element at given index. if the index is invalid, it will throw
     * InvalidCallException
     *
     * @param index given index we trying to return
     * @return return the element at given index
     * @throws InvalidCallException this exception will be thrown if given index is out of boundary
     */
    @Override
    public Integer elementAt(Integer index) throws InvalidCallException {
        this.checkIndex(index);
        if (index.equals(0)) {
            return this.first;
        }
        return this.rest.elementAt(index - 1);
    }
    private void checkIndex(Integer index) throws InvalidCallException {
        if (index >= this.size() || index < 0) throw new InvalidCallException("The index is invalid");
    }
    /**
     * this method will return true if the given element is in the list. False otherwise.
     *
     * @param element given element we need to check if it is in the list
     * @return true if element is in the list, false otherwise.
     */
    @Override
    public Boolean contains(Integer element) {
        if (first.equals(element)) return true;
        return this.rest.contains(element);
    }

    /**
     * Override equal method to compare the object to current list.
     * @param o given object
     * @return true only if
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cons cons = (Cons) o;

        if (getFirst() != null ? !getFirst().equals(cons.getFirst()) : cons.getFirst() != null)
            return false;
        return getRest() != null ? getRest().equals(cons.getRest()) : cons.getRest() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirst() != null ? getFirst().hashCode() : 0;
        result = 31 * result + (getRest() != null ? getRest().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cons{"
            + "first=" + first
            + ", rest=" + rest
            + '}';
    }


}
