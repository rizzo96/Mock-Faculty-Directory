/**
 * Student class for to hold information for Student
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student extends Person { ;
    private String major;
    private String coursesTaken;
    private String listOfSchoolsApplying;
    private String potentialDateOfTransfer;

    /**
     * Constructor for student
     * @param firstName first name
     * @param lastName last name
     * @param mi middle intital
     */
    public Student(String firstName, String lastName, String mi) {
        super(firstName, lastName, mi);

    }

    /**
     * setter for courses taken
     * @param coursesTaken courses taken
     */
    public void setCoursesTaken(String coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    /**
     * setter for list of schools applying
     * @return list of schools applying
     */
    public void setListOfSchoolsApplying(String listOfSchoolsApplying) {
        this.listOfSchoolsApplying = listOfSchoolsApplying;
    }

    /**
     * getting for major
     * @return major
     */
    public String getMajor() {
        return major;
    }


    /**
     * getter for courses taken
     * @return courses taken
     */
    public String getCoursesTaken() {
        return coursesTaken;
    }

    /**
     * getter for list of schools applying
     * @return list of schools applying
     */
    public String getListOfSchoolsApplying() {
        return listOfSchoolsApplying;
    }

    /**
     * getter for potential date of transfer
     * @return potential date of transfer
     */
    public String getPotentialDateOfTransfer() {
        return potentialDateOfTransfer;
    }

    /**
     * setter for potnential date of transfer
     * @param potentialDateOfTransfer potential date of transfer
     */
    public void setPotentialDateOfTransfer(String potentialDateOfTransfer) {
        this.potentialDateOfTransfer = potentialDateOfTransfer;


    }

    /**
     * setter for major
     * @return major
     */
    public void setMajor(String major) {
        this.major = major;
    }
}
