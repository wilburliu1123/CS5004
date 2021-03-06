package lab2;

import java.util.Objects;

public class Athlete {

  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   *
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height       - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                     187.96cm) * @param weight - athlete's weigh, expressed as a Double in
   *                     pounds (e.g. 125, 155, 200 pounds)
   * @param league       - athelete's league, expressed as String
   */
  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   *
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height       - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                     187.96cm)
   * @param weight       - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200
   *                     pounds)
   */
  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
   * Returns athlete's name as an object Name
   */
  public Name getAthletesName() {
    return athletesName;
  }

  /**
   * Returns athlete's height as a Double
   */
  public Double getHeight() {
    return height;
  }

  /**
   * Returns athlete's weight as a Double
   */
  public Double getWeight() {
    return weight;
  }

  /**
   * overide the equals method for comparison
   * @param o object needs to be compared
   * @return true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return this.athletesName.equals(athlete.getAthletesName()) && this.height
        .equals(athlete.getHeight()) && this.weight.equals(athlete.getWeight()) && this.league
        .equals(athlete.league);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAthletesName(), getHeight(), getWeight(), league);
  }
}
