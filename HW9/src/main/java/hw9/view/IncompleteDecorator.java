package hw9.view;

import hw9.model.Todo;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represent a customized display, when no only incomplete todo are shown based on the command line instructions are given.
 */
public class IncompleteDecorator extends DefaultDisplay {
    /**
     * filter the todo list and only incomplete todo are kept.
     * @param todoList - a list of todo objects.
     */
    public IncompleteDecorator(List<Todo> todoList) {
        super(todoList.stream().filter(Todo -> Todo.getCompleted().equals(false)).collect(Collectors.toList()));
    }
}