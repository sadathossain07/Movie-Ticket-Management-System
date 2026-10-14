package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class ForgetPassword implements ActionListener,FocusListener {
    
    JFrame frame;
    JLabel email_label;
    JLabel phone_label;
    JPanel background;
    JLabel title;
    JTextField email_TextField;
    JTextField phone;
    JTextField answer;
    JButton lgnbutton;
    JButton backbutton;
    JLabel panel;
    JComboBox question;
    CustomCaret emailCaret;
    CustomCaret phoneCaret;
    CustomCaret answerCaret;
    Details details=new Details();
    

    public ForgetPassword() {

        frame = new JFrame("Password Recovery");
        title = new JLabel("MovieFlox");
        email_label = new JLabel("Email");
        phone_label = new JLabel("Phone Number");
        email_TextField = new JTextField("Please enter your email...");
        phone = new JTextField("Please enter your phone number...");
        answer = new JTextField("Enter your security answer...");
        lgnbutton = new JButton("Submit");
        backbutton = new JButton("Back");
        background = new JPanel();
        panel  = new JLabel(new ImageIcon("Images/forgetpass.png"));
        emailCaret = new CustomCaret(Color.red);
        phoneCaret = new CustomCaret(Color.red);
        answerCaret = new CustomCaret(Color.red);

        String ques[] = {
            "Choose a Security Question...",
            "Favorite MovieName?",
            "Favorite ActorName?",
            "Favorite AcctressName?"
        };

        question = new JComboBox(ques);
        question.setSelectedIndex(0);

        title.setBounds(430, 110, 200, 40);
        email_label.setBounds(355, 195, 120, 25);
        phone_label.setBounds(355, 290, 160,25);
        email_TextField.setBounds(355, 237, 280, 40);
        phone.setBounds(355, 327, 280, 40);
        question.setBounds(355, 390, 280, 40);
        answer.setBounds(355, 440, 280, 40);
        lgnbutton.setBounds(355, 510, 280, 40);
        backbutton.setBounds(20, 20, 80, 40);
        background.setBounds(300, 80, 400, 540);
        panel.setBounds(0,0,1000,800);

        email_TextField.setForeground(Color.gray);
        phone.setForeground(Color.gray);
        answer.setForeground(Color.gray);
        email_label.setForeground(Color.white);
        phone_label.setForeground(Color.white);
        title.setForeground(Color.white);

        background.setBackground(new Color(0,0,0,220));
        email_TextField.setBackground(new Color(0,0,0,220));
        phone.setBackground(new Color(0,0,0,220));
        answer.setBackground(new Color(0,0,0,220));


        email_TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        phone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        answer.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));

        title.setFocusable(true);
        title.requestFocusInWindow();

        frame.add(email_label);
        frame.add(phone_label);
        frame.add(email_TextField);
        frame.add(phone);
        frame.add(question);
        frame.add(answer);
        frame.add(lgnbutton);
        frame.add(backbutton);
        frame.add(title);

        Font newFont = new Font("Arial", Font.PLAIN, 30);

        title.setFont(newFont);

         newFont = new Font("Arial", Font.PLAIN, 20);

         email_label.setFont(newFont);
         phone_label.setFont(newFont);
          
         newFont = new Font("Arial", Font.PLAIN, 18);

         email_TextField.setFont(newFont);
         phone.setFont(newFont);
         answer.setFont(newFont);

         frame.add(background);
         frame.add(panel);

         email_TextField.addFocusListener(this);
         phone.addFocusListener(this);
         answer.addFocusListener(this);
         lgnbutton.addActionListener(this);
         backbutton.addActionListener(this);

         emailCaret.setBlinkRate(500);
         phoneCaret.setBlinkRate(500);
         answerCaret.setBlinkRate(500);

         email_TextField.setCaret(emailCaret);
         phone.setCaret(phoneCaret);
         answer.setCaret(answerCaret);


        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); //to center screen gui
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
       
        String em="Enter your email here...";
        String ph="Enter your phone number here...";
        String an = "Enter your answer here...";

        String getuname = email_TextField.getText();
        String getuphone = phone.getText();
        String getuquestion =String.valueOf(question.getSelectedItem());
        String getuanswer = answer.getText();

        String uname = "Username:"+email_TextField.getText();


        if(e.getSource()==lgnbutton){
           
            if(email_TextField.getText().equals(em)||phone.getText().equals(ph)||answer.getText().equals(an)||question.getSelectedIndex()==0){
               showMessageDialog(null,"Please fill the box correctly.");
            }

            else if(details.findDetails(6,uname).equals(getuname)==false){
                showMessageDialog(null,"There is no user \nassocitated with this email.");
            }
            else if((details.findDetails(6,uname).equals(getuname))==true){
                     if((details.findDetails(3,uname).equals(getuphone)&&details.findDetails(4,uname).equals(getuquestion)&&details.findDetails(5,uname).equals(getuanswer))==true){
                        showMessageDialog(null,"Information Match.\nRedirecting to forgetpassword...");
                        new PasswordChange(uname);
                        frame.setVisible(false);
                     }
                     else{
                        showMessageDialog(null,"Information not Match.");
                     }
           
            }
                
            

        }

        if(e.getSource()==backbutton){
            int show = JOptionPane.showOptionDialog(null, "Are you sure you want to back?", "Back Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{ "Yes","No"}, null);
                     if(show==JOptionPane.YES_OPTION){
                        new SignIn();
                        frame.setVisible(false);
                     }
                     else{

                     }
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
        else if (e.getSource() == phone) {
            if(phone.getText().equals("Please enter your phone number...")){

                phone.setText("+880");
                phone.setBackground(new Color(0,0,0,220));
                phone.setBorder(BorderFactory.createEmptyBorder());
                phone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
                phone.setForeground(Color.white);
            }
        }

        else if (e.getSource() == answer) {
            if(answer.getText().equals("Enter your security answer...")){

                answer.setText("");
                answer.setBackground(new Color(0,0,0,220));
                answer.setBorder(BorderFactory.createEmptyBorder());
                answer.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
                answer.setForeground(Color.white);
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

        else if (e.getSource() == phone) {
            if(phone.getText().equals("+880")||phone.getText().isEmpty()){

                phone.setBackground(new Color(0,0,0,220));
                phone.setText("Please enter your phone number...");
                phone.setBorder(BorderFactory.createEmptyBorder());
                phone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
                phone.setForeground(Color.gray);
               
            }
        }

        else if (e.getSource() == answer) {
            if(answer.getText().equals("")){

                answer.setText("Enter your security answer...");
                answer.setBackground(new Color(0,0,0,220));
                answer.setBorder(BorderFactory.createEmptyBorder());
                answer.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
                answer.setForeground(Color.gray);
            }
        }
       
    }


    
}
