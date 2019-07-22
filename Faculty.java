/**
 * Faculty class for to hold information for faculty
 */

public class Faculty extends Person {

    private String degree;
    private String dateOfHire;
    private String phoneNumber;
    private String officeNumber;
    private String officeHours;
    private String coursesTeaching;

    /**
     * Constructor for faculty
     *
     */
    public Faculty()
    {

    }

    /**
     * Constructor for faculty
     * @param firstName first name
     * @param lastName last name
     * @param mi middle initial
     */
    public Faculty(String firstName, String lastName, String mi) {
        super(firstName, lastName, mi);
    }

    /**
     * setter for date of hire
     * @param dateOfHire date of hire
     */
    public void setDateOfHire(String dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    /**
     * setter for phone number
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * setter for office number
     * @param officeNumber office number
     */
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    /**
     * setter for office hours
     * @param officeHours office hours
     */
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    /**
     * setter for degree
     * @param degree degree
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * getter for degree
     * @return degree
     */
    public String getDegree() {
        return degree;
    }

    /**
     * getter for date of hire
     * @return date of hire
     */
    public String getDateOfHire() {
        return dateOfHire;
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
     * getter for office hours
     * @return office hours
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * setter for courses teaching
     * @param coursesTeaching courses teaching
     */
    public void setCoursesTeaching(String coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
    }

    /**
     * getter for courses teaching
     * @return teaching
     */
    public String getCoursesTeaching() {
        return coursesTeaching;
    }

}
