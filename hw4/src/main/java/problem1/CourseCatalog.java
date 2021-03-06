package problem1;

import java.util.Arrays;
import java.util.Objects;

public class CourseCatalog implements ICourseCatalog{

  /**
   * Constants of 0, 1, and 2. Initial slots is set to 3 for easier test cases(resize purpose).
   */
  private static final int INITIAL_SLOTS = 3;
  private static final int ZERO = 0;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private Course[] courses;
  private int size;

  /**
   * Constructor for CourseCatalog
   */
  public CourseCatalog() {
    this.courses = new Course[INITIAL_SLOTS];
    this.size = ZERO;
  }

  /**
   * Adds a Course to the end of the CourseCatalog
   *
   * @param course A course that needs to be added
   */
  @Override
  public void append(Course course) {
    if (!this.inSizeRange()) {
      this.resize();
    }
    this.courses[this.size] = course;
    this.size++;
  }

  /**
   * Helper function that checks if there is room in the courses array to add a new course to the
   * CourseCatalog.
   *
   * @return true if there is space available, false otherwise
   */
  private boolean inSizeRange() {
    return (this.size + ONE <= this.courses.length);
  }

  /**
   * Increase the size of the data array. This involves creating a temporary new array, adding the
   * existing data to the new array, then setting the data array to the new array.
   */
  private void resize() {
    int newSize = this.size * TWO;
    Course[] newCourses = new Course[newSize];
    this.copy(this.courses, newCourses);
    this.courses = newCourses;
  }

  /**
   * Helper function used by append methods. Copies the items from one array to another.
   * @param from The array to copy from.
   * @param to The array to copy to.
   * @param fromStart The index in the "from" array to start copying from.
   * @param fromEnd The index in the "from" array to end at (exclusive).
   * @param toStart The index in the "to" array to start copying to.
   */
  private void copy(Course[] from, Course[] to, int fromStart, int fromEnd, int toStart) {
    int idx = toStart;
    if (idx >= ZERO) {
      for (int i = fromStart; i < fromEnd; i++) {
        to[idx] = from[i];
        idx++;
      }
    }
  }
  /**
   * Shortcut version of the helper method above. Will copy the entirety of the "from" array to the "to" array.
   * @param from The array to copy from.
   * @param to The array to copy to.
   */
  private void copy(Course[] from, Course[] to) {
    this.copy(from, to, ZERO, from.length, ZERO);
  }

  /**
   * Removes a specified Course from the CourseCatalog. Throw a CourseNotFoundException if the
   * Course doesn't exist. If the CourseCatalog contains multiple instances of the same Courses, the
   * instance with the lowest index is removed. The CourseCatalog should not have any empty slots/
   * nodes after a Course is removed. For example, if the CourseCatalog contains 5 items and the
   * Course at index 0 is removed, then the indices of the remaining Courses should be shifted down
   * by 1 -- the Course that was at index 1 should be moved to index 0 and the index of the last
   * Course in the catalog should be 3
   *
   * @param course course that will be removed
   * @throws CourseNotFoundException CourseNotFoundException will be thrown if the course that want
   *                                 to be removed is not in the CourseCatalog
   */
  @Override
  public void remove(Course course) throws CourseNotFoundException {
    if(!this.contains(course)) {
      throw new CourseNotFoundException();
    }
    for (int i = ZERO; i < this.size; i++) {
      if (this.courses[i].equals(course)) {
        this.copy(this.courses, this.courses, i+ONE, this.size, i);
        break;
      }
    }
    this.size--;
  }

  /**
   * Checks if the specified course exists in the CourseCatalog
   *
   * @param course the course that will be checked
   * @return true if the course exists in the CourseCatalog. False otherwise.
   */
  @Override
  public boolean contains(Course course) {
    for (int i = ZERO; i < this.size; i++) {
      if (this.courses[i].equals(course)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the index of the specified Course in the CourseCatalog, if it exists. If the Course
   * doesn't exist, returns -1.
   *
   * @param course the course that will be checked for its index
   * @return the index of the course. If the course doesn't exist, return -1.
   */
  @Override
  public int indexOf(Course course) {
    for (int i = ZERO; i < this.size; i++) {
      if (this.courses[i].equals(course)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Gets the number of Courses in the CourseCatalog.
   *
   * @return the number of courses in the CourseCatalog.
   */
  @Override
  public int count() {
    return this.size;
  }

  /**
   * Returns the Course at the given index in the CourseCatalog. Throws an InvalidIndexException if
   * the index doesn't exist.
   *
   * @param idx index that will be looked up for its corresponding course
   * @return Course in the index given
   * @throws InvalidIndexException if index given does not exist, this InvalidIndexException will be
   * thrown
   */
  @Override
  public Course get(int idx) throws InvalidIndexException {
    if (idx < ZERO || idx >= this.size) {
      throw new InvalidIndexException();
    }
    return this.courses[idx];
  }

  /**
   * Check if the CourseCatalog is Empty
   *
   * @return true if CourseCatalog false if it is not empty.
   */
  @Override
  public boolean isEmpty() {
    return this.size == ZERO;
  }

  /**
   * Getter for all courses in this CourseCatalog
   * @return the array of courses for this CourseCatalog
   */
  public Course[] getCourses() {
    return this.courses;
  }

  /**
   * Helper method that checks if this CourseCatalog contains the same courses than the given
   * courses array. null courses are excluded
   * @param courses the array to compare this.courses to.
   * @return true if both arrays contain the same courses in the same order, false otherwise.
   */
  private boolean sameCourses(Course[] courses) {
    for (int i = ZERO; i < this.size; i++) {
      if (i >= courses.length || !this.courses[i].equals(courses[i])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Override equals method to compare two CourseCatalog. Should return true if and only if the two
   * CourseCatalogs contain the same Courses in the same order.
   * @param o the object that is going to be compare with
   * @return true if o is a CourseCatalog object and it has same courses in same order with this
   * CourseCatalog false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CourseCatalog)) {
      return false;
    }
    CourseCatalog that = (CourseCatalog) o;
    return this.size == that.count() && this.sameCourses(that.getCourses());
  }

  /**
   * Override hashCode method to generate unique hash code for this CourseCatalog object
   * @return a unique hashcode for this CourseCatalog object
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result;
    for (int i = ZERO; i < this.size; i++) {
      result += Objects.hash(this.courses[i]);
    }
    return result;
  }

  /**
   * Overriding toString method that will display imformation about CourseCatalog class
   * @return A String representation of this CourseCatalog object
   */
  @Override
  public String toString() {
    String res = "CourseCatalog{";
    for (int i = ZERO; i < this.size; i++) {
      res += "\ncourse[" + i + "] = " + courses[i];
    }
    res += "\nsize= " + size + "}";
    return res;
  }
}
