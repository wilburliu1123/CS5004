package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    private Vehicle vehicle;
    private Owner owner;
    @Before
    public void setUp() throws Exception {
        owner = new Owner("will", "Liu", "0000001000");
        vehicle = new Vehicle(0100, "WA1100", owner);
    }

    @Test
    public void getVIN() {
        assertEquals(0100, (int) vehicle.getVIN());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("WA1100", vehicle.getLicensePlate());
    }

    @Test
    public void setVIN() {
        vehicle.setVIN(0000);
        assertEquals(0000, (int) vehicle.getVIN());
    }

    @Test
    public void setLicensePlate() {
        vehicle.setLicensePlate("WA0000");
        assertEquals("WA0000", vehicle.getLicensePlate());
    }
}