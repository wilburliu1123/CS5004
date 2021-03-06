package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {

  Catalog catalog;
  Band band;
  RecordingArtist artist1;
  RecordingArtist artist2;
  RecordingArtist artist3;
  RecordingArtist edSheeran;
  RecordingArtist taylor;
  Author author;
  Item aBriefHisoryOfTime;
  Item loveStory;
  Item perfect;
  Item darkNecessities;
  Item briefAnswerstotheBigQuestions;

  @Before
  public void setUp() throws Exception {
    catalog = new Catalog();
    author = new Author("Steve", "Hawkins");
    band = new Band("Red Hot Chili Peppers");
    artist1 = new RecordingArtist("Anthony", "Kiedis");
    artist2 = new RecordingArtist("John", "Frusciante");
    artist3 = new RecordingArtist("Dave", "Navarro");
    edSheeran = new RecordingArtist("Ed", "Sheeran");
    taylor = new RecordingArtist("Taylor", "Swift");
    band.addMember(artist1);
    aBriefHisoryOfTime = new Book(author, 1991, "A Brief History of Time");
    briefAnswerstotheBigQuestions = new Book(author, 2018, "Brief Answers to the Big Questions");
    loveStory = new Music("Love Story", 2010, taylor);
    perfect = new Music("Perfect", 2017, edSheeran);
    darkNecessities = new Music("Dark Necessities", 2010, band);
    catalog.addItem(aBriefHisoryOfTime);
    catalog.addItem(briefAnswerstotheBigQuestions);
    catalog.addItem(loveStory);
    catalog.addItem(perfect);
    catalog.addItem(darkNecessities);
  }

  @Test
  public void testConstructor() {
    List<Item> items = new ArrayList<>();
    items.add(aBriefHisoryOfTime);
    items.add(briefAnswerstotheBigQuestions);
    Catalog test = new Catalog(items);
  }

  @Test
  public void addItem() {
    Item newItem = new Book(author, 2002, "On the Shoulders of Giants");
    catalog.addItem(newItem);
    List<Item> items = new ArrayList<>();
    items.add(newItem);
    assertEquals(items, catalog.search("Giants"));
    assertEquals(items, catalog.search("giants")); //test for ignoring cases
    assertEquals(items, catalog.search("gian"));
  }

  @Test
  public void removeItem() {
    List<Item> items = new ArrayList<>();
    items.add(briefAnswerstotheBigQuestions);
    catalog.removeItem(aBriefHisoryOfTime);
    assertEquals(items, catalog.search(author));
  }

  @Test
  public void search() {
    List<Item> items = new ArrayList<>();
    items.add(aBriefHisoryOfTime);
    items.add(briefAnswerstotheBigQuestions);
    assertEquals(items, catalog.search(author));
  }

  @Test
  public void testSearchKeyWord() {
    List<Item> items = new ArrayList<>();
    items.add(aBriefHisoryOfTime);
    items.add(briefAnswerstotheBigQuestions);
    assertEquals(items, catalog.search("brief"));
    items = new ArrayList<>();
    items.add(aBriefHisoryOfTime);
    items.add(briefAnswerstotheBigQuestions);
    items.add(loveStory);
    items.add(perfect);
    items.add(darkNecessities);
    assertEquals(items, catalog.search("r"));
  }

  @Test
  public void testSearchArtist() {
    RecordingArtist test = new RecordingArtist("Taylor", "Swift");
    List<Item> items = new ArrayList<>();
    items.add(loveStory);
    assertEquals(items, catalog.search(test));
  }

  @Test
  public void testSearchArtistWithinBand() {
    RecordingArtist test = new RecordingArtist("Anthony", "Kiedis");
    List<Item> items = new ArrayList<>();
    items.add(darkNecessities);
    assertEquals(items, catalog.search(test));
  }

  @Test
  public void testEquals() {
    Catalog test = new Catalog();
    test.addItem(aBriefHisoryOfTime);
    test.addItem(briefAnswerstotheBigQuestions);
    test.addItem(loveStory);
    test.addItem(perfect);
    test.addItem(darkNecessities);
    assertTrue(catalog.equals(test));
    assertTrue(catalog.equals(catalog));
  }

  @Test
  public void testDiffItems() {
    Catalog test = new Catalog();
    test.addItem(aBriefHisoryOfTime);
    assertFalse(catalog.equals(test));
  }

  @Test
  public void testDiffClass() {
    Object o = null;
    assertFalse(catalog.equals(o));
    o = new Object();
    assertFalse(catalog.equals(o));
  }

  @Test
  public void testHash() {
    Catalog test = new Catalog();
    test.addItem(aBriefHisoryOfTime);
    test.addItem(briefAnswerstotheBigQuestions);
    test.addItem(loveStory);
    test.addItem(perfect);
    test.addItem(darkNecessities);
    assertNotSame(catalog.hashCode(), test.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(
        "Catalog{items=[Book{author=Author{firstName='Steve', lastName='Hawkins'}, name='A Brief History of Time', year=1991}, Book{author=Author{firstName='Steve', lastName='Hawkins'}, name='Brief Answers to the Big Questions', year=2018}, Music{title='Love Story', recordingArtist=RecordingArtist{firstName='Taylor', lastName='Swift'}, band=null, year=2010}, Music{title='Perfect', recordingArtist=RecordingArtist{firstName='Ed', lastName='Sheeran'}, band=null, year=2017}, Music{title='Dark Necessities', recordingArtist=null, band=Band{name='Red Hot Chili Peppers', members: \n"
            + "RecordingArtist{firstName='Anthony', lastName='Kiedis'}, year=2010}]}",
        catalog.toString());
  }

}