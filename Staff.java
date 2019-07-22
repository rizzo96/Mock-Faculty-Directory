/**
 * Staff class for to hold information for staff
 */

public class Staff extends Person {

    private String degree;
    private String password;
    private String phoneNumber;
    private String officeNumber;
    private String email;

    /**
     * Constructor for staff class
     * @param firstName first name
     * @param lastName last name
     * @param mi middle initial
     */

    public Staff(String firstName, String lastName, String mi) {
        super(firstName, lastName, mi);

    }

    /**
     * getter for degree
     * @return
     */
    public String getDegree() {
        return degree;
    }

    /**
     * setter for degree
     * @return degree
     */
    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    /**
     * setter for phone number
     * @return phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * setter for office number
     * @return office number
     */
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }


    /**
     * getter for password
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * getter for phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * getter for office number
     * @return office number
     */
    public String getOfficeNumber() {
        return officeNumber;
    }


    /**
     * setter for password
     * @return password
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter for email
     * @return email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * setter for email
     * @return email
     */
    @Override
    public void setEmail(String email) {
        this.email = email;


    }
}