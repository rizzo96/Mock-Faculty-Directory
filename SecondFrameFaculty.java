/**
 * Faculty page
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondFrameFaculty extends JFrame{

    private JPanel panel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JLabel firstName, lastName, mi, dateOfHire,phoneNumber, officeNumber,officeHours,degree, coursesTeaching, email;
    private JTextField firstNameText, lastNameText, miText, phoneNumberText, officeNumberText, degreeText, officeHoursText, emailText;
    private JButton button, back;
    private Faculty faculty;
    private Color myBlue = new Color(95, 186, 235);
    private String checker;
    private ArrayList<Faculty> array = new ArrayList<>();
    private ArrayList<String> loginInfo;


    /**
     * constructor for faculty
     * @param faculty faculty object
     * @param loginInfo login info array
     * @throws FileNotFoundException
     */
    public SecondFrameFaculty(Faculty faculty, ArrayList<String> loginInfo) throws FileNotFoundException {

        setTitle("Faculty");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.faculty = faculty;
        this.loginInfo = loginInfo;
        makeArray();
        createComponents();
        setResizable(false);
        setVisible(true);
    }

    /**
     * creates array for faculty objects
     * @throws FileNotFoundException
     */
    public void makeArray() throws FileNotFoundException
    {
        File inputFile = new File("Faculty.txt");
        Scanner in = new Scanner(inputFile);

        while(!in.hasNextLine())
        {
           Faculty f = new Faculty();

           checker = in.nextLine();

           while(!checker.equals("*endfaculty*"))
           {
               f.setId(checker);
               f.setUsername(in.nextLine());
               f.setPassword(in.nextLine());
               f.setFirstName(in.nextLine());
               f.setLastName(in.nextLine());
               f.setMi(in.nextLine());
               f.setEmail(in.nextLine());
               f.setDegree(in.nextLine());
               f.setPhoneNumber(in.nextLine());
               f.setOfficeNumber(in.nextLine());
               f.setOfficeHours(in.nextLine());
               f.setDateOfHire(in.nextLine());
               f.setCoursesTeaching(in.nextLine());
               array.add(f);
               checker = in.nextLine();

           }
        }
    }

    /**
     * creates components
     */
    public void createComponents() {

        createLabels();
        createTextFields();
        createButtons();

        panel.setLayout(new GridLayout(9,2));
        panel.add(firstName);
        panel.add(firstNameText);
        panel.add(lastName);
        panel.add(lastNameText);
        panel.add(mi);
        panel.add(miText);
        panel.add(phoneNumber);
        panel.add(phoneNumberText);
        panel.add(officeNumber);
        panel.add(officeNumberText);
        panel.add(officeHours);
        panel.add(officeHoursText);
        panel.add(email);
        panel.add(emailText);
        panel.add(dateOfHire);
        panel.add(coursesTeaching);
        panel.add(button);
        bottomPanel.add(back);

        panel.setBackground(myBlue);

        add(panel);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    /**
     * creates labels
     */
    public void createLabels()
    {
        firstName = new JLabel("First Name: "+faculty.getFirstName());
        lastName = new JLabel("Last Name: "+faculty.getLastName());
        mi = new JLabel("Middle Initial: "+faculty.getMi());
        dateOfHire = new JLabel("Date Of Hire: "+faculty.getDateOfHire());
        phoneNumber = new JLabel("Phone number: "+faculty.getPhoneNumber());
        officeNumber = new JLabel("Office Number: "+faculty.getOfficeNumber());
        officeHours = new JLabel("Office Hours: "+faculty.getOfficeHours());
        coursesTeaching = new JLabel("Courses teaching: "+faculty.getCoursesTeaching());
        email = new JLabel("Email: "+faculty.getEmail());


    }

    /**
     * creates text fields
     */
    public void createTextFields() {
        firstNameText = new JTextField(10);
        lastNameText = new JTextField(10);
        miText = new JTextField(2);
        phoneNumberText= new JTextField(10);
        officeNumberText = new JTextField(10);
        degreeText= new JTextField(10);
        officeHoursText= new JTextField(10);
        emailText = new JTextField(10);


    }

    /**
     * creates buttons
     */
    public void createButtons() {

        ActionListener listener = new ConvertListener();
        button = new JButton("Update");
        button.addActionListener(listener);

        ActionListener listener1  = new BackListener();
        back = new JButton("Back");
        back.addActionListener(listener1);

    }

    /**
     * listener for changing details
     */
    class ConvertListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            try {
                File outputFile = new File("Faculty.txt");
                PrintWriter print = new PrintWriter(outputFile);

                if (!firstNameText.getText().equals("")) {
                    firstName.setText("First Name: " + firstNameText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 4;
                    loginInfo.set(num, firstNameText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }


                }
                if (!lastNameText.getText().equals("")) {
                    lastName.setText("Last Name: " + lastNameText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 5;
                    loginInfo.set(num, lastNameText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }
                }
                if (!miText.getText().equals("")) {
                    mi.setText("Middle Initial: " + miText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 6;
                    loginInfo.set(num, miText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!emailText.getText().equals("")) {
                    email.setText("Email: " + emailText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 7;
                    loginInfo.set(num, "email:"+emailText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!degreeText.getText().equals("")) {
                    degree.setText("Degree: " + degreeText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 8;
                    loginInfo.set(num, "degree:"+degreeText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!phoneNumberText.getText().equals("")) {
                    phoneNumber.setText("Phone Number: " + phoneNumberText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 9;
                    loginInfo.set(num, "phonenumber:"+phoneNumberText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!officeNumberText.getText().equals("")) {
                    officeNumber.setText("Office Number: " + officeNumberText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 10;
                    loginInfo.set(num, "officeNumber:"+officeNumberText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }


                }

                if (!officeHoursText.getText().equals("")) {
                    officeHours.setText("Office Hours " + officeHoursText.getText());

                    int num = loginInfo.indexOf(faculty.getId());
                    num = num + 11;
                    loginInfo.set(num, "officeHours:"+officeHoursText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }


                }


                print.close();
            }
            catch(FileNotFoundException exception)
            {
                System.out.println("File not found");
            }
        }


    }

    /**
     * listener for back button
     */
    class BackListener implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            setVisible(false);
            new Login();
        }
    }

}

