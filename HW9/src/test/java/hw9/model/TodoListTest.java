package hw9.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TodoListTest {
  TodoList todoList;
  TodoList todoList2;
  List<String> line;
  List<String> line2;
  List<List<String>> input;
  List<Todo> testList;
  Todo task1;
  Todo task2;
  Date date1;
  Date date2;

  @Before
  public void setUp() throws Exception {
    date1 = new Date(03/22/2020);
    date2 = new Date(02/28/2020);
    task1 = new Todo.Builder("Homework").addId(1).addDue(date1).addPriority(1).addCategory("school").build();
    task2 = new Todo.Builder("Mail").addId(2).addCompletion().addDue(date2).addPriority(3).addCategory("life").build();
    testList = new ArrayList<>();
    testList.add(task1);
    testList.add(task2);

    input = new ArrayList<>();
    todoList2 = new TodoList(input);

    line = new ArrayList<>();
    line2 = new ArrayList<>();
    line.add("1");
    line.add("Homework");
    line.add("false");
    line.add("3/22/2020");
    line.add("1");
    line.add("school");
    line2.add("2");
    line2.add("Mail");
    line2.add("true");
    line2.add("2/28/2020");
    line2.add("3");
    line2.add("life");
    input.add(line);
    input.add(line2);

    todoList = new TodoList(input);
  }

  @Test
  public void getTodoList() {
    todoList2.addTodo(task1);
    todoList2.addTodo(task2);
    assertTrue(todoList2.getTodoList().equals(testList));
  }

  @Test
  public void testToString() {
    assertEquals("TodoList{inputFile=[[1, Homework, false, 3/22/2020, 1, school], [2, Mail, true, 2/28/2020, 3, life]], todoList=[Todo{id=1, text='Homework', completed=false, due=03/22/2020, priority=1, category='school'}, Todo{id=2, text='Mail', completed=true, due=02/28/2020, priority=3, category='life'}]}", todoList.toString());
  }
}