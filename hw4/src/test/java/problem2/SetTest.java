package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
  ISet set;
  @Before
  public void setUp() throws Exception {
    set = Set.emptySet();
    set = set.add(1);
    set = set.add(2);
  }

  @Test
  public void emptySet() {
    ISet test = Set.emptySet();
    assertEquals(0, (int) test.size());
  }

  @Test
  public void isEmpty() {
    ISet test = Set.emptySet();
    assertTrue(test.isEmpty());
  }

  @Test
  public void add() {
    ISet test;
    // test IMMUTABILITY
    test = set.add(3);
    assertEquals(2, (int) set.size());
    test = test.add(4);
    assertEquals(4, (int) test.size());
  }

  @Test
  public void testAddSame() {
    ISet test;
    test = set.add(3);
    test = test.add(3);
    assertEquals(3, (int) test.size());
  }

  @Test
  public void contains() {
    set = set.add(-100);
    assertTrue(set.contains(1));
    assertFalse(set.contains(3));
    assertTrue(set.contains(-100));
  }

  @Test
  public void remove() {
    ISet test = set.remove(1);
    assertFalse(test.contains(1));
    //Test IMMUTABILITY
    assertTrue(set.contains(1));
  }

  @Test
  public void testRemoveNotExist() {
    ISet test = set.remove(3);
    assertTrue(test.equals(set));
  }
  @Test
  public void size() {
    assertEquals(2, (int) set.size());
  }

  @Test
  public void testEquals() {
    ISet test = Set.emptySet();
    test = test.add(1);
    test = test.add(2);
    assertTrue(test.equals(set));
    assertTrue(set.equals(set));
  }

  @Test
  public void testEqualsWithDifferentSequence() {
    ISet test = Set.emptySet();
    test = test.add(2);
    test = test.add(1);
    assertTrue(test.equals(set));
  }

  @Test
  public void testEqualsWithDifferentSequence2() {
    ISet test = Set.emptySet();
    test = test.add(-100);
    test = test.add(2);
    test = test.add(1);
    set = set.add(-100);
    assertTrue(test.equals(set));
  }

  @Test
  public void testEqualsWithManyNumbers() {
    ISet test = Set.emptySet();
    test = test.add(-100);
    test = test.add(2);
    test = test.add(1);
    test = test.add(1234213);
    test = test.add(12593483);
    test = test.add(-342132);
    set = set.add(-100);
    set = set.add(-342132);
    set = set.add(1234213);
    set = set.add(12593483);
    assertTrue(test.equals(set));
  }

  @Test
  public void testNotEquals() {
    ISet test = Set.emptySet();
    test = test.add(3);
    test = test.add(2);
    assertFalse(test.equals(set));
    assertFalse(test.equals(Set.emptySet()));

    assertFalse(set.equals(""));
  }

  @Test
  public void testNull() {
    Object o = null;
    assertFalse(set.equals(o));
  }


  @Test
  public void testHashCode() {
    ISet test = Set.emptySet();
    test = test.add(1);
    test = test.add(2);
    assertEquals(test.hashCode(), set.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Set has{\n"
        + "Integer: 1\n"
        + "Integer: 2\n"
        + " size: 2}", set.toString());
  }
}