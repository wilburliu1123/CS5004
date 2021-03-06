package lab2;

public class BaseballPlayer extends Athlete {
  private String team;
  private Double avgBatting;
  private Integer homeRun;

  /**
   * Contructor for baseball player class
   * @param athletesName name of this baseball player (inherited from super class)
   * @param height height of this base ball player
   * @param weight weight of this baseball player
   * @param league league of this baseball player
   * @param team baseball player's team
   * @param avgBatting average batting per season
   * @param homeRun home run per season
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double avgBatting, Integer homeRun) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.avgBatting = avgBatting;
    this.homeRun = homeRun;
  }

  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double avgBatting, Integer homeRun) {
    super(athletesName, height, weight);
    this.team = team;
    this.avgBatting = avgBatting;
    this.homeRun = homeRun;
  }

  /**
   * getTeam method returns teams name (String)
   * @return team
   */
  public String getTeam() {
    return team;
  }

  /**
   * getAvgBatting returns avgBatting per season
   * @return
   */
  public Double getAvgBatting() {
    return avgBatting;
  }

  /**
   * getHomeRun returns homeRun per season
   * @return
   */
  public Integer getHomeRun() {
    return homeRun;
  }
}
