package Classes;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddAdmin implements ActionListener,FocusListener{
    JFrame frame;
    JLabel email_label;
    JLabel pass_label;
    JPanel background;
    JLabel title;
    JLabel href;
    JTextField email_TextField;
    JPasswordField password;
    JButton lgnbutton,backButton;
    JLabel panel;
    JToggleButton toggleButton;
    Caret emailCaret;
    Caret passCaret;
    String User;

    public AddAdmin(String User){

        this.User=User;

        frame = new JFrame("Add Admin");
        title = new JLabel("CINEHUB");
        email_label = new JLabel("Email");
        pass_label = new JLabel("Password");
        email_TextField = new JTextField("Please enter your email...");
        password = new JPasswordField("Please enter your password...");
        lgnbutton = new JButton("Log In");
        toggleButton = new JToggleButton(new ImageIcon("Images/eye.png"));
        background = new JPanel();
        backButton = new JButton("Back");
        panel  = new JLabel(new ImageIcon("Images/Admin.jpg"));
        href = new JLabel("<html><a href=\"#\">Are you user?</a></html>");
        emailCaret = new CustomCaret(Color.red);
        passCaret = new CustomCaret(Color.red);


        href.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (e.getSource()==href){

                    int check = JOptionPane.showOptionDialog(null, "Are you sure you want to \ngo user Signin?", "User Login Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{ "Yes","NO"}, null);
                    if(check == JOptionPane.YES_OPTION){

                       new SignIn();
                       frame.setVisible(false);
                    }
                    else{
                       
                    }
               }

               
                
            }

        });


        title.setBounds(430, 170, 200, 40);
        email_label.setBounds(350, 235, 120, 25);
        pass_label.setBounds(350, 330, 120,25);
        email_TextField.setBounds(350, 277, 280, 40);
        password.setBounds(350, 367, 280, 40);
        toggleButton.setBounds(630, 385, 40, 20);
        lgnbutton.setBounds(350, 480, 280, 40);
        backButton.setBounds(80, 40, 60, 40);
        href.setBounds(354, 408, 180, 40);
        background.setBounds(300, 120, 400, 500);
        panel.setBounds(0,0,1000,800);


        lgnbutton.addActionListener(this);
        email_TextField.addFocusListener(this);
        password.addFocusListener(this);
        toggleButton.addActionListener(this);
        backButton.addActionListener(this);
        password.setEchoChar((char) 0);

        lgnbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        href.setCursor(new Cursor(Cursor.HAND_CURSOR));

        email_TextField.setForeground(Color.gray);
        password.setForeground(Color.gray);
        email_label.setForeground(Color.white);
        pass_label.setForeground(Color.white);
        title.setForeground(Color.white);

        toggleButton.setBackground(new Color(0,0,0,220));
        toggleButton.setOpaque(true);

        background.setBackground(new Color(0,0,0,220));
        email_TextField.setBackground(new Color(0,0,0,220));
        password.setBackground(new Color(0,0,0,220));

        email_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        password.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));

        title.setFocusable(true);
        title.requestFocusInWindow();

        frame.add(email_label);
        frame.add(pass_label);
        frame.add(email_TextField);
        frame.add(password);
        frame.add(lgnbutton);
        frame.add(title);
        frame.add(backButton);
        // frame.add(toggleButton);
        // frame.add(href);

        Font newFont = new Font("Arial", Font.PLAIN, 30);

        title.setFont(newFont);

         newFont = new Font("Arial", Font.PLAIN, 20);

         email_label.setFont(newFont);
         pass_label.setFont(newFont);
          
         newFont = new Font("Arial", Font.PLAIN, 18);

         email_TextField.setFont(newFont);
         password.setFont(newFont);
         href.setFont(newFont);
         frame.add(background);
         frame.add(panel);

        emailCaret.setBlinkRate(500);
        passCaret.setBlinkRate(500);

        email_TextField.setCaret(emailCaret);
        password.setCaret(passCaret);


        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); //to center screen gui
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {
       
        String path = "files/Admin.txt";


        if (e.getSource() == lgnbutton) {
            int flag = 0;

            lgnbutton.setVisible(false);
            lgnbutton.setEnabled(false);
            

           try{
    
                    
                FileWriter fileWriter = new FileWriter(path, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                if(email_TextField.getText().contains("@gmail.com")&& (password.getText().length()>=8)){
                    printWriter.println("==============================");
                    printWriter.println("Username:"+email_TextField.getText());
                    printWriter.println("Password:"+password.getText());
                    printWriter.println("==============================");

                    printWriter.close();
                    flag++;

                }
                
                    
                if(email_TextField.getText().isEmpty()||password.getText().isEmpty()){
                    showMessageDialog(null,"Please fill the box correctly.");
                }

                else if(flag==1){
                    
                    new AdminDashBoard(User);
                    frame.setVisible(false);
                }

                else{
                    
                    showMessageDialog(null,"Add vaild email & \n 8 digit password.");

                }

                lgnbutton.setVisible(true);
                lgnbutton.setEnabled(true);

                
                
    
                
            
        }
         catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

         if(e.getSource()==toggleButton){
            if(toggleButton.isSelected()){
                password.setEchoChar((char)0);
            }
            else if(new String(password.getPassword()).equals("Please enter your password..." )){
                password.setEchoChar((char)0);
            }

            else{
                password.setEchoChar('*');
            }
           }

           if(e.getSource()==backButton){
            new AdminDashBoard(User);
            frame.setVisible(false);

           }

    }


    public void focusGained(FocusEvent e) {

        if (e.getSource() == email_TextField) {
            if(email_TextField.getText().equals("Please enter your email...")){
                email_TextField.setText("");
                email_TextField.setBackground(new Color(0,0,0,220));
                email_TextField.setBorder(BorderFactory.createEmptyBorder());
                email_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
                email_TextField.setForeground(Color.white);
            }
        }
        else if (e.getSource() == password) {
            if(new String(password.getPassword()).equals("Please enter your password...")){
                password.setText("");
                password.setEchoChar('*');
                password.setBackground(new Color(0,0,0,220));
                password.setBorder(BorderFactory.createEmptyBorder());
                password.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
                password.setForeground(Color.white);
                
            }
        }
    }


    public void focusLost(FocusEvent e) {

        if (e.getSource() == email_TextField) {

            if(email_TextField.getText().equals("")){
                email_TextField.setBackground(new Color(0,0,0,220));
                email_TextField.setText("Please enter your email...");
                email_TextField.setBorder(BorderFactory.createEmptyBorder());
                email_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
                email_TextField.setForeground(Color.gray);
               
            }
        }

        else if (e.getSource() == password) {
            if(new String(password.getPassword()).equals("")){
                password.setBackground(new Color(0,0,0,220));
                password.setText("Please enter your password...");
                password.setEchoChar((char) 0);
                password.setBorder(BorderFactory.createEmptyBorder());
                password.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
                password.setForeground(Color.gray);
            }
        }
        
    }
}

