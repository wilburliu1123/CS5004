package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class PledgeTest {
  Pledge pledge;
  LocalDateTime localDateTime;
  @Before
  public void setUp() throws Exception {
    localDateTime = LocalDateTime.of(2021, 2, 18, 9, 0);
    pledge = new Pledge(localDateTime, 15000);
  }

  @Test
  public void testConstructor() throws ProcessedDateException {
    LocalDateTime future = LocalDateTime.of(2050, 01, 1, 12, 0);
    Pledge test = new Pledge(localDateTime, future, 15000);
  }

  @Test(expected = ProcessedDateException.class)
  public void testConstructorWithException() throws ProcessedDateException {
    LocalDateTime future = LocalDateTime.of(2019, 01, 1, 12, 0);
    Pledge test = new Pledge(localDateTime, future, 15000);
  }

  @Test
  public void setProcessedDate() throws ProcessedDateException {
    LocalDateTime future = LocalDateTime.of(2050, 01, 1, 12, 0);
    pledge.setEndDate(future);
  }
  @Test(expected = ProcessedDateException.class)
  public void testInvalidProcessedDate() throws ProcessedDateException {
    LocalDateTime future = LocalDateTime.of(2020, 01, 1, 12, 0);
    pledge.setEndDate(future);
  }

  @Test
  public void removeProcessingDate() throws ProcessedDateException {
    LocalDateTime future = LocalDateTime.of(2050, 01, 1, 12, 0);
    pledge.setEndDate(future);
    pledge.removeProcessingDate();
    assertEquals(null, pledge.getEndDate());
  }

  @Test
  public void getYearlyAmount() throws ProcessedDateException {
    assertEquals(0, pledge.getYearlyAmount(2021));
    LocalDateTime future = LocalDateTime.of(2050, 01, 1, 12, 0);
    pledge.setEndDate(future);
    assertEquals(15000, pledge.getYearlyAmount(2050));
    assertEquals(0, pledge.getYearlyAmount(2051));
  }

  @Test
  public void getCreation() {
    LocalDateTime test = LocalDateTime.of(2021, 2, 18, 9, 0);
    assertEquals(test, pledge.getCreation());
  }

  @Test
  public void getEndDate() throws ProcessedDateException {
    assertEquals(null, pledge.getEndDate());
    LocalDateTime future = LocalDateTime.of(2050, 01, 1, 12, 0);
    pledge.setEndDate(future);
    assertEquals(future, pledge.getEndDate());
  }

  @Test
  public void testEquals() throws ProcessedDateException {
    Pledge test = new Pledge(localDateTime, 15000);
    assertTrue(pledge.equals(pledge));
    assertTrue(test.equals(pledge));
    LocalDateTime future = LocalDateTime.of(2050, 01, 1, 12, 0);
    test.setEndDate(future);
    assertFalse(test.equals(pledge));
  }
  @Test
  public void testEqualsDiffAmount() {
    Pledge test = new Pledge(localDateTime, 11000);
    assertFalse(test.equals(pledge));
  }
  @Test
  public void testEqualsDiffDate() {
    LocalDateTime diffDate = LocalDateTime.of(2012, 1, 1, 12, 0);
    Pledge test = new Pledge(diffDate, 15000);
    assertFalse(test.equals(pledge));
  }
  @Test
  public void testEqualsDiffClass() {
    Object o = null;
    assertFalse(pledge.equals(o));
    o = new Object();
    assertFalse(pledge.equals(o));
  }

  @Test
  public void testHashCode() {
    Pledge test = new Pledge(localDateTime, 15000);
    assertNotSame(test.hashCode(), pledge.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Pledge{creationDate=2021-02-18T09:00, processedDate=null, amount=15000}", pledge.toString());
  }
}