package problem1;

/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number (VIN), and corresponding license plate.
 */
public class Vehicle {
    private Integer vin;
    private String licensePlate;
    private Owner owner;
    /**
     * Constructor that creates a new vehicle object with the specified VIN and * license plate.
     *
     * @param vin          - VIN of the new Vehicle object.
     * @param licensePlate - license plate of the new Vehicle.
     * @param owner - owner of the new Vehicle.
     */
    public Vehicle(Integer vin, String licensePlate, Owner owner) {
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    /**
     * Returns the VIN of the Vehicle.
     *
     * @return the VIN of the Vehicle.
     */
    public Integer getVIN() {
        return this.vin;
    }

    /**
     * Returns the licensePlate of the vehicle
     *
     * @return the licensePlate of the vehicle
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets the VIN of the Vehicle.
     * @param vin was modified in this method.
     */
    public void setVIN(Integer vin) {
        this.vin = vin;
    }

    /**
     * Sets the licensePlate of the Vehicle.
     * @param licensePlate was modified in this method.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}