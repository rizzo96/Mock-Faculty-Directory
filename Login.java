/**
 * login page
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login extends JFrame {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel usernamePanel = new JPanel();
    private ArrayList<String> loginInfo;
    private JRadioButton faculty;
    private JRadioButton student;
    private JRadioButton staff;
    private ButtonGroup group;
    private String temp, temp1, temp2;
    private String[] tempp = new String[10];
    private String[] tempp1 = new String[10];
    private String[] tempp2 = new String[10];
    private Color myBlue = new Color(95, 186, 235);
    public JButton guest;


    /**
     * constructor for login
      */
    public Login() {

        setTitle("Computer Science Department");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents();
        setResizable(false);
        setVisible(true);


    }

    /**
     * creates components
     */
    public void createComponents() {

        createLabels();
        createTextFields();
        createButtons();

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        usernamePanel.add(passwordLabel);
        usernamePanel.add(passwordField);
        usernamePanel.add(loginButton);
        usernamePanel.add(staff);
        usernamePanel.add(student);
        usernamePanel.add(faculty);
        usernamePanel.add(guest);

        usernamePanel.setBackground(myBlue);

        add(usernamePanel);
    }

    /**
     * creates labels
     */
    public void createLabels() {
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
    }

    /**
     * creates text fields
     */
    public void createTextFields() {
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
    }

    /**
     * create buttons
     */
    public void createButtons() {
        ActionListener listener = new ConvertListener();
        loginButton = new JButton("Login");
        guest = new JButton("Guest Login");

        ActionListener guestlistener = new GuestLogin();

        guest.addActionListener(guestlistener);

        loginButton.addActionListener(listener);

        faculty = new JRadioButton("faculty");
        student = new JRadioButton("student");
        staff = new JRadioButton("staff");

        group = new ButtonGroup();
        group.add(student);
        group.add(faculty);
        group.add(staff);
    }

    /**
     * Creates array for faculty info
     * @throws FileNotFoundException
     */
    public void makeArrayFaculty() throws FileNotFoundException {
        File inputFile = new File("Faculty.txt");
        Scanner in = new Scanner(inputFile);

        String username;

        loginInfo = new ArrayList<>();

        while (in.hasNext()) {
            username = in.nextLine();
            loginInfo.add(username);
        }

    }

    /**
     * creates array for student information
     * @throws FileNotFoundException
     */
    public void makeArrayStudent() throws FileNotFoundException {
        File inputFile = new File("Students.txt");
        Scanner in = new Scanner(inputFile);

        String username;

        loginInfo = new ArrayList<>();

        while (in.hasNext()) {
            username = in.nextLine();

            loginInfo.add(username);
        }
    }

    /**
     * creates array for staff
     * @throws FileNotFoundException
     */
    public void makeArrayStaff() throws FileNotFoundException {
        File inputFile = new File("Staff.txt");
        Scanner in = new Scanner(inputFile);

        String username;

        loginInfo = new ArrayList<>();

        while (in.hasNext()) {

            username = in.nextLine();
            loginInfo.add(username);

        }
    }

    /**
     * creates array for admin
     * @throws FileNotFoundException
     */
    public void makeArrayAdmin() throws FileNotFoundException {
        File inputFile = new File("Faculty.txt");
        Scanner in = new Scanner(inputFile);

        String username;

        loginInfo = new ArrayList<>();

        while (in.hasNext()) {
            username = in.next();
            loginInfo.add(username);
        }
        in.close();
    }

    /**
     * login button action listener
     */
    class ConvertListener implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            if (student.isSelected()) //if student is selected
                {

                try {
                    makeArrayStudent();
                } catch (FileNotFoundException exception) {
                    System.out.println("Could not open input file");
                }

                String getUsername = usernameField.getText();
                String getPassword = passwordField.getText();
                getUsername = getUsername.toLowerCase();

                if (loginInfo.contains(getUsername)) {
                    int passwordLocation = loginInfo.indexOf(getUsername) + 1;

                    if (loginInfo.get(passwordLocation).equals(getPassword)) {
                        setVisible(false);

                        String firstName = loginInfo.get(passwordLocation + 1);
                        String lastName = loginInfo.get(passwordLocation + 2);
                        String mi = loginInfo.get(passwordLocation + 3);
                        String id = loginInfo.get(passwordLocation - 2);

                        Student student = new Student(firstName, lastName, mi);

                        try {
                            File inputFile = new File("Students.txt");
                            Scanner sc = new Scanner(inputFile);

                            String newid = sc.nextLine();

                            while (!newid.equals(id)) {
                                newid = sc.nextLine();
                            }
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();


                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            student.setEmail(tempp[1]);
                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            student.setMajor(tempp[1]);
                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            student.setCoursesTaken(tempp[1]);
                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            student.setListOfSchoolsApplying(tempp[1]);
                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            student.setPotentialDateOfTransfer(tempp[1]);

                            sc.close();
                            new SecondFrame(student);
                        } catch (FileNotFoundException exception) {
                            System.out.println("Could not open input file");
                        }
                    }
                }
            }

            if (staff.isSelected()) // if staff is selected
            {


                try {
                    makeArrayStaff();
                } catch (FileNotFoundException exception) {
                    System.out.println("Could not open input file");
                }

                String getUsername = usernameField.getText();
                String getPassword = passwordField.getText();
                getUsername = getUsername.toLowerCase();

                if (loginInfo.contains(getUsername)) {
                    int passwordLocation = loginInfo.indexOf(getUsername) + 1;

                    if (loginInfo.get(passwordLocation).equals(getPassword)) {
                        setVisible(false);

                        String firstName = loginInfo.get(passwordLocation + 1);
                        String lastName = loginInfo.get(passwordLocation + 2);
                        String mi = loginInfo.get(passwordLocation + 3);
                        String id = loginInfo.get(passwordLocation - 3);
                        String isAdmin = loginInfo.get(passwordLocation - 2);
                        Staff staff = new Staff(firstName, lastName, mi);


                        try {
                            File inputFile = new File("Staff.txt");
                            Scanner sc = new Scanner(inputFile);

                            String newid = sc.nextLine();

                            while (!newid.equals(id)) {
                                newid = sc.nextLine();
                            }
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();
                            sc.nextLine();


                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            staff.setEmail(tempp[1]);
                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            staff.setPhoneNumber(tempp[1]);
                            temp = sc.nextLine();
                            tempp = temp.split(":");
                            staff.setOfficeNumber(tempp[1]);

                            sc.close();

                            if(isAdmin.equals("admin"))
                            {
                                new AdminPageStaff(staff,loginInfo);
                                return;
                            }
                            new SecondFrameStaff(staff,loginInfo);
                        } catch (FileNotFoundException exception) {
                            System.out.println("Could not open input file");
                        }
                    }
                }
            }

            if (faculty.isSelected()) // if faculty is selected
                 {

                        try {
                            makeArrayFaculty();
                        } catch (FileNotFoundException exception) {
                            System.out.println("Could not open input file");
                        }

                        String getUsername = usernameField.getText();
                        String getPassword = passwordField.getText();
                        getUsername = getUsername.toLowerCase();


                        if (loginInfo.contains(getUsername)) {
                            int passwordLocation = loginInfo.indexOf(getUsername) + 1;

                            if (loginInfo.get(passwordLocation).equals(getPassword)) {
                                setVisible(false);

                                String firstName = loginInfo.get(passwordLocation + 1);
                                String lastName = loginInfo.get(passwordLocation + 2);
                                String mi = loginInfo.get(passwordLocation + 3);
                                String id = loginInfo.get(passwordLocation - 3);
                                String isAdmin = loginInfo.get(passwordLocation - 2);

                                Faculty faculty = new Faculty(firstName, lastName, mi);



                                try {
                                    File inputFile = new File("Faculty.txt");
                                    Scanner sc = new Scanner(inputFile);

                                    String newid = sc.nextLine();

                                    while (!newid.equals(id)) {
                                        newid = sc.nextLine();
                                    }

                                    sc.nextLine();
                                    sc.nextLine();
                                    sc.nextLine();
                                    sc.nextLine();
                                    sc.nextLine();
                                    sc.nextLine();

                                    faculty.setId(newid);
                                    temp = sc.nextLine();
                                    tempp = temp.split(":");
                                    faculty.setEmail(tempp[1]);
                                    temp = sc.nextLine();
                                    tempp = temp.split(":");
                                    faculty.setDegree(tempp[1]);
                                    temp = sc.nextLine();
                                    tempp = temp.split(":");
                                    faculty.setPhoneNumber(tempp[1]);
                                    temp = sc.nextLine();
                                    tempp = temp.split(":");
                                    faculty.setOfficeNumber(tempp[1]);
                                    temp = sc.nextLine();
                                    tempp = temp.split(":");
                                    faculty.setOfficeHours(tempp[1]);
                                    temp = sc.nextLine();
                                    tempp = temp.split(":");
                                    faculty.setDateOfHire(tempp[1]);
                                    temp = sc.nextLine();
                                    tempp = temp.split(":");
                                    faculty.setCoursesTeaching(tempp[1]);

                                    sc.close();

                                    if(isAdmin.equals("admin"))
                                    {
                                        new AdminPage(faculty,loginInfo);
                                        return;
                                    }
                                    new SecondFrameFaculty(faculty, loginInfo);

                                } catch (FileNotFoundException exception) {
                                    System.out.println("Could not open input file");
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Login failed!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Login failed!",
                                "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }

    /**
     * action listener for guest login
     */
    class GuestLogin implements ActionListener {


        public void actionPerformed(ActionEvent action) {

            setVisible(false);
            new SecondFrame();
        }


        }
    }


