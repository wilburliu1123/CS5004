package problem1;

public class CourseNotFoundException extends Exception {

  /**
   * Constructs a new course not found exception with {Course is not found in this course catalog}
   * as its detail message.
   */
  public CourseNotFoundException() {
    super("Course is not found in this course catalog");
  }
}
