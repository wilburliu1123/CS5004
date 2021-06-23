package hw9.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReaderTest {
  List<List<String>> inputData;
  List<String> todo;
  List<String> line;
  String testPath;
  Reader reader;

  @Before
  public void setUp() throws Exception {
    inputData = new ArrayList<>();
    todo = new ArrayList<>();
    line = new ArrayList<>();

    todo.add("1");
    todo.add("Finish HW9");
    todo.add("true");
    todo.add("03/22/2020");
    todo.add("1");
    todo.add("school");

    line.add("\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"");
    line.add("\"1\",\"Finish HW9\",\"true\",\"03/22/2020\",\"1\",\"school\"");

    inputData.add(todo);

    testPath = System.getProperty("user.dir") + "/test.csv";

    reader = new Reader(testPath);
  }

  @Test
  public void readFile() throws ReadFileException {
    assertEquals(line,reader.readFile(testPath));
  }

  @Test (expected = ReadFileException.class)
  public void invalidRead() throws ReadFileException{
    reader.readFile("???.csv");
    reader.readFile("");
    reader.readFile(null);
  }

  @Test
  public void getInputFile() {
    assertEquals(inputData, reader.getInputFile());
  }

  @Test
  public void testToString() {
    assertEquals("Reader{inputFile=[[1, Finish HW9, true, 03/22/2020, 1, school]]}", reader.toString());
  }
}