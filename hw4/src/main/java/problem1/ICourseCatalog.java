package problem1;

public interface ICourseCatalog {

  /**
   * Adds a Course to the end of the CourseCatalog
   * @param course A course that needs to be added
   */
  void append(Course course);

  /**
   * Removes a specified Course from the CourseCatalog. Throw a CourseNotFoundException if the
   * Course doesn't exist. If the CourseCatalog contains multiple instances of the same Courses, the
   * instance with the lowest index is removed. The CourseCatalog should not have any empty slots/
   * nodes after a Course is removed. For example, if the CourseCatalog contains 5 items and the
   * Course at index 0 is removed, then the indices of the remaining Courses should be shifted down
   * by 1 -- the Course that was at index 1 should be moved to index 0 and the index of the last
   * Course in the catalog should be 3
   * @param course course that will be removed
   * @throws CourseNotFoundException CourseNotFoundException will be thrown if the course that want
   * to be removed is not in the CourseCatalog
   */
  void remove(Course course) throws CourseNotFoundException;

  /**
   * Checks if the specified course exists in the CourseCatalog
   * @param course the course that will be checked
   * @return true if the course exists in the CourseCatalog. False otherwise.
   */
  boolean contains(Course course);

  /**
   * Returns the index of the specified Course in the CourseCatalog, if it exists. If the Course
   * doesn't exist, returns -1.
   * @param course the course that will be checked for its index
   * @return the index of the course. If the course doesn't exist, return -1.
   */
  int indexOf(Course course);

  /**
   * Gets the number of Courses in the CourseCatalog.
   * @return the number of courses in the CourseCatalog.
   */
  int count();

  /**
   * Returns the Course at the given index in the CourseCatalog. Throws an InvalidIndexException if
   * the index doesn't exist.
   * @param idx index that will be looked up for its corresponding course
   * @return Course in the index given
   * @throws InvalidIndexException if index given does not exist, this InvalidIndexException will be
   * thrown
   */
  Course get(int idx) throws InvalidIndexException;

  /**
   * Check if the CourseCatalog is Empty
   * @return true if CourseCatalog false if it is not empty.
   */
  boolean isEmpty();
}
