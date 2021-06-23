package hw9.view;

import hw9.model.Options;
import hw9.model.Todo;

import java.util.List;

/**
 * Represent a default display, when no additional command line instructions are given.
 */
public class DefaultDisplay implements IDisplay {
    private List<Todo> todoList;
    private boolean sortFlag;

    /**
     * Constructor for DefaultDisplay.
     * @param todoList - a list of Todo objects.
     */
    public DefaultDisplay(List<Todo> todoList) {
        sortFlag = false;
        this.todoList = todoList;
    }

    /**
     * Gets the list of Todo objects.
     * @return - a list of Todo objects.
     */
    public List<Todo> getTodoList() {
        return this.todoList;
    }

    /**
     * Print out the string representation of all Todo objects within the todoList.
     */
    @Override
    public void display() {
        for (Todo todo : todoList) {
            System.out.println(todo);
        }
    }

    /**
     * Creates a new instance of CategoryDecorator based on the kind of category is given.
     */
    @Override
    public IDisplay decorate(List<Todo> todoList, String category) {
        return new CategoryDecorator(todoList, category);
    }

    /**
     * Creates a new instance of CategoryDecorator based on the kind of category that's been provided by the command line.
     * @param options - a Option object parsed from a commandline.
     * @return - a new instance of CategoryDecorator
     * @throws IllegalArgumentException
     */
    @Override
    public IDisplay decorate(Options options) throws IllegalArgumentException {
        IDisplay decorated = this;
        if (options.getShowIncomplete() != null) {
            decorated = new IncompleteDecorator(decorated.getTodoList());
        }
        if (options.getShowCategory() != null) {
            decorated = decorated.decorate(decorated.getTodoList(), options.getShowCategory());
        }
        if (options.getSortByDate() != null) {
            decorated = new DueDecorator(decorated.getTodoList());
        }
        if (options.getSortByPriority() != null) {
            decorated = new PriorityDecorator(decorated.getTodoList());
        }
        return decorated;
    }
}
