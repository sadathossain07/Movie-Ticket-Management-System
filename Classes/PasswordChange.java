package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class PasswordChange implements ActionListener,FocusListener{
    JFrame frame;
    JLabel pass_label;
    JLabel conpass_label;
    JLabel title;
    JPanel background;
    JPasswordField pass_TextField;
    JPasswordField conpass_TextField;
    JButton lgnbutton;
    JButton backbutton;
    JLabel panel;
    String user;
    JToggleButton toggleButton1;
    JToggleButton toggleButton2;
    CustomCaret passCaret;
    CustomCaret conpassCaret;
    Details details;

    public PasswordChange(String username){
         
        user = username;

        frame = new JFrame("Password Recovery");
        title = new JLabel("CINEHUB");
        pass_label = new JLabel("Password");
        conpass_label = new JLabel("Confirm Password");
        pass_TextField = new JPasswordField("Enter your password...");
        conpass_TextField = new JPasswordField("Enter your confirm password...");
        lgnbutton = new JButton("Change Password");
        backbutton = new JButton("Back");
        background = new JPanel();
        details = new Details();
        toggleButton1 = new JToggleButton(new ImageIcon("Images/eye.png"));
        toggleButton2 = new JToggleButton(new ImageIcon("Images/eye.png"));
        panel  = new JLabel(new ImageIcon("Images/forgetpass.png"));
        passCaret = new CustomCaret(Color.red);
        conpassCaret = new CustomCaret(Color.red);



        title.setBounds(430, 150, 200, 40);
        pass_label.setBounds(355, 235, 120, 25);
        conpass_label.setBounds(355, 330, 180,25);
        pass_TextField.setBounds(355, 277, 280, 40);
        conpass_TextField.setBounds(355, 367, 280, 40);
        lgnbutton.setBounds(355, 480, 280, 40);
        backbutton.setBounds(20, 20, 80, 40);
        toggleButton1.setBounds(640, 295, 40, 20);
        toggleButton2.setBounds(640, 385, 40, 20);
        background.setBounds(300, 120, 400, 500);
        panel.setBounds(0,0,1000,800);

        lgnbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pass_TextField.setForeground(Color.gray);
        conpass_TextField.setForeground(Color.gray);
        pass_label.setForeground(Color.white);
        conpass_label.setForeground(Color.white);
        title.setForeground(Color.white);


        background.setBackground(new Color(0,0,0,220));
        pass_TextField.setBackground(new Color(0,0,0,220));
        conpass_TextField.setBackground(new Color(0,0,0,220));
        toggleButton1.setBackground(new Color(0,0,0,220));
        toggleButton2.setBackground(new Color(0,0,0,220));


        pass_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        conpass_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));

        title.setFocusable(true);
        title.requestFocusInWindow();

        pass_TextField.addFocusListener(this);
        conpass_TextField.addFocusListener(this);
        lgnbutton.addActionListener(this);
        backbutton.addActionListener(this);
        toggleButton1.addActionListener(this);
        toggleButton2.addActionListener(this);

        frame.add(pass_label);
        frame.add(conpass_label);
        frame.add(pass_TextField);
        frame.add(conpass_TextField);
        frame.add(lgnbutton);
        frame.add(backbutton);
        frame.add(title);
        frame.add(toggleButton1);
        frame.add(toggleButton2);



        Font newFont = new Font("Arial", Font.PLAIN, 30);

        title.setFont(newFont);

         newFont = new Font("Arial", Font.PLAIN, 20);

         pass_label.setFont(newFont);
         conpass_label.setFont(newFont);
          
         newFont = new Font("Arial", Font.PLAIN, 18);

         pass_TextField.setFont(newFont);
         conpass_TextField.setFont(newFont);

         pass_TextField.setEchoChar((char) 0);
         conpass_TextField.setEchoChar((char) 0);

        frame.add(background);
        frame.add(panel);


        passCaret.setBlinkRate(500);
        conpassCaret.setBlinkRate(500);

        pass_TextField.setCaret(passCaret);
        conpass_TextField.setCaret(conpassCaret);

        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); //to center screen gui
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
         
        String setpass=new String(pass_TextField.getPassword());
        String setconpass=new String(conpass_TextField.getPassword());
    
            if(e.getSource()==lgnbutton){
                if(setpass.equals("Enter your password...")||setconpass.equals("Enter your confirm password...")){
                    showMessageDialog(null,"Please fill the box correctly.");
                }
                else if(setpass.equals(setconpass)==false){
                    showMessageDialog(null,"Password & Confirm Password \nnot matched.");
                }
                else if(setpass.equals(setconpass)){
                   if(setpass.length()>=8){
                     details.changePassword(pass_TextField,user,2);
                     showMessageDialog(null,"Password Change Sucessful.\nRedirecting to Login Page.");
                     new SignIn();
                     frame.setVisible(false);
    
                   }
                   else {
                    showMessageDialog(null,"Please Enter at least\n 8 digit password.");
                   }
                    
                    
                }
    
            }

            else if(e.getSource()==backbutton){

                int show = JOptionPane.showOptionDialog(null, "Are you sure you want to back?", "Back Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{ "Yes","No"}, null);
                     if(show==JOptionPane.YES_OPTION){
                        new ForgetPassword();
                        frame.setVisible(false);
                     }
                     else{

                     }

            }

            else if(e.getSource()==toggleButton1){
                if(toggleButton1.isSelected()){
                    pass_TextField.setEchoChar((char)0);
                }
                else if(new String(pass_TextField.getPassword()).equals("Enter your password..." )){
                    pass_TextField.setEchoChar((char)0);
                }
    
                else{
                    pass_TextField.setEchoChar('*');
                }
            }

            else if(e.getSource()==toggleButton2){
                if(toggleButton2.isSelected()){
                    conpass_TextField.setEchoChar((char)0);
                }
                else if(new String(conpass_TextField.getPassword()).equals("Enter your confirm password..." )){
                    conpass_TextField.setEchoChar((char)0);
                }
    
                else{
                    conpass_TextField.setEchoChar('*');
                }
            }
        }


    public void focusGained(FocusEvent e) {
        if (e.getSource() == pass_TextField) {
            if(new String(pass_TextField.getPassword()).equals("Enter your password...")){
                pass_TextField.setText("");
                pass_TextField.setEchoChar('*');
                pass_TextField.setBackground(new Color(0,0,0,220));
                pass_TextField.setBorder(BorderFactory.createEmptyBorder());
                pass_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
            }
        }
        else if (e.getSource() == conpass_TextField) {
            if(new String(conpass_TextField.getPassword()).equals("Enter your confirm password...")){
                conpass_TextField.setText("");
                conpass_TextField.setEchoChar('*');
                conpass_TextField.setBackground(new Color(0,0,0,220));
                conpass_TextField.setBorder(BorderFactory.createEmptyBorder());
                conpass_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
                
            }
        }
        
        
    }


    public void focusLost(FocusEvent e) {
        if (e.getSource() == pass_TextField) {

            if(new String(pass_TextField.getPassword()).equals("")){

                pass_TextField.setBackground(new Color(0,0,0,220));
                pass_TextField.setText("Enter your password...");
                pass_TextField.setEchoChar((char) 0);
                pass_TextField.setBorder(BorderFactory.createEmptyBorder());
                pass_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
               
            }
        }

        else if (e.getSource() == conpass_TextField) {

            if(new String(conpass_TextField.getPassword()).equals("")){
                conpass_TextField.setBackground(new Color(0,0,0,220));
                conpass_TextField.setText("Enter your confirm password...");
                conpass_TextField.setEchoChar((char) 0);
                conpass_TextField.setBorder(BorderFactory.createEmptyBorder());
                conpass_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
            }
        }
        
    }
    
}
