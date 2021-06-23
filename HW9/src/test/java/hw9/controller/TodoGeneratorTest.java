package hw9.controller;

import static org.junit.Assert.*;

import hw9.model.Options;
import hw9.model.ParseException;
import hw9.model.Todo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TodoGeneratorTest {
  TodoGenerator todoGenerator;
  TodoGenerator todoGenerator2;
  Options option;
  List<String> inputData;
  List<String> inputData2;
  Todo todo1;
  Todo todo2;
  Todo todo3;
  Date date;

  @Before
  public void setUp() throws Exception {
    todoGenerator = new TodoGenerator();
    todoGenerator2 = new TodoGenerator();

    option = new Options.Builder().build();
    option.setCsvFile("csv-file");
    option.setPath("file.csv");
    option.setAddTodo("add-todo");
    option.setDescription("todo-text");
    option.setCompleted("--completed");
    option.setDueDate("4/21/2021");
    option.setPriority("2");
    option.setCategory("school");
    option.setCompleteToDo("complete-todo");
    option.setCompletedIds("1");
    option.setDisplay("display");
    option.setShowIncomplete("show-incomplete");
    option.setShowCategory("show-category");
    option.setSortByDate("sort-by-date");
    option.setSortByPriority("sort-by-priority");

    inputData = new ArrayList<>();
    inputData.add("1");
    inputData.add("Homework");
    inputData.add("true");
    inputData.add("04/21/2021");
    inputData.add("1");
    inputData.add("school");

    inputData2 = new ArrayList<>();
    inputData2.add("2");
    inputData2.add("Homework");
    inputData2.add("false");
    inputData2.add("?");
    inputData2.add("?");
    inputData2.add("?");

    date = new Date(04/21/2021);
    todo1 = new Todo.Builder("todo-text").addCompletion().addDue(date).addPriority(2).addCategory("school").build();
    todo2 = new Todo.Builder("Homework").addId(1).addCompletion().addDue(date).addPriority(1).addCategory("school").build();
    todo3 = new Todo.Builder("Homework").addId(2).build();
  }

  @Test
  public void generateTodo() throws ParseException, java.text.ParseException {
    assertTrue(todoGenerator.generateTodo(option).getCompleted().equals(todo1.getCompleted()));
    assertTrue(todoGenerator.generateTodo(option).getText().equals(todo1.getText()));
    assertTrue(todoGenerator.generateTodo(option).getCategory().equals(todo1.getCategory()));
    assertTrue(todoGenerator.generateTodo(option).getPriority().equals(todo1.getPriority()));
    assertTrue(todoGenerator.generateTodo(option).getDue().compareTo(todo1.getDue()) == 1);
    option.setCompleted(null);
    assertFalse(todoGenerator.generateTodo(option).getCompleted());
    option.setPriority(null);
    assertTrue(todoGenerator.generateTodo(option).getPriority() == 4);
    option.setCategory(null);
    assertTrue(todoGenerator.generateTodo(option).getCategory() == null);
    option.setDueDate(null);
    assertTrue(todoGenerator.generateTodo(option).getDue() == null);
  }

  @Test
  public void testGenerateTodo() throws ParseException, java.text.ParseException {
    assertTrue(todoGenerator.generateTodo(inputData).getId() == todo2.getId());
    assertTrue(todoGenerator.generateTodo(inputData).getText().equals(todo2.getText()));
    assertTrue(todoGenerator.generateTodo(inputData).getCompleted().equals(todo2.getCompleted()));
    assertTrue(todoGenerator.generateTodo(inputData).getPriority().equals(todo2.getPriority()));
    assertTrue(todoGenerator.generateTodo(inputData).getCategory().equals(todo2.getCategory()));
    assertTrue(todoGenerator.generateTodo(inputData).getDue().compareTo(todo2.getDue()) == 1);

    assertTrue(todoGenerator2.generateTodo(inputData2).getCompleted().equals(todo3.getCompleted()));
    assertTrue(todoGenerator2.generateTodo(inputData2).getPriority().equals(todo3.getPriority()));
    assertTrue(todoGenerator2.generateTodo(inputData2).getCategory() == null);
    assertTrue(todoGenerator.generateTodo(inputData2).getDue() == null);
  }
}