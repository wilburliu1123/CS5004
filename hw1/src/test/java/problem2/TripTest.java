package problem2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TripTest {
    private Trip trip;
    private Time startTime;
    private Time endTime;
    @Before
    public void setUp() throws Exception {
        startTime = new Time(10, 0, 0);
        endTime = new Time(18, 20, 20);
        trip = new Trip("Seattle, WA", "New york, NY", startTime, endTime);
    }

    @Test
    public void getStartLocation() {
        assertEquals("Seattle, WA", trip.getStartLocation());
    }

    @Test
    public void setStartLocation() {
        trip.setStartLocation("San Francisco");
        assertEquals("San Francisco", trip.getStartLocation());
        assertNotEquals("san francisco", trip.getStartLocation());
    }

    @Test
    public void getEndLocation() {
        assertEquals("New york, NY", trip.getEndLocation());
    }

    @Test
    public void setEndLocation() {
        trip.setEndLocation("Chicago");
        assertEquals("Chicago", trip.getEndLocation());
    }

    @Test
    public void getStartTime() throws Exception {
        Time test = new Time(10, 0, 0);
        assertEquals(test, trip.getStartTime());
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void setStartTime() throws Exception {
        Time test = new Time(10, 32, 32);
        trip.setStartTime(10, 32, 32);
        assertEquals(test, trip.getStartTime());
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Wrong hour input, hour needs to between 0 and 23");
        trip.setStartTime(25, 25,25); //Exception will be thrown(because hour is greater than 23)

    }

    @Test
    public void getEndTime() throws Exception {
        Time test = new Time(18, 20, 20);
        assertEquals(test, trip.getEndTime());
    }
    @Rule
    public ExpectedException exceptionRule1 = ExpectedException.none();
    @Test
    public void setEndTime() throws Exception {
        trip.setEndTime(23, 23, 0);
        Time test = new Time(23, 23 ,0);
        assertEquals(test, trip.getEndTime());
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Wrong minutes input, minutes needs to between 0 and 59");
        trip.setEndTime(23, 61, 0);
    }
    @Test
    public void getDuration() throws Exception {
        Time test = new Time(8, 20, 20);
        assertEquals(test, trip.getDuration());
        trip.setStartTime(10, 59, 59);
        trip.setEndTime(11, 0, 0);
        test = new Time(0, 0, 1);
        assertEquals(test, trip.getDuration());
        trip.setEndTime(0, 0, 0);
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("End time is earlier than start Time!");
        trip.getDuration();
    }
}