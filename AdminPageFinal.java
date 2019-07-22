/**
 * Admin page
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AdminPageFinal extends JFrame {

    private JLabel label;
    private JButton button, button2,button3,button4, button5;
    private JPanel panel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    private Color myBlue = new Color(95, 186, 235);


    /**
     * constructor for admin page
     */
    public AdminPageFinal() {
        setTitle("Admin Choice");
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
        createButton();

        panel.setBackground(myBlue);
        panel.add(label);
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        bottomPanel.add(button5);

        add(panel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * creates labels
     */
    public void createLabels() {
        label = new JLabel("Which database would you like to enter");


    }

    /**
     * creates buttons
     */
    public void createButton() {
        button = new JButton("Faculty");
        button2 = new JButton("Staff");
        button3 = new JButton("Students");
        button4 = new JButton("Questions and Answers");
        button5 = new JButton("Back");


        ActionListener faculty = new Faculty();
        ActionListener students = new Students();
        ActionListener questions = new Questions();
        ActionListener staff = new Staff();
        ActionListener back = new BackListener();


        button.addActionListener(faculty);
        button2.addActionListener(staff);
        button3.addActionListener(students);
        button4.addActionListener(questions);
        button5.addActionListener(back);


    }

    /**
     * faculty file action listener
     */
    class Faculty implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            File file = new File("Faculty.txt");


            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException exception){
                System.out.println("error");
            }
        }


    }

    /**
     * student file action listener
     */
    class Students implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            File file = new File("Students.txt");


            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException exception){
                System.out.println("error");
            }
        }


    }

    /**
     * staff file action listener
     */
    class Staff implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            File file = new File("Staff.txt");


            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException exception){
                System.out.println("error");
            }
        }


    }

    /**
     * question file action listener
     */
    class Questions implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            File file = new File("QuestionsAndAnswers.txt");


            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException exception){
                System.out.println("error");
            }
        }


    }

    /**
     * back button action listener
     */
    class BackListener implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            setVisible(false);
            new Login();
        }
    }

}
