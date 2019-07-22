/**
 * Asks the user if they want to go onto admin page
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminPage extends JFrame {

    private JLabel label;
    private JButton button, button2, button3;
    private JPanel panel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    private ArrayList<String> loginInfo;
    private Faculty faculty;
    private Color myBlue = new Color(95, 186, 235);

    /**
     * constructor for admin page
     * @param faculty passes faculty object through
     * @param loginInfo passes login info array through
     */
    public AdminPage(Faculty faculty, ArrayList<String> loginInfo) {
        setTitle("Admin Choice");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        setResizable(false);
        setVisible(true);
        this.faculty = faculty;
        this.loginInfo = loginInfo;

    }

    /**
     * create components
     */
    public void createComponents() {

        createLabels();
        createButton();

        panel.setBackground(myBlue);

        panel.add(label);
        panel.add(button);
        panel.add(button2);
        bottomPanel.add(button3);

        add(panel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * create labels
     */
    public void createLabels() {
        label = new JLabel("Would you like to access the admin page?");


    }

    /**
     * create buttons
     */
    public void createButton() {
        button = new JButton("Yes");
        button2 = new JButton("No");
        button3 = new JButton("Back");

        ActionListener yes = new adminYes();
        ActionListener no = new adminNo();
        ActionListener back = new BackListener();

        button.addActionListener(yes);
        button2.addActionListener(no);
        button3.addActionListener(back);


    }

    /**
     * action listener for yes
     */
    class adminYes implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            setVisible(false);
            new AdminPageFinal();
        }


    }

    /**
     * action listener for no
     */
    class adminNo implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            try {
                setVisible(false);

                new SecondFrameFaculty(faculty, loginInfo);
            } catch (FileNotFoundException exception) {
                System.out.println("error");
            }
        }
    }

    /**
     * action listener for back
     */
    class BackListener implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            setVisible(false);
            new Login();
        }
    }
}

