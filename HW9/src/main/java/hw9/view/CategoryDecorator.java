package hw9.view;

import hw9.model.Options;
import hw9.model.Todo;
import java.util.ArrayList;
import java.util.List;

/**
 * CategoryDecorator class represents Display features when a category is given by user input
 */
public class CategoryDecorator implements IDisplay {
    //  private String category;
    List<Todo> todoList;

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
    public IDisplay decorate(Options options) throws IllegalArgumentException {
        return this;
    }
    /**
     * Creates a new instance of CategoryDecorator based on the kind of category that's been provided by the command line.
     * @param todoList - a list of Todo objects.
     * @return - a new instance of CategoryDecorator
     */
    @Override
    public IDisplay decorate(List<Todo> todoList, String category) {
        return new CategoryDecorator(todoList, category);
    }

    /**
     * Gets the list of Todo objects.
     * @return - a list of Todo objects.
     */
    @Override
    public List<Todo> getTodoList() {
        return this.todoList;
    }

    /**
     * Update todoList based on the input category that has been given by commandline.
     * @param todoList - a list of Todo objects.
     * @param category - the input category that has been given by commandline.
     */
    public CategoryDecorator(List<Todo> todoList, String category) {
        this.todoList = helper(todoList, category);
    }

    /**
     * Helper method to get all the todo that belongs to a given category.
     * @param todoList - a list of Todo objects.
     * @param category - the input category that has been given by commandline.
     * @return a list of Todo  objects that only belongs to a given category.
     */
    private List<Todo> helper(List<Todo> todoList, String category) {
        List<Todo> res = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.getCategory() == null) continue;
            if (todo.getCategory().equals(category)) {
                res.add(todo);
            }
        }
        return res;
    }
}