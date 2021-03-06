package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MusicTest {
  Music music;
  Music music2;
  RecordingArtist artist;
  Band band;
  RecordingArtist artist1;
  RecordingArtist artist2;
  RecordingArtist artist3;
  RecordingArtist artist4;
  @Before
  public void setUp() throws Exception {
    artist = new RecordingArtist("Tayler", "Swift");
    music = new Music("music1", 2001, artist);
    band = new Band("Red Hot Chili Peppers");
    artist1 = new RecordingArtist("Anthony", "Kiedis");
    artist2 = new RecordingArtist("John", "Frusciante");
    artist3 = new RecordingArtist("Dave", "Navarro");
    artist4 = new RecordingArtist("Flea", "N");
    band.addMember(artist1);
    music2 = new Music("music2", 2001, band);
  }

  @Test
  public void getCreator() {
    Creator test = new RecordingArtist("Tayler", "Swift");
    assertEquals(test, music.getCreator());
    Band testBand = new Band("Red Hot Chili Peppers");
    testBand.addMember(artist1);
    assertEquals(testBand, music2.getCreator());
  }

  @Test
  public void getTitle() {
    assertEquals("music1", music.getTitle());
  }

  @Test
  public void getYearReleased() {
    assertEquals(2001, music.getYearReleased());
  }

  @Test
  public void containsCreator() {
    Creator test = new RecordingArtist("Tayler", "Swift");
    assertTrue(music.containsCreator(test));
    Creator testFalse = new Author("Bob", "Wish");
    assertFalse(music.containsCreator(testFalse));
    Creator testBandContains = new RecordingArtist("Anthony", "Kiedis");
    assertTrue(music2.containsCreator(testBandContains));
  }

  @Test
  public void testEquals() {
    Music test = new Music("music1", 2001, artist);
    Band testBand = new Band("Red Hot Chili Peppers");
    testBand.addMember(artist1);
    Music testMusic = new Music("music2", 2001, testBand);
    assertTrue(music2.equals(testMusic));
    assertTrue(music.equals(test));
    assertTrue(music.equals(music));
  }

  @Test
  public void testMusicWithDifferentBand() {
    Band testBand = new Band("Red Hot Chili Peppers");
    Music testMusic = new Music("music2", 2001, testBand);
    assertFalse(music2.equals(testMusic));
    testBand.addMember(artist2);
    assertFalse(music2.equals(testMusic));
    testBand.removeMember(artist2);
    testBand.addMember(artist1);
    Music testDiffName = new Music("music??", 2001, testBand);
    assertFalse(music2.equals(testDiffName));
    Music testDiffYear = new Music("music??", 2003, testBand);
    assertFalse(music2.equals(testDiffYear));
  }
  @Test
  public void testEqualsWithDiffArtistOrYearOrName() {
    Music test = new Music("music2", 2001, artist);
    assertFalse(music.equals(test));
    Music test1 = new Music("music1", 2000, artist);
    assertFalse(music.equals(test1));
    RecordingArtist diffArtist = new RecordingArtist("Bob", "Wish");
    Music test2 = new Music("music1", 2001, diffArtist);
    assertFalse(music.equals(test));
  }

  @Test
  public void testEqualsWithDiffClass() {
    Object o = null;
    assertFalse(music.equals(o));
    o = new Object();
    assertFalse(music.equals(o));
  }
  @Test
  public void testHashCode() {
    Music test = new Music("music1", 2001, artist);
    assertNotSame(test.hashCode(), music.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Music{title='music1', recordingArtist=RecordingArtist{firstName='Tayler', lastName='Swift'}, band=null, year=2001}", music.toString());
  }
}