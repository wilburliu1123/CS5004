package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Service.Size;

public class ElectricalTest {
  Electrical electrical;
  @Before
  public void setUp() throws Exception {
    electrical = new Electrical("12345 Seattle WA", Size.SMALL, false, 8, 2, true);
  }

  @Test(expected = MaxElectricalWorkerException.class)
  public void constructorTest() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.MEDIUM, false, 8, 5, false);
  }

  @Test
  public void testForZeroEmployee() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.MEDIUM, false, 8, 0, false);
  }

  @Test
  public void testForLargeHouse() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.LARGE, false, 8, 1, true);
  }

  @Test
  public void testForLargeHouseNotComplexWork() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.LARGE, false, 8, 3, false);
  }

  @Test
  public void testForComplexWorkReq() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.LARGE, false, 8, 3, true);
    assertTrue(test.meetComplexWorkRequirement());
  }

  @Test
  public void testForNotMeetComplexWork() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.LARGE, false, 8, 2, false);
  }

  @Test
  public void testForNotMeetComplexWorkMedium() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.MEDIUM, false, 8, 1, true);
  }

  @Test
  public void discount() {
    assertEquals(1.0, electrical.discount(), 0.001);
  }

  @Test
  public void meetComplexWorkRequirement() {
    assertTrue(electrical.meetComplexWorkRequirement());
  }

  @Test
  public void calculatePrice() {
    assertEquals(450.0, electrical.calculatePrice(), 0.001);
  }

  @Test
  public void testHashCode() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.SMALL, false, 8, 2, true);
    assertNotSame(test.hashCode(), electrical.hashCode());
  }

  @Test
  public void testEquals() throws MaxElectricalWorkerException {
    Electrical test = new Electrical("12345 Seattle WA", Size.SMALL, false, 8, 2, true);
    assertTrue(electrical.equals(test));
    assertEquals(test.numberOfLicensedEmployee, electrical.numberOfLicensedEmployee);
    assertEquals(test.isComplexWork, electrical.isComplexWork);
  }
  @Test
  public void testNull() {
    Object o = null;
    assertFalse(electrical.equals(o));
  }
  @Test
  public void testDiffClass() {
    Object o = new Object();
    assertFalse(electrical.equals(o));
  }
  @Test
  public void testEqualReflexive() {
    Object o = new Object();
    assertTrue(electrical.equals(electrical));
  }

  @Test
  public void testToString() {
    assertEquals("ElectricalService{address='12345 Seattle WA', propertySize=SMALL, isMonthly=false, previousServices=8, numberOfLicensedEmployee=2, isComplexWork=true}", electrical.toString());
  }
}