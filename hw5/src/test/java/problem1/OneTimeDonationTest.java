package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class OneTimeDonationTest {
  OneTimeDonation oneTimeDonation;
  LocalDateTime localDateTime;
  @Before
  public void setUp() throws Exception {
    localDateTime = LocalDateTime.of(2021, 02, 18, 9, 20);
    oneTimeDonation = new OneTimeDonation(localDateTime, 2000);
  }

  @Test
  public void getYearlyAmount() {
    assertEquals(0, oneTimeDonation.getYearlyAmount(2019));
    assertEquals(2000, oneTimeDonation.getYearlyAmount(2021));
  }

  @Test
  public void getCreation() {
    LocalDateTime test = LocalDateTime.of(2021, 02, 18, 9, 20);
    assertEquals(test, oneTimeDonation.getCreation());
  }

  @Test
  public void testSetEndTime() throws ProcessedDateException {
    LocalDateTime test = LocalDateTime.of(2022, 02, 18, 9, 20);
    oneTimeDonation.setEndDate(test);
    assertEquals(2021, oneTimeDonation.getEndDate().getYear());
  }
  @Test
  public void getEndDate() {
    LocalDateTime test = LocalDateTime.of(2021, 02, 18, 9, 20);
    assertEquals(test, oneTimeDonation.getEndDate());
  }

  @Test
  public void testHashCode() {
    LocalDateTime test = LocalDateTime.of(2021, 02, 18, 9, 20);
    OneTimeDonation testSame = new OneTimeDonation(test, 2000);
    assertEquals(testSame.hashCode(), oneTimeDonation.hashCode());
    OneTimeDonation testNotSame = new OneTimeDonation(test, 2100);
    assertFalse(testNotSame.hashCode() == oneTimeDonation.hashCode());
  }

  @Test
  public void testEquals() {
    LocalDateTime test = LocalDateTime.of(2021, 02, 18, 9, 20);
    OneTimeDonation testSame = new OneTimeDonation(test, 2000);
    assertTrue(testSame.equals(oneTimeDonation));
    assertTrue(oneTimeDonation.equals(oneTimeDonation));
  }
  @Test
  public void testEqualsDiffTime() {
    LocalDateTime test = LocalDateTime.of(2020, 02, 18, 9, 20);
    OneTimeDonation testSame = new OneTimeDonation(test, 2000);
    assertFalse(testSame.equals(oneTimeDonation));
  }

  @Test
  public void testEqualsDiffClass() {
    LocalDateTime test = LocalDateTime.of(2021, 02, 18, 9, 20);
    OneTimeDonation testSame = new OneTimeDonation(test, 2000);
    Object o = null;
    assertTrue(testSame.equals(oneTimeDonation));
    assertFalse(oneTimeDonation.equals(o));
    o = new Object();
    assertFalse(oneTimeDonation.equals(o));
  }
  @Test
  public void testEqualsDiffAmount() {
    LocalDateTime test = LocalDateTime.of(2020, 02, 18, 9, 20);
    OneTimeDonation testSame = new OneTimeDonation(test, 2100);
    assertFalse(testSame.equals(oneTimeDonation));
  }
  @Test
  public void testToString() {
    assertEquals("OneTimeDonation{createDate=2021-02-18T09:20, EndDate=2021-02-18T09:20, amount=2000}", oneTimeDonation.toString());
  }
}