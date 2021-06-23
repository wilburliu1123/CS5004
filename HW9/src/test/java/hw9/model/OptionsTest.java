package hw9.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class OptionsTest {
  Options test1;
  Options test2;
  Options test3;
  Options test4;
  Options test5;
  Options test6;
  Options test7;
  Options test8;
  Options test9;
  Options test10;
  Options test11;
  Options test12;
  Options test13;
  Options test14;
  Options test15;
  Options test16;
  Date date;

  @Before
  public void Setup() throws Exception {
    date = new Date(01/01/2021);
    test1 = new Options.Builder().build();
    test2 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test3 = new Options.Builder().csvFile("txt-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test4 = new Options.Builder().csvFile("csv-file").path("test.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test5 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test6 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test7 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("complete").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test8 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("date").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test9 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priorities").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test10 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("categories").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test11 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("completed-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test12 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("Display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test13 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show_incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test14 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show_category").sortByDate("sort-by-date").sortByPriority("sort-by-priority").build();
    test15 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-date").sortByPriority("sort-by-priority").build();
    test16 = new Options.Builder().csvFile("csv-file").path("file.csv").addTodo("add-todo").description("todo-text").completed("completed").dueDate("due").priority("priority").category("category").completeTodo("complete-todo").completedIds("1").display("display").showIncomplete("show-incomplete").showCategory("show-category").sortByDate("sort-by-date").sortByPriority("sort-priority").build();

    test1.setCsvFile("csv-file");
    test1.setPath("file.csv");
    test1.setAddTodo("add-todo");
    test1.setDescription("todo-text");
    test1.setCompleted("completed");
    test1.setDueDate("due");
    test1.setPriority("priority");
    test1.setCategory("category");
    test1.setCompleteToDo("complete-todo");
    test1.setCompletedIds("1");
    test1.setDisplay("display");
    test1.setShowIncomplete("show-incomplete");
    test1.setShowCategory("show-category");
    test1.setSortByDate("sort-by-date");
    test1.setSortByPriority("sort-by-priority");
  }

  @Test
  public void getCsvFile() {
    assertEquals("csv-file",test1.getCsvFile());
  }

  @Test
  public void getPath() {
    assertEquals("file.csv",test1.getPath());
  }

  @Test
  public void getAddTodo() {
    assertEquals("add-todo",test1.getAddTodo());
  }

  @Test
  public void getDescription() {
    assertEquals("todo-text", test1.getDescription());
  }

  @Test
  public void getCompleted() {
    assertEquals("completed", test1.getCompleted());
  }

  @Test
  public void getDueDate() {
    assertEquals("due", test1.getDueDate());
  }

  @Test
  public void getPriority() {
    assertEquals("priority", test1.getPriority());
  }

  @Test
  public void getCategory() {
    assertEquals("category", test1.getCategory());
  }

  @Test
  public void getCompleteToDo() {
    assertEquals("complete-todo", test1.getCompleteToDo());
  }

  @Test
  public void getCompleteIds() { assertEquals("1",test1.getCompletedIds());}

  @Test
  public void getDisplay() {
    assertEquals("display", test1.getDisplay());
  }

  @Test
  public void getShowInComplete() {
    assertEquals("show-incomplete", test1.getShowIncomplete());
  }

  @Test
  public void getShowCategory() {
    assertEquals("show-category", test1.getShowCategory());
  }

  @Test
  public void getSortByDate() {
    assertEquals("sort-by-date", test1.getSortByDate());
  }

  @Test
  public void getSortByPriority() {
    assertEquals("sort-by-priority", test1.getSortByPriority());
  }

  @Test
  public void testEquals() {
    assertTrue(test1.equals(test1));
    assertTrue(test1.equals(test2));
    test2.setCsvFile("csv");
    assertFalse(test1.equals(test2));
    assertFalse(test1.equals(test3));
    assertFalse(test1.equals(test4));
    assertFalse(test1.equals(test5));
    assertFalse(test1.equals(test6));
    assertFalse(test1.equals(test7));
    assertFalse(test1.equals(test8));
    assertFalse(test1.equals(test9));
    assertFalse(test1.equals(test10));
    assertFalse(test1.equals(test11));
    assertFalse(test1.equals(test12));
    assertFalse(test1.equals(test13));
    assertFalse(test1.equals(test14));
    assertFalse(test1.equals(test15));
    assertFalse(test1.equals(test16));
    assertFalse(test1.equals(null));
    assertFalse(test1.equals(""));
  }

  @Test
  public void testHashCode() {
    assertTrue(test1.hashCode() == test2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Options{csvFile='csv-file', path='file.csv', addTodo='add-todo', description='todo-text', completed='completed', dueDate='due', priority='priority', category='category', completeToDo='complete-todo', completedIds='1', display='display', showIncomplete='show-incomplete', showCategory='show-category', sortByDate='sort-by-date', sortByPriority='sort-by-priority'}", test1.toString());
  }
}