package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
  Course course;
  @Before
  public void setUp() throws Exception {
    course = new Course("OOD", "CS", 5004);
  }

  @Test
  public void testToString() {
    assertEquals("CS5004: OOD", course.toString());
  }

  @Test
  public void testEquals() {
    Course test = new Course("OOD", "CS", 5004);
    assertEquals(test, course);
    assertTrue(course.equals(course));
    assertFalse(course.equals(""));
  }

  @Test
  public void testNull() {
    Object o = null;
    assertFalse(course.equals(o));
  }

  @Test
  public void testDiffName() {
    Course test = new Course("OOD1", "CS", 5004);
    assertFalse(course.equals(test));
  }

  @Test
  public void testDiffPref() {
    Course test = new Course("OOD", "MA", 5004);
    assertFalse(course.equals(test));
  }
  @Test
  public void testDiffNum() {
    Course test = new Course("OOD", "CS", 5008);
    assertFalse(course.equals(test));
  }

  @Test
  public void testHashCode() {
    Course test = new Course("OOD", "CS", 5004);
    assertEquals(test.hashCode(), course.hashCode());
  }
}