package hw9.view;

import hw9.model.Options;
import hw9.model.ParseException;
import hw9.model.Todo;
import java.util.List;

/**
 * Represents shared features of all display.
 */
public interface IDisplay {
    /**
     * Print out the string representation of all Todo objects within the todoList.
     */
    void display();

    /**
     * Gets the list of Todo objects.
     * @return - a list of Todo objects.
     */
    List<Todo> getTodoList();

    /**
     * Creates a new instance of CategoryDecorator based on the kind of category is given.
     */
    IDisplay decorate(Options options) throws IllegalArgumentException, ParseException;

    /**
     * Creates a new instance of CategoryDecorator based on the kind of category that's been provided by the command line.
     * @param todoList - a list of Todo objects.
     * @return - a new instance of CategoryDecorator
     */
    IDisplay decorate(List<Todo> todoList, String category);
}