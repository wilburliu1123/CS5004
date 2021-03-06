package problem1;
/**
 * Owner is a simple object that has a first name, last name, and phone number
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    /**
     * Constructor that creates a new Owner object with the firstName, lastName and phoneNumber.
     *
     * @param firstName - first name of this owner.
     * @param lastName - last name of this owner.
     * @param phoneNumber - phoneNumber of this person.
     */
    public Owner(String firstName, String lastName, String phoneNumber) {
        if (phoneNumber.length() != 10) {
            throw new ArithmeticException("Invalid phone number length");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    /**
     * return first name of this owner
     * @return the first name of this owner.
     * */
    public String getFirstName() {
        return firstName;
    }
    /**
     * change current first name of this owner object.
     * @param firstName was modified in this method.
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * return last name of this owner
     * @return the last name of this owner.
     * */
    public String getLastName() {
        return lastName;
    }
    /**
     * change current last name of this owner object.
     * @param lastName was modified in this method.
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * return phone number of this owner
     * @return the phone number of this owner.
     * */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * change current phone number of this owner object.
     * @param phoneNumber was modified in this method.
     * */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
