package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyBagOfWordsTest {
  IBagOfWords bagOfWords;
  @Before
  public void setUp() throws Exception {
    bagOfWords = IBagOfWords.emptyBagOfWords();
  }

  @Test
  public void emptyBagOfWords() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    assertTrue(test.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(bagOfWords.isEmpty());
  }

  @Test
  public void size() {
    assertTrue(bagOfWords.size().equals(0));
  }

  @Test
  public void add() {
    bagOfWords = bagOfWords.add("S");
    assertFalse(bagOfWords.size().equals(0));
  }

  @Test
  public void contains() {
    bagOfWords.contains("s");
  }

  @Test
  public void testHashCode() {
    assertEquals(bagOfWords.hashCode(), 97);
  }

  @Test
  public void testEquals() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    assertTrue(bagOfWords.equals(test));
    assertTrue(bagOfWords.equals(bagOfWords));
  }


  @Test
  public void testEqualsDiffClassAndNull() {
    Object o = null;
    assertFalse(bagOfWords.equals(o));
    o = new Object();
    assertFalse(bagOfWords.equals(o));
  }


  @Test
  public void testToString() {
    assertEquals("EmptyBagOfWords{}", bagOfWords.toString());
  }
}