package hw9.view;

import hw9.model.Todo;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DueDecorator class represents Display features when sort todo list by priority is requested by user.
 */
public class PriorityDecorator extends DefaultDisplay {
    /**
     * sort the todo list by priority.
     * @param todoList a sorted todo list.
     */
    public PriorityDecorator(List<Todo> todoList) {
        super(todoList.stream().sorted(new PriorityComparator()).collect(Collectors.toList()));
    }


    /**
     * compare each todo object by its priority.
     */
    private static class PriorityComparator implements Comparator<Todo> {
        @Override
        public int compare(Todo o1, Todo o2) {
            if (o1.getPriority() == null || o2.getPriority() == null)
                return 0;
            return o1.getPriority().compareTo(o2.getPriority());
        }
    }
}