package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class MonthlyDonationTest {
  MonthlyDonation monthlyDonation;
  MonthlyDonation lastYearMDonation;
  LocalDateTime localDateTime;
  LocalDateTime lastYear;
  @Before
  public void setUp() throws Exception {
    localDateTime = LocalDateTime.of(2021, 02, 18, 9, 00);
    lastYear = LocalDateTime.of(2020, 02, 18, 7, 48, 0);
    monthlyDonation = new MonthlyDonation(localDateTime, 15);
    lastYearMDonation = new MonthlyDonation(lastYear, 20);
  }

  @Test
  public void setCancelDate() throws ProcessedDateException {
    LocalDateTime now = LocalDateTime.now();
    lastYearMDonation.setEndDate(now);
    assertEquals(now, lastYearMDonation.getEndDate());
  }

  @Test(expected = ProcessedDateException.class)
  public void setEarlierCancelDate() throws ProcessedDateException {
    LocalDateTime past = LocalDateTime.of(2019, 02,18,18,0);
    lastYearMDonation.setEndDate(past);
  }


  @Test
  public void getYearlyAmount() throws ProcessedDateException {
    LocalDateTime endDate = LocalDateTime.of(2021, 3, 19, 12,0);
    assertEquals(240, lastYearMDonation.getYearlyAmount(2021));
    lastYearMDonation.setEndDate(endDate);
    assertEquals(220, lastYearMDonation.getYearlyAmount(2020));
    assertEquals(60, lastYearMDonation.getYearlyAmount(2021));
    assertEquals(0, lastYearMDonation.getYearlyAmount(2019));
    assertEquals(165, monthlyDonation.getYearlyAmount(2021));
  }
  @Test
  public void testGetYearlyAmountEndInFuture() throws ProcessedDateException {
    LocalDateTime nextYear = LocalDateTime.of(2022, 2, 18, 18, 0, 0);
    lastYearMDonation.setEndDate(nextYear);
//    System.out.println(lastYearMDonation.getEndDate().getYear());
    assertEquals(240, lastYearMDonation.getYearlyAmount(2021));
  }

  @Test
  public void getCreation() {
    LocalDateTime test = LocalDateTime.of(2020, 2,18,7,48,0);
    assertEquals(test, lastYearMDonation.getCreation());
  }

  @Test
  public void getEndDate() {
    assertEquals(null, lastYearMDonation.getEndDate());
  }

  @Test
  public void testEquals() throws ProcessedDateException {
    LocalDateTime test = LocalDateTime.of(2020, 2,18,7,48,0);
    MonthlyDonation testSame = new MonthlyDonation(test, 20);
    LocalDateTime end = LocalDateTime.of(2021, 12,12, 12,12);
    LocalDateTime diffEnd = LocalDateTime.of(2022, 12,12, 12,12);
    assertTrue(lastYearMDonation.equals(lastYearMDonation));
    assertTrue(testSame.equals(lastYearMDonation));
    testSame.setEndDate(end);
    lastYearMDonation.setEndDate(end);
    assertTrue(testSame.equals(lastYearMDonation));
    lastYearMDonation.setEndDate(diffEnd);
    assertFalse(testSame.equals(lastYearMDonation));
  }
  @Test
  public void testEqualsWithDiffAmount() {
    LocalDateTime test = LocalDateTime.of(2020, 2,18,7,48,0);
    MonthlyDonation testNotSame = new MonthlyDonation(test, 15);
    assertFalse(testNotSame.equals(lastYearMDonation));

  }
  @Test
  public void testEqualsWithDiffTime() throws ProcessedDateException {
    LocalDateTime test = LocalDateTime.of(2019, 2,18,7,48,0);
    LocalDateTime end = LocalDateTime.of(2021, 12,12, 12,12);
    MonthlyDonation testSame = new MonthlyDonation(test, 20);
    assertFalse(testSame.equals(lastYearMDonation));
    testSame.setEndDate(end);
    assertFalse(testSame.equals(lastYearMDonation));
    lastYearMDonation.setEndDate(end);
    assertFalse(testSame.equals(monthlyDonation));
  }
  @Test
  public void testEqualsDiffClassAndNull() {
    Object o = new Object();
    assertFalse(lastYearMDonation.equals(o));
    Object i = null;
    assertFalse(lastYearMDonation.equals(i));
  }

  @Test
  public void testToString() {
    assertEquals("MonthlyDonation{creationDate=2020-02-18T07:48, amount=20, cancelDate=null}", lastYearMDonation.toString());
  }

  @Test
  public void testHashCode() {
    assertNotSame(lastYearMDonation.hashCode(), monthlyDonation.hashCode());
  }
}