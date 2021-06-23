package hw9.controller;

import static org.junit.Assert.*;

import hw9.model.ParseException;
import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {
  CommandLineParser parser;
  String[] arg;


  @Before
  public void setUp() throws Exception {
    parser = new CommandLineParser(new String[] {"--csv-file", "test.csv", "--add-todo", "--todo-text", "Homework9", "--completed", "--due", "04/21/2021", "--priority", "2", "--category", "school", "--complete-todo", "1", "--complete-todo", "2", "--display", "--show-incomplete", "--show-category", "school"});
    arg = new String[] {"csv-file", "test.csv", "--add-todo", "--todo-text", "Homework9", "--completed"};
  }

  @Test
  public void getOptions() {
    assertEquals("--csv-file", parser.getOptions().getCsvFile());
    assertEquals("test.csv", parser.getOptions().getPath());
    assertEquals("--add-todo", parser.getOptions().getAddTodo());
    assertEquals("Homework9", parser.getOptions().getDescription());
    assertEquals("--completed", parser.getOptions().getCompleted());
    assertEquals("04/21/2021", parser.getOptions().getDueDate());
    assertEquals("2", parser.getOptions().getPriority());
    assertEquals("school", parser.getOptions().getCategory());
    assertEquals("1 2", parser.getOptions().getCompletedIds());
    assertEquals("--display", parser.getOptions().getDisplay());
    assertEquals("--show-incomplete", parser.getOptions().getShowIncomplete());
    assertEquals("school", parser.getOptions().getShowCategory());
  }

  @Test (expected = ParseException.class)
  public void invalidSort() throws ParseException {
    CommandLineParser invalid = new CommandLineParser(new String[] {"--csv-file", "test.csv", "--sort-by-date", "--sort-by-priority", "--display"});
  }

  @Test (expected = ParseException.class)
  public void optionNoValue() throws ParseException{
    CommandLineParser invalid = new CommandLineParser(new String[] {"--csv-file", "--todo-text"});
  }

  @Test (expected = ParseException.class)
  public void invalidStart() throws ParseException{
    CommandLineParser invalidStart = new CommandLineParser(new String[] {"description", "--csv-file", "--todo-text"});
  }

  @Test (expected = ParseException.class)
  public void invalidCSV() throws ParseException{
    CommandLineParser invalidCsv = new CommandLineParser(new String[] {"description",  "--todo-text"});
  }

  @Test (expected = ParseException.class)
  public void invalidCSV2() throws ParseException{
    CommandLineParser invalidCSV = new CommandLineParser(new String[] {"--csv-file", "path.csv",  "--csv-file",  "--todo-text"});
  }

  @Test (expected = ParseException.class)
  public void invalidAdd() throws ParseException{
    CommandLineParser invalidAdd = new CommandLineParser(new String[] {"--csv-file", "path.csv",  "--csv-file", "--add-todo", "--add-todo", "--todo-text"});
  }
}