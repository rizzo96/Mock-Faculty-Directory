/**
 * Class for sending emails
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class Email extends JFrame {

    private JTextField emailField;
    private JButton send;
    private JPanel panel = new JPanel();

    /**
     * email constructor
     */
    public Email() {

        setTitle("Computer Science Department");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        setVisible(true);


    }

    /**
     * creates components
     */
    public void createComponents() {
        createButtons();
        createTextFields();

        panel.setLayout(new GridLayout(2,1));
        panel.add(emailField);
        panel.add(send);

        add(panel);


    }

    /**
     * creates text fields
     */
    public void createTextFields() {
        emailField = new JTextField();
    }

    /**
     * create buttons
     */
    public void createButtons() {
        send = new JButton("Send");
        ActionListener emailSender = new sendEmail();
        send.addActionListener(emailSender);
    }

    /**
     * sends email action listener
     */
    class sendEmail implements ActionListener {

        public void actionPerformed(ActionEvent action) {

            Properties prop = new Properties();

            prop.put("mail.smtp.auth", true);

            prop.put("mail.smtp.starttls.enable", "true");

            prop.put("mail.smtp.host", "smtp.gmail.com");

            prop.put("mail.smtp.port", "587");


            String username = "rizwanvz1996@gmail.com";

            String password = "notezcard91";



            Session session = Session.getInstance(prop, new Authenticator() {



                protected PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication(username, password);

                }

            });



            try {

                Message message = new MimeMessage(session);

                message.setFrom(new InternetAddress(username));

                message.setRecipients(

                        Message.RecipientType.TO, InternetAddress.parse("rvazifdar1996@gmail.com"));

                message.setSubject("subject");


                String msg = emailField.getText();



                message.setText(msg);



                Transport.send(message);

                System.out.println("Sent");

            }catch (Exception e) {



                System.err.println(e.getMessage());



            }
        }
    }

        }