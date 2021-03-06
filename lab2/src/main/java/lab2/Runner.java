package lab2;

import java.util.Objects;

public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathon;
  private String favRunningEvent;

  /**
   * Contrusctor for Runner class
   * @param athletesName athletes name
   * @param height height for this athletes
   * @param weight weight for this athletes
   * @param league league name for this athletes
   * @param best5KTime best 5k time for this runner
   * @param bestHalfMarathon best half marathon for this runner
   * @param favRunningEvent favorite running event for this runner
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KTime, Double bestHalfMarathon, String favRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathon = bestHalfMarathon;
    this.favRunningEvent = favRunningEvent;
  }

  public Runner(Name athletesName, Double height, Double weight, Double best5KTime,
      Double bestHalfMarathon, String favRunningEvent) {
    super(athletesName, height, weight);
    this.best5KTime = best5KTime;
    this.bestHalfMarathon = bestHalfMarathon;
    this.favRunningEvent = favRunningEvent;
  }

  /**
   * get Best 5k time returns a double for this runner's best 5k running record
   * @return best5KTime
   */
  public Double getBest5KTime() {
    return best5KTime;
  }
  /**
   * get Best half marathon returns a double for this runner's best half marathon running record
   * @return half marathon
   */
  public Double getBestHalfMarathon() {
    return bestHalfMarathon;
  }
  /**
   * get favRunning Event returns a double for this runner's favorite running event running record
   * @return favorite running event
   */
  public String getFavRunningEvent() {
    return favRunningEvent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Runner runner = (Runner) o;
    return this.best5KTime.equals(runner.getBest5KTime()) &&
        this.bestHalfMarathon.equals(runner.getBestHalfMarathon()) &&
        this.favRunningEvent.equals(runner.getFavRunningEvent());

  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), getBest5KTime(), getBestHalfMarathon(), getFavRunningEvent());
  }
}
