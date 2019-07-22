/**
 * Person class for to hold information for person
 */

public class Person {

    private String firstName;
    private String lastName;
    private String mi;
    private String email;
    private String id;
    private String username, password;

    /**
     * setter for username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * setter for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * constructor
     */
    public Person()
    {
        firstName = "";
        lastName = "";
        mi = " ";
    }

    /**
     * overload constructor
     * @param firstName first name
     * @param lastName last name
     * @param mi middle intial
     */
    public Person(String firstName, String lastName, String mi)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mi = mi;
    }

    /**
     * setter for middle intial
     * @param mi middle initial
     */
    public void setMi(String mi) {
        this.mi = mi;
    }

    /**
     * setter for email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setter for id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter for first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getter for last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getter for middle initial
     * @return middle initial
     */
    public String getMi() {
        return mi;
    }

    /**
     * getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getter for id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * getter for username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for first name
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * setter for last name
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

