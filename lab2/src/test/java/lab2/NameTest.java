package lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  Name name, name2;
  @Before
  public void setUp() throws Exception {
    name = new Name("Hello", "World");
    name2 = new Name("Yes", "Middle", "last");
  }

  @Test
  public void getFirstName() {
    assertEquals("Hello", name.getFirstName());
  }

  @Test
  public void getMiddleName() {
    assertEquals("Middle", name2.getMiddleName());
  }

  @Test
  public void getLastName() {
    assertEquals("World", name.getLastName());
  }
  @Test
  public void equals() {
    Name test = new Name("Hello", "World");
    Name test2 = new Name("Yes", "Middle", "last");
    assertTrue(name.equals(name));
    assertFalse(name.equals(null));
    assertEquals(test, name);
    assertEquals(test2, name2);
  }
}