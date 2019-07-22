/**
 * Admin page for staff
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminPageStaff extends JFrame {

    private JLabel label;
    private JButton button, button2,button3;
    private JPanel panel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private ArrayList<String> loginInfo;
    private Staff staff;
    private Color myBlue = new Color(95, 186, 235);


    /**
     * Constructor for admin staff page
     * @param staff passes staff object
     * @param loginInfo passes array for login info
     */
    public AdminPageStaff(Staff staff, ArrayList<String> loginInfo) {
        setTitle("Admin Choice");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);
        setResizable(false);
        this.staff = staff;
        this.loginInfo = loginInfo;
    }

    /**
     * creates components
     */
    public void createComponents() {

        createButton();
        createLabels();

        panel.setBackground(myBlue);
        panel.add(label);
        panel.add(button);
        panel.add(button2);
        bottomPanel.add(button3);

        add(panel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * create labeles
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
     * yes button actionlistener
     */
    class adminYes implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            setVisible(false);
            new AdminPageFinal();
        }


    }

    /**
     * no button action listener
     */
    class adminNo implements ActionListener {

        public void actionPerformed(ActionEvent action) {


                setVisible(false);
                new SecondFrameStaff(staff, loginInfo);


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


