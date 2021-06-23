package hw9.view;

import hw9.model.Todo;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DueDecorator class represents Display features when sort todo list by due day is requested by user.
 */
public class DueDecorator extends DefaultDisplay {
    /**
     * sort the todo list by due date.
     * @param todoList a sorted todo list.
     */
    public DueDecorator(List<Todo> todoList) {
        super(todoList.stream().sorted(new DueComparator()).collect(Collectors.toList()));
    }

    /**
     * compare each todo object by its due day.
     */
    private static class DueComparator implements Comparator<Todo> {
        @Override
        public int compare(Todo o1, Todo o2) {
            if (o1.getDue() == null && o2.getDue() != null) return 1;
            else if (o1.getDue() != null && o2.getDue() == null) return -1;
            else if (o1.getDue() == null && o2.getDue() == null) return 0;
            return o1.getDue().compareTo(o2.getDue());
        }
    }
}