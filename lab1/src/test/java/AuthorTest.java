import jdk.internal.access.JavaLangInvokeAccess;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    private Author author;
    @Before
    public void setUp() throws Exception {
        author = new Author("Wilbur", "Liu", "wilbur@northeastern.edu", "Northeastern University");
    }

    @Test
    public void testGetEmail() {
        assertEquals("wilbur@northeastern.edu", author.getEmail());
    }

    @Test
    public void testGetAddress() {
        assertEquals("Northeastern University", author.getAddress());
    }
}