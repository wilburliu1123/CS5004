package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseCatalogTest {
  CourseCatalog courseCatalog;
  Course course1, course2, course3, course4;
  @Before
  public void setUp() throws Exception {
    course1 = new Course("OOD", "CS", 5004);
    course2 = new Course("Systems", "CS", 5008);
    course3 = new Course("Discrete Math", "CS", 5002);
    course4 = new Course("Intense Foundation", "CS", 5001);
    courseCatalog = new CourseCatalog();
    courseCatalog.append(course1);
    courseCatalog.append(course2);
    courseCatalog.append(course3);
    courseCatalog.append(course4);
  }

  @Test
  public void append() {
    courseCatalog.append(course1);
    assertEquals(courseCatalog.count(), 5);
    courseCatalog.append(course2);
    courseCatalog.append(course3);
    courseCatalog.append(course4);
    assertEquals(courseCatalog.count(), 8);
  }

  @Test
  public void remove() throws CourseNotFoundException {
    courseCatalog.remove(course4);
    assertEquals(courseCatalog.count(), 3);
  }

  @Test(expected = CourseNotFoundException.class)
  public void removeException() throws CourseNotFoundException {
    courseCatalog.remove(course4);
    courseCatalog.remove(course4);
  }

  @Test
  public void contains() {
    assertTrue(courseCatalog.contains(course4));
  }

  @Test
  public void containsFalse() {
    Course test = new Course("Algorithms", "CS", 5800);
    assertFalse(courseCatalog.contains(test));
  }

  @Test
  public void indexOf() {
    assertEquals(3, courseCatalog.indexOf(course4));
  }

  @Test
  public void testIndexNotFound() {
    Course test = new Course("Algorithms", "CS", 5800);
    assertEquals(-1, courseCatalog.indexOf(test));
  }

  @Test
  public void count() {
    assertEquals(4, courseCatalog.count());
  }

  @Test
  public void get() throws InvalidIndexException {
    assertEquals(course2, courseCatalog.get(1));
  }

  @Test(expected = InvalidIndexException.class)
  public void getTestException() throws InvalidIndexException {
    assertEquals(course2, courseCatalog.get(-1));
  }
  @Test(expected = InvalidIndexException.class)
  public void getTestException2() throws InvalidIndexException {
    assertEquals(course2, courseCatalog.get(111));
  }

  @Test
  public void isEmpty() {
    assertFalse(courseCatalog.isEmpty());
    CourseCatalog testEmpty = new CourseCatalog();
    assertTrue(testEmpty.isEmpty());
  }

  @Test
  public void getCourses() throws InvalidIndexException {
    Course[] test = courseCatalog.getCourses();
    for (int i = 0; i < courseCatalog.count(); i++) {
      assertEquals(test[i], courseCatalog.get(i));
    }
  }

  @Test
  public void testEquals() {
    CourseCatalog test = new CourseCatalog();
    test.append(course1);
    test.append(course2);
    test.append(course3);
    test.append(course4);
    assertTrue(courseCatalog.equals(test));
    assertTrue(courseCatalog.equals(courseCatalog));
  }

  @Test
  public void testNotEquals() {
    CourseCatalog test = new CourseCatalog();
    test.append(course3);
    test.append(course1);
    test.append(course2);
    test.append(course4);
    assertFalse(courseCatalog.equals(test));
  }

  @Test
  public void testDiffLength() {
    CourseCatalog test = new CourseCatalog();
    test.append(course3);
    test.append(course1);
    assertFalse(courseCatalog.equals(test));
  }

  @Test
  public void testNull() {
    Object o = null;
    assertFalse(courseCatalog.equals(o));
  }

  @Test
  public void testDiffClass() {
    assertFalse(courseCatalog.equals(""));
  }

  @Test
  public void testHashCode() {
    CourseCatalog test = new CourseCatalog();
    test.append(course1);
    test.append(course2);
    test.append(course3);
    test.append(course4);
    assertEquals(test.hashCode(), courseCatalog.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("CourseCatalog{\n"
        + "course[0] = CS5004: OOD\n"
        + "course[1] = CS5008: Systems\n"
        + "course[2] = CS5002: Discrete Math\n"
        + "course[3] = CS5001: Intense Foundation\n"
        + "size= 4}", courseCatalog.toString());
  }
}