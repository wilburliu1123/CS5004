package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BandTest {
  Band band;
  RecordingArtist artist1;
  RecordingArtist artist2;
  RecordingArtist artist3;
  RecordingArtist artist4;
  @Before
  public void setUp() throws Exception {
    band = new Band("Red Hot Chili Peppers");
    artist1 = new RecordingArtist("Anthony", "Kiedis");
    artist2 = new RecordingArtist("John", "Frusciante");
    artist3 = new RecordingArtist("Dave", "Navarro");
    artist4 = new RecordingArtist("Flea", "N");
    band.addMember(artist1);
  }

  @Test
  public void testEquals() {
    Band test = new Band("Red Hot Chili Peppers");
    test.addMember(artist1);
    assertTrue(test.equals(band));
    assertTrue(band.equals(band));
  }
  @Test
  public void testEqualsWithDiffMemberOrName() {
    Band test = new Band("Red Hot Chili Peppers");
    test.addMember(artist1);
    test.addMember(artist2);
    assertFalse(test.equals(band));
    test.setName("random");
    assertFalse(test.equals(band));
  }

  @Test
  public void testEqualsWithDiffClass() {
    Object o = null;
    assertFalse(band.equals(o));
    o = new Object();
    assertFalse(band.equals(o));
  }

  @Test
  public void testHashCode() {
    Band test = new Band("Red Hot Chili Peppers");
    test.addMember(artist1);
    assertNotSame(test.hashCode(), band.hashCode());
  }

  @Test
  public void addMember() {
    band.addMember(artist2);
  }

  @Test
  public void removeMember() {
    band.addMember(artist2);
    band.removeMember(artist2);
    // test remove non-exist member. should not do anything
    band.removeMember(artist4);
  }

  @Test
  public void getName() {
    assertEquals("Red Hot Chili Peppers", band.getName());
  }

  @Test
  public void setName() {
    band.setName("Linkin Park");
    assertEquals("Linkin Park", band.getName());
  }

  @Test
  public void containsMember() {
    Creator test = new Author("Will", "John");
    assertTrue(band.containsMember(artist1));
    assertFalse(band.containsMember(test));
  }



  @Test
  public void testToString() {
    assertEquals("Band{name='Red Hot Chili Peppers', members: \n"
        + "RecordingArtist{firstName='Anthony', lastName='Kiedis'}", band.toString());
  }
}