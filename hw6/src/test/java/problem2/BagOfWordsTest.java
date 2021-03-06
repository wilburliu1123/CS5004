package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BagOfWordsTest {
  IBagOfWords bagOfWords;
  @Before
  public void setUp() throws Exception {
    bagOfWords = IBagOfWords.emptyBagOfWords();
    bagOfWords = bagOfWords.add("Hello");
  }

  @Test
  public void emptyBagOfWords() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    assertTrue(test.isEmpty());
  }

  @Test
  public void getElement() {
    BagOfWords that = (BagOfWords) bagOfWords;
    assertEquals("Hello", that.getElement());
  }

  @Test
  public void getRest() {
    IBagOfWords empty = IBagOfWords.emptyBagOfWords();
    BagOfWords that = (BagOfWords) bagOfWords;
    assertEquals(empty, that.getRest());
  }

  @Test
  public void isEmpty() {
    assertFalse(bagOfWords.isEmpty());
  }

  @Test
  public void size() {
    assertTrue(bagOfWords.size().equals(1));
  }

  @Test
  public void add() {
    bagOfWords = bagOfWords.add("World");
    assertTrue(bagOfWords.contains("World"));
    //test immutability
    bagOfWords.add("Random");
    assertFalse(bagOfWords.size().equals(3));
    assertFalse(bagOfWords.contains("Random"));
  }

  @Test
  public void contains() {
    assertTrue(bagOfWords.contains("Hello"));
  }

  @Test
  public void testEquals() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    test = test.add("Hello");
    assertTrue(bagOfWords.equals(test));
    assertTrue(bagOfWords.equals(bagOfWords));
  }

  @Test
  public void testRemove() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    test = test.add("Hello");
    // test remove element that is not in the bag of words
    BagOfWords words = (BagOfWords) test;
    IBagOfWords afterRemove = words.remove("World");
    assertTrue(afterRemove.equals(test));
    //test immutability
    assertTrue(test.size().equals(1));
    assertTrue(test.contains("Hello"));
    //test remove
    words = (BagOfWords) test;
    afterRemove = words.remove("Hello");
    assertFalse(afterRemove.contains("Hello"));
    // test remove all elements
    test = test.add("World");
    words = (BagOfWords) test;
    IBagOfWords sizeOf1 = words.remove("Hello");
    words = (BagOfWords) sizeOf1;
    IBagOfWords shouldBeEmpty = words.remove("World");
    assertTrue(shouldBeEmpty.isEmpty());
  }
  @Test
  public void testEqualsNullAndDiffClass() {
    Object o = null;
    assertFalse(bagOfWords.equals(o));
    o = new Object();
    assertFalse(bagOfWords.equals(o));
  }
  @Test
  public void testEqualsDiffElements() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    test = test.add("World");
    test = test.add("Hello");
    assertFalse(bagOfWords.equals(test));
    IBagOfWords test2 = IBagOfWords.emptyBagOfWords();
    test2 = test2.add("World");
    assertFalse(bagOfWords.equals(test2));

  }

  @Test
  public void testHashCode() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    test = test.add("Hello");
    assertEquals(bagOfWords.hashCode(), test.hashCode());
    test = test.add("Hello");
    assertFalse(bagOfWords.hashCode() == test.hashCode());
  }

  @Test
  public void testToString() {
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    test = test.add("Hello");
    test = test.add("Hello");
    test = test.add("World");
    assertEquals("{element='World', {element='Hello', {element='Hello', EmptyBagOfWords{}}}}", test.toString());
  }
}