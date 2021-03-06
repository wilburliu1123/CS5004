package problem1;

import java.util.Objects;
public class Course {
    private final String name;
    private final String prefix;
    private final int number;

    /**
     * Constructor for Course object
     * @param name the name of the course
     * @param prefix prefix of the course (for example, CS for computer science)
     * @param number course number
     */
    public Course(String name, String prefix, int number) {
        this.name = name;
        this.prefix = prefix;
        this.number = number;
    }

    /**
     * Override toString method to generate string representation of Course object
     * @return string representation of this course Object
     */
    @Override
    public String toString() {
        return prefix + number + ": " + name;
    }

    /**
     * Override equals method to compare an object with current course. Return true if given object
     * has same name, prefix and number with current course object
     * @param o given object needed to be compared with
     * @return true if has same name, prefix and number with current course object. False otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return number == course.number &&
                name.equals(course.name) &&
                prefix.equals(course.prefix);
    }

    /**
     * Override hashCode method to generate unique hashCode for current Course object
     * @return a unique hash code for current course object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, prefix, number);
    }


}
