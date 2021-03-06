package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
  Book book;
  Author author;
  @Before
  public void setUp() throws Exception {
    author = new Author("Steve", "Hawkins");
    book = new Book(author, 2012, "Random");
  }

  @Test
  public void getCreator() {
    assertEquals(author, book.getCreator());
  }

  @Test
  public void getTitle() {
    assertEquals("Random", book.getTitle());
  }

  @Test
  public void getYearReleased() {
    assertEquals(2012, book.getYearReleased());
  }

  @Test
  public void containsCreator() {
    Creator test = new Author("Steve", "Hawkins");
    assertTrue(book.containsCreator(test));
    Creator testFalse = new Author("Steve1", "HawKins");
    assertFalse(book.containsCreator(testFalse));
  }

  @Test
  public void testEquals() {
    Book test = new Book(author, 2012, "Random");
    assertTrue(test.equals(book));
    assertTrue(book.equals(book));
  }

  @Test
  public void testEqualsWithDiffAuthorOrNameOrYear() {
    Author diffAuthor = new Author("William", "James");
    Book test = new Book(diffAuthor, 2012, "Random");
    assertFalse(test.equals(book));
    test = new Book(author, 2013, "Random");
    assertFalse(test.equals(book));
    test = new Book(author, 2012, "Random1");
    assertFalse(test.equals(book));
  }

  @Test
  public void testEqualsWithDiffClass() {
    Object o = null;
    assertFalse(book.equals(o));
    o = new Object();
    assertFalse(book.equals(o));
  }

  @Test
  public void testHashCode() {
    Book test = new Book(author, 2012, "Random");
    assertNotSame(test.hashCode(), book.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Book{author=Author{firstName='Steve', lastName='Hawkins'}, name='Random', year=2012}", book.toString());
  }
}