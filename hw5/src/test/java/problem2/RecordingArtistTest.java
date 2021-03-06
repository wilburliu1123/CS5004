package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {
   RecordingArtist artist;
  @Before
  public void setUp() throws Exception {
    artist = new RecordingArtist("Taylor", "Swift");
  }

  @Test
  public void testEquals() {
    RecordingArtist test = new RecordingArtist("Taylor", "Swift");
    assertTrue(test.equals(artist));
    assertTrue(artist.equals(artist));
  }

  @Test
  public void testEqualsDiffName() {
    RecordingArtist test = new RecordingArtist("Taylor1", "Swift");
    assertFalse(test.equals(artist));
    RecordingArtist test1 = new RecordingArtist("Taylor", "Swift1");
    assertFalse(test1.equals(artist));
  }

  @Test
  public void testHashCode() {
    RecordingArtist test = new RecordingArtist("Taylor", "Swift");
    assertNotSame(test.hashCode(), artist.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("RecordingArtist{firstName='Taylor', lastName='Swift'}", artist.toString());
  }
}