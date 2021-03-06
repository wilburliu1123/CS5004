import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;
    @Before
    public void setUp() throws Exception {
        person = new Person("Will", "Liu");
    }

    @Test
    public void getFirstName() {
        assertEquals("Will", person.getFirstName());
    }

    @Test
    public void setFirstName() {
        person.setFirstName("Wilbur");
        assertEquals("Wilbur", person.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Liu", person.getLastName());
    }

    @Test
    public void setLastName() {
        person.setLastName("Random");
        assertEquals("Random", person.getLastName());
    }
}