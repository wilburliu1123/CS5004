package problem1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class OwnerTest {
    Owner owner;
    Owner badCase;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Before
    public void setUp() throws Exception {
        owner = new Owner("will", "Liu", "0101234560");
    }

    @Test
    public void constructorTest() {
        exceptionRule.expect(ArithmeticException.class);
        exceptionRule.expectMessage("Invalid phone number length");
        badCase = new Owner("will", "Liu", "0101234");
    }
    @Test
    public void getFirstName() {
        assertEquals("will", owner.getFirstName());
    }

    @Test
    public void setFirstName() {
        owner.setFirstName("WILL");
        assertEquals("WILL", owner.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Liu", owner.getLastName());
    }

    @Test
    public void setLastName() {
        owner.setLastName("Random");
        assertEquals("Random", owner.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("0101234560", owner.getPhoneNumber());
        assertEquals(10, owner.getPhoneNumber().length());
    }

    @Test
    public void setPhoneNumber() {
        owner.setPhoneNumber("1234567890");
        assertEquals("1234567890", owner.getPhoneNumber());
    }


}