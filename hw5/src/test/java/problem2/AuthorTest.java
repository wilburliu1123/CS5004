package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
  Author author;
  @Before
  public void setUp() throws Exception {
    author = new Author("Steve", "Hawkins");
  }

  @Test
  public void testEquals() {
    Author test = new Author("Steve", "Hawkins");
    assertTrue(test.equals(author));
    assertTrue(author.equals(author));
  }

  @Test
  public void testEqualsWithDiffName() {
    Author test = new Author("Steve1", "Hawkins");
    Author test1 = new Author("Steve", "Hawkins1");
    assertFalse(test.equals(author));
    assertFalse(test1.equals(author));
  }
  @Test
  public void testEqualsWithDiffClass() {
    Object o = null;
    assertFalse(author.equals(o));
    o = new Object();
    assertFalse(author.equals(o));
  }
  @Test
  public void testHashCode() {
    Author test = new Author("Steve", "Hawkins");
    assertNotSame(test.hashCode(), author.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Author{firstName='Steve', lastName='Hawkins'}", author.toString());
    Creator test = new Author("Steve", "Hawkins");
    assertEquals("Author{firstName='Steve', lastName='Hawkins'}", author.toString());
  }

}