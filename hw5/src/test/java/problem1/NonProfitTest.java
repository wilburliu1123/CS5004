package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {
  NonProfit nonProfit;
  IDonation donation;
  LocalDateTime localDateTime;
  @Before
  public void setUp() throws Exception {
    localDateTime = LocalDateTime.of(2021, 2, 2, 9, 0);
    donation = new OneTimeDonation(localDateTime, 2000);
    nonProfit = new NonProfit("Red Cross");
    nonProfit.addDonation(donation);
  }

  @Test
  public void addDonation() {
    IDonation monthlyDonation = new MonthlyDonation(localDateTime, 200);
    nonProfit.addDonation(monthlyDonation);
  }

  @Test
  public void getTotalDonationsForYear() throws ProcessedDateException {
    IDonation monthlyDonation = new MonthlyDonation(localDateTime, 200);
    assertEquals(2000, nonProfit.getTotalDonationsForYear(2021));
    nonProfit.addDonation(monthlyDonation);
    assertEquals(4200, nonProfit.getTotalDonationsForYear(2021));
    LocalDateTime endDate = LocalDateTime.of(2021, 5, 2, 9, 0);
    monthlyDonation.setEndDate(endDate);
    assertEquals(2800, nonProfit.getTotalDonationsForYear(2021));
  }

  @Test
  public void testEquals() {
    NonProfit redCross = new NonProfit("Red Cross");
    redCross.addDonation(donation);
    assertEquals(redCross, nonProfit);
    assertEquals(nonProfit, nonProfit);
    IDonation monthlyDonation = new MonthlyDonation(localDateTime, 200);
    nonProfit.addDonation(monthlyDonation);
    assertFalse(nonProfit.equals(redCross));

  }
  @Test
  public void testDiffName() {
    NonProfit redCross = new NonProfit("Red Cross");
    redCross.addDonation(donation);
    NonProfit test = new NonProfit("Red");
    test.addDonation(donation);
    assertFalse(test.equals(redCross));
  }
  @Test
  public void testEqualsDiffClass() {
    Object o = null;
    assertFalse(nonProfit.equals(o));
    o = new Object();
    assertFalse(nonProfit.equals(o));
  }

  @Test
  public void testHashCode() {
    NonProfit redCross = new NonProfit("Red Cross");
    assertNotSame(redCross.hashCode(), nonProfit.hashCode());
    redCross.addDonation(donation);
    assertNotSame(redCross.hashCode(), nonProfit.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("NonProfit{orgName='Red Cross\n"
        + "Donations: \n"
        + "OneTimeDonation{createDate=2021-02-02T09:00, EndDate=2021-02-02T09:00, amount=2000}", nonProfit.toString());
  }
}