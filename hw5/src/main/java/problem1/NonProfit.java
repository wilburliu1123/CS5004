package problem1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NonProfit {

  private static final int ZERO = 0;
  private String orgName;
  private List<IDonation> donations;

  /**
   * Constructor for NonProfit class. Given the organization name
   * @param orgName given organization name
   */
  public NonProfit(String orgName) {
    this.orgName = orgName;
    this.donations = new ArrayList<>();
  }

  /**
   * this method will add donation to this Non-profits donation list
   *
   * @param donation A donation that need to be recorded in this non profit donation list
   */
  public void addDonation(IDonation donation) {
    this.donations.add(donation);
  }

  public int getTotalDonationsForYear(int year) {
    int sum = ZERO;
    for (int i = ZERO; i < this.donations.size(); i++) {
      sum += this.donations.get(i).getYearlyAmount(year);
    }
    return sum;
  }

  /**
   * Override equals method to compare with given object
   *
   * @param o given object
   * @return true only if hashcode, class type and all field are the same. False otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonProfit)) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return this.orgName.equals(nonProfit.orgName) && this.donations.equals(nonProfit.donations);
  }

  /**
   * Override hashCode method to generate unique hashcode
   *
   * @return a unique hashcode for current non profit object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.orgName, this.donations);
  }

  /**
   * Override toString method to generate a string representation of this object
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    String res ="NonProfit{" +
        "orgName='" + orgName + '\n' + "Donations: \n";
    for (IDonation donation : this.donations) {
      res += donation.toString();
    }
    return res;
  }
}
