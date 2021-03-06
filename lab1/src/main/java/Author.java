/**
 * Represents an Author with their details--name, email and physical address *
 * @author therapon
 *
 */
public class Author extends Person {
    private String name;
    private String email;
    private String address;
    /**
     * Creates a new author given the author's name, email and address as strings. *
     * @param firstName and lastName is inhereted from the Person class
     * @param email the author's email address
     * @param address the authors physical address
     * */
    public Author(String firstName, String lastName, String email, String address) {
        super(firstName, lastName);
        this.name = firstName + " " + lastName;
        this.email = email;
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * @return the address
     * */
    public String getAddress() {
        return this.address;
    }
}