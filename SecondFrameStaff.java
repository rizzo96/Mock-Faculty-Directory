/**
 * Staff page
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SecondFrameStaff extends JFrame{

    private JPanel panel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    private JLabel firstName, lastName, mi,phoneNumber, officeNumber, email, degree;
    private JTextField firstNameText, lastNameText, miText, phoneNumberText, officeNumberText, emailText,degreeText;
    private JButton button, back;
    private Staff staff;
    private Color myBlue = new Color(95, 186, 235);
    private ArrayList<String> loginInfo;

    /**
     * Staff constructor
     * @param staff staff object
     * @param loginInfo login info array
     */
    public SecondFrameStaff(Staff staff,ArrayList<String> loginInfo) {

        setTitle("Staff");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.staff = staff;
        this.loginInfo = loginInfo;

        createComponents();
    }

    /**
     * creates components
     */
    public void createComponents() {

        createLabels();
        createTextFields();
        createButtons();

        panel.setLayout(new GridLayout(7,2));
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
        panel.add(email);
        panel.add(emailText);
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
        firstName = new JLabel("First Name: "+staff.getFirstName());
        lastName = new JLabel("Last Name: "+staff.getLastName());
        mi = new JLabel("Middle Initial: "+staff.getMi());
        phoneNumber = new JLabel("Phone number: "+staff.getPhoneNumber());
        officeNumber = new JLabel("Office Number: "+staff.getOfficeNumber());
        email = new JLabel("Email: "+staff.getEmail());
        degree = new JLabel("Degree: "+staff.getDegree());

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
        emailText = new JTextField(10);
        degreeText = new JTextField(10);

    }

    /**
     * creates buttons
     */
    public void createButtons() {

        ActionListener listener = new ConvertListener();
        button = new JButton("Update");
        button.addActionListener(listener);

        ActionListener listener1 = new BackListener();
        back = new JButton("Back");
        back.addActionListener(listener1);
    }

    /**
     * listener for changing information
     */
    class ConvertListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            try {
                File outputFile = new File("Staff.txt");
                PrintWriter print = new PrintWriter(outputFile);

                if (!firstNameText.getText().equals("")) {
                    firstName.setText("First Name: " + firstNameText.getText());

                    int num = loginInfo.indexOf(staff.getId());
                    num = num + 5;
                    loginInfo.set(num, firstNameText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }


                }
                if (!lastNameText.getText().equals("")) {
                    lastName.setText("Last Name: " + lastNameText.getText());

                    int num = loginInfo.indexOf(staff.getId());
                    num = num + 6;
                    loginInfo.set(num, lastNameText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }
                }
                if (!miText.getText().equals("")) {
                    mi.setText("Middle Initial: " + miText.getText());

                    int num = loginInfo.indexOf(staff.getId());
                    num = num + 7;
                    loginInfo.set(num, miText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!emailText.getText().equals("")) {
                    email.setText("Email: " + emailText.getText());

                    int num = loginInfo.indexOf(staff.getId());
                    num = num + 8;
                    loginInfo.set(num, "email:"+emailText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!degreeText.getText().equals("")) {
                    degree.setText("Degree: " + degreeText.getText());

                    int num = loginInfo.indexOf(staff.getId());
                    num = num +9;
                    loginInfo.set(num, "degree:"+degreeText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!phoneNumberText.getText().equals("")) {
                    phoneNumber.setText("Phone Number: " + phoneNumberText.getText());

                    int num = loginInfo.indexOf(staff.getId());
                    num = num + 10;
                    loginInfo.set(num, "phonenumber:"+phoneNumberText.getText());

                    for (int i = 0; i < loginInfo.size(); i++) {
                        print.println(loginInfo.get(i));
                    }

                }
                if (!officeNumberText.getText().equals("")) {
                    officeNumber.setText("Office Number: " +officeNumberText.getText());

                    int num = loginInfo.indexOf(staff.getId());
                    num = num + 11;
                    loginInfo.set(num, "officeNumber:"+officeNumberText.getText());

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

        public void actionPerformed(ActionEvent event) {

            setVisible(false);
            new Login();

        }

    }

    }



