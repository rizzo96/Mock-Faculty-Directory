/**
 * Student frame
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondFrame extends JFrame {

    private JLabel question;
    private JLabel answer1;
    private JPanel panel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JTextField askQuestion;
    private JButton enter, back, retry,email;
    private Student student;
    private Color myBlue = new Color(95, 186, 235);
    private String potentialMatch, checker;
    private ArrayList<String> array = new ArrayList<>();
    String answer = "blah";
    String question1, output;
    int counter = 0;
    String[] matchwords;
    int matcher = 0;
    String answerthing;
    File inputFile = new File("QuestionsAndAnswers.txt");


   /**
    * constructor
    */
    public SecondFrame() {
        setTitle("Question and Answer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);
    }

    /**
     * overload contrustor
     * @param student student
     */
    public SecondFrame(Student student) {

        setTitle("Question and Answer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.student = student;

        createComponents();
        setResizable(false);
        setVisible(true);
    }


    /**
     * creates components
     */
    public void createComponents() {
        createLabels();
        createButtons();
        createTextFields();
        topPanel.add(question);

        panel.setLayout(new GridLayout(3, 1));

        panel.add(askQuestion);
        panel.add(enter);
        panel.add(answer1);
        bottomPanel.add(back);
        bottomPanel.add(retry);
        bottomPanel.add(email);

        panel.setBackground(myBlue);

        add(panel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * creates labels
     */
    public void createLabels() {
        question = new JLabel("Ask a Question");
        answer1 = new JLabel("");

    }

    /**
     * creates text fields
     */
    public void createTextFields() {
        askQuestion = new JTextField(100);
    }

    /**
     * creates buttons
     */
    public void createButtons() {

        ActionListener listener = new ConvertListener();
        enter = new JButton("Enter");
        enter.addActionListener(listener);

        ActionListener backlistener = new BackListener();
        back = new JButton("Back");
        back.addActionListener(backlistener);

        ActionListener redolistener = new redo();
        retry = new JButton("retry");
        retry.addActionListener(redolistener);

        ActionListener email2 = new Emails();
        email = new JButton("Email");
        email.addActionListener(email2);
    }

    /**
     * listener for checking for answer
     */
    class ConvertListener implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            try {

                Scanner sc = new Scanner(inputFile);
                Scanner sc1 = new Scanner(inputFile);
                String question = askQuestion.getText();
                potentialMatch = sc.nextLine();

                question = question.toLowerCase();

                while (!question.equals(potentialMatch)) {

                    if (!sc.hasNextLine()) {
                        break;
                    }
                    potentialMatch = sc.nextLine();
                }

                if (question.equals(potentialMatch)) // if exact match is found
                {

                    checker = sc.nextLine();
                    do {

                        array.add(checker);
                        checker = sc.nextLine();
                    } while (!checker.equals("*endanswer*"));

                    answer = array.get(0);
                    for (int i = 1; i < array.size(); i++) {
                        answer = answer + "," + array.get(i);
                    }

                    answer1.setText(answer);


                }

                if (!answer1.getText().equals(answer)) // look for key words
                {
                    System.out.println("hi");
                    question1 = askQuestion.getText();
                    question1.toLowerCase();
                    output = question1.replaceAll("\\b\\w{1,3}\\b\\s?", "");
                    output = output.replace("state", "");
                    System.out.println(output);
                    String[] words = output.split("\\W+");


                    while (sc1.hasNext()) {
                        counter = 0;
                        potentialMatch = sc1.nextLine();
                        System.out.println(potentialMatch);
                        matchwords = potentialMatch.split("\\W+");

                        System.out.println("This is words from the file");
                        for (int i = 0; i < matchwords.length; i++)
                        {
                            System.out.println(matchwords[i]);
                        }

                        System.out.println("This is words from the input");
                        for (int i = 0; i < words.length; i++)
                        {
                            System.out.println(words[i]);
                        }


                        for (matcher = 0; matcher < matchwords.length; matcher++) {
                            checker = matchwords[matcher];
                            for (int i = 0; i < words.length; i++) {
                                if (words[i].equals(checker)) {
                                    counter++;
                                    System.out.println("This is words:" +words[i]);
                                    System.out.println("This is checker:" +checker);
                                    System.out.println(counter);
                                }
                                if (counter >= 5) {
                                    System.out.println("matched");
                                    System.out.println(potentialMatch);
                                    answerthing = sc1.nextLine();
                                    do {

                                        array.add(answerthing);
                                        answerthing = sc1.nextLine();

                                    } while (!answerthing.equals("*endanswer*"));


                                    System.out.println(array);

                                    answer = array.get(0);
                                    for (int i2 = 1; i2 < array.size(); i2++) {
                                        answer = answer + "," + array.get(i2);
                                    }

                                    answer1.setText(answer);
                                    break;


                                }
                            }

                        }


                    }

                    if(answer.equals("blah"))
                    {
                        JOptionPane.showMessageDialog(null, "No match found!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (FileNotFoundException exception) {
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

    /**
     * listener for redo
     */
    class redo implements ActionListener {

        public void actionPerformed(ActionEvent action) {

                setVisible(false);
                new SecondFrame();

                  }
    }

    /**
     * listener for email button
     */
    class Emails implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            setVisible(false);
            new Email();

        }
    }


}
