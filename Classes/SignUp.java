package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static javax.swing.JOptionPane.showMessageDialog;

public class SignUp implements ActionListener,FocusListener {
    JLabel l_title;
    JLabel l_fullname;
    JLabel l_email;
    JLabel l_pass;
    JLabel l_phone;
    JLabel l_background;
    JLabel l_question;
    JLabel l_href;

    JTextField t_fullname;
    JTextField t_email;
    JPasswordField p_password;
    JTextField t_phone;
    JPasswordField t_answer;

    JButton b_signup;
    JToggleButton toggleButton1;
    JToggleButton toggleButton2;

    CustomCaret ct_fullname;
    CustomCaret ct_email;
    CustomCaret cp_password;
    CustomCaret ct_phone;
    CustomCaret ct_answer;

    JComboBox question;

    JPanel panel;
    JFrame frame;

    EmailValidator emailValidator;

    String full="Enter your fullname here...";
    String em="Enter your email here...";
    String pa="Enter your password here...";
    String ph="Enter your phone number here...";
    String an = "Enter your answer here...";

       

    public SignUp() {

        frame = new JFrame("Sign Up");
        l_title = new JLabel("Welcome To CINEHUB");
        l_fullname = new JLabel("FullName");
        l_email = new JLabel("Email Address");
        l_pass = new JLabel("Password");
        l_phone = new JLabel("Phone Number");
        l_background = new JLabel(new ImageIcon("Images/background.jpeg"));
        l_question = new JLabel("Answer the security Question");
        l_href = new JLabel("<html><a href=\"#\">Do you have an account?</a></html>");

        t_fullname = new JTextField(full);
        t_email = new JTextField(em);
        p_password = new JPasswordField(pa);
        t_phone = new JTextField(ph);
        t_answer = new JPasswordField(an);
        panel = new JPanel();
        emailValidator =  new EmailValidator();

        toggleButton1 = new JToggleButton(new ImageIcon("Images/eye.png"));
        toggleButton2 = new JToggleButton(new ImageIcon("Images/eye.png"));
        b_signup = new JButton(new ImageIcon("Images/SignUpIcon.png"));

        ct_fullname = new CustomCaret(Color.red);
        ct_email = new CustomCaret(Color.red);
        cp_password = new CustomCaret(Color.red);
        ct_phone = new CustomCaret(Color.red);
        ct_answer = new CustomCaret(Color.red);

        l_href.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b_signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        String ques[] = {
            "Choose a Security Question...",
            "Favorite MovieName?",
            "Favorite ActorName?",
            "Favorite AcctressName?"
        };

        question = new JComboBox(ques);
        question.setSelectedIndex(0);

        l_title.setBounds(670, 40, 200, 40);
        l_fullname.setBounds(620, 100, 80, 25);
        l_email.setBounds(620, 176, 140, 25);
        l_pass.setBounds(620, 252, 120, 25);
        l_phone.setBounds(620, 326, 120, 25);
        l_background.setBounds(0, 0, 1000, 800);
        l_question.setBounds(620, 400, 300, 25);
        l_href.setBounds(620,530,200,25);

        t_fullname.setBounds(620, 130, 280, 40);
        t_email.setBounds(620, 205, 280, 40);
        p_password.setBounds(620, 280, 280, 40);
        t_phone.setBounds(620, 355, 280, 40);
        t_answer.setBounds(620, 480, 280, 40);

        b_signup.setBounds(700, 580, 120, 60);
        toggleButton1.setBounds(910, 298, 40, 20);
        toggleButton2.setBounds(910, 498, 40, 20);
        question.setBounds(620, 429, 280, 40);

        panel.setBounds(500, 0, 500, 700);

        frame.setSize(1000, 700);

        b_signup.addActionListener(this);
        t_fullname.addFocusListener(this);
        t_email.addFocusListener(this);
        p_password.addFocusListener(this);
        t_phone.addFocusListener(this);
        t_answer.addFocusListener(this);
        toggleButton1.addActionListener(this);
        toggleButton2.addActionListener(this);

        p_password.setEchoChar((char)0);
        t_answer.setEchoChar((char)0);

        l_href.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                showMessageDialog(null,"Redirecting to Login...");
                new SignIn();
                frame.setVisible(false);
            }

        });


        Font font = l_title.getFont();
        int fontSize = font.getSize() + 5; // Increase font size by 5
        Font newFont = new Font(font.getName(), font.getStyle(), fontSize);
        
        l_title.setFont(newFont);

        fontSize = font.getSize()+3;
        newFont = new Font(font.getName(), font.getStyle(), fontSize);

        l_fullname.setFont(newFont);
        l_email.setFont(newFont);
        l_email.setFont(newFont);
        l_pass.setFont(newFont);
        l_phone.setFont(newFont);
        l_question.setFont(newFont);
        l_href.setFont(newFont);

        fontSize = font.getSize()+3;
        newFont = new Font(font.getName(), font.getStyle(), fontSize);

        t_fullname.setFont(newFont);
        t_email.setFont(newFont);
        p_password.setFont(newFont);
        t_phone.setFont(newFont);
        t_answer.setFont(newFont);

        l_title.setForeground(Color.white);
        l_fullname.setForeground(Color.white);
        l_email.setForeground(Color.white);
        l_pass.setForeground(Color.white);
        l_phone.setForeground(Color.white);
        l_question.setForeground(Color.white);
        l_href.setForeground(Color.white);

        t_fullname.setForeground(Color.GRAY);
        t_email.setForeground(Color.GRAY);
        p_password.setForeground(Color.GRAY);
        t_phone.setForeground(Color.GRAY);
        t_answer.setForeground(Color.GRAY);


        t_fullname.setBackground(new Color(0,0,0,220));
        t_email.setBackground(new Color(0,0,0,220));
        p_password.setBackground(new Color(0,0,0,220));
        t_phone.setBackground(new Color(0,0,0,220));
        t_answer.setBackground(new Color(0,0,0,220));
        panel.setBackground(new Color(0,0,0,220));
        toggleButton1.setBackground(new Color(0,0,0,220));
        toggleButton2.setBackground(new Color(0,0,0,220));

        l_title.setFocusable(true);
        l_title.requestFocusInWindow();

        t_fullname.setBorder(BorderFactory.createEmptyBorder());
        t_email.setBorder(BorderFactory.createEmptyBorder());
        p_password.setBorder(BorderFactory.createEmptyBorder());
        t_phone.setBorder(BorderFactory.createEmptyBorder());
        t_answer.setBorder(BorderFactory.createEmptyBorder());

        t_fullname.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        t_email.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        p_password.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        t_phone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        t_answer.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));

        ct_fullname.setBlinkRate(500);
        ct_email.setBlinkRate(500);
        cp_password.setBlinkRate(500);
        ct_phone.setBlinkRate(500);
        ct_answer.setBlinkRate(500);

        t_fullname.setCaret(ct_fullname);
        t_email.setCaret(ct_email);
        p_password.setCaret(cp_password);
        t_phone.setCaret(ct_phone);
        t_answer.setCaret(ct_answer);

        frame.add(l_fullname);
        frame.add(l_email);
        frame.add(l_pass);
        frame.add(l_phone);
        frame.add(t_fullname);
        frame.add(t_email);
        frame.add(p_password);
        frame.add(t_phone);
        frame.add(b_signup);
        frame.add(toggleButton1);
        frame.add(toggleButton2);
        frame.add(l_title);
        frame.add(question);
        frame.add(l_question);
        frame.add(t_answer);
        frame.add(l_href);
        frame.add(panel);
        frame.add(l_background);
       

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
    }

    public void actionPerformed(ActionEvent e) {

        String getfullname = t_fullname.getText();
        String getemail = t_email.getText();
        String getpassword = new String(p_password.getPassword());
        String getphone = t_phone.getText();
        String getquestion = String.valueOf(question.getSelectedItem());
        int questionqu = question.getSelectedIndex();
        String getanswer = new String(t_answer.getPassword());

        String fullname = "FullName:" + getfullname;
        String email = "Username:" + getemail;
        String password = "Password:" + getpassword;
        String phone = "Phone Number:" + getphone;
        String ques = "Security Question is:" + getquestion;
        String answer = "Answer is:" + getanswer;

        int k = 0;
        int emailcheck = 0;
        int phonecheck = 0;
        int passconfirm = 0;

        if (e.getSource() == b_signup) {

            if (getfullname.equals(full) || getemail.equals(em) || getpassword.equals(pa) || getphone.equals(ph) || questionqu == 0 || getanswer.equals(an)) {
                showMessageDialog(null, "Please fill the box correctly.");
            } else {

                if (emailValidator.validate(getemail)) {
                    emailcheck++;
                } else {
                    showMessageDialog(null, "Please Enter vaild Email.");
                }

                if (getphone.length() == 14) {

                    if ((phone.contains("+88017") || phone.contains("+88018") || phone.contains("+88019") || phone.contains("+88016") || phone.contains("+88013") || phone.contains("+88015"))&&isNumeric(getphone.substring(1))) {
                        phonecheck++;

                    } else {
                        showMessageDialog(null, "Only available in Bangladeshi Operator.\nCountry code also Necessary");
                    }
                } else {
                    showMessageDialog(null, "Please Enter vaild Phone number.");
                }

                if (getpassword.length() >= 8) {
                    passconfirm++;

                } else {
                    showMessageDialog(null, "PassWord is Less than 8 digit.");
                }

                File file = new File("files/user.txt");
                String path = "files/user.txt";

                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception ef) {
                        ef.printStackTrace();
                    }

                }

                try {
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);

                    FileReader fileReader = new FileReader(path);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    int check = 0;

                    while (bufferedReader.readLine() != null) {
                        check++;
                    }
                    bufferedReader.close();
                    int flag = 0;
                    if (emailcheck == 1 && phonecheck == 1 && passconfirm == 1) {
                        for (int i = 0; i < check; i++) {
                            String line1 = Files.readAllLines(Paths.get(path)).get(i);
                            if (line1.equals(email)) {
                                showMessageDialog(null, "Same Email Exist.\nLogin with That.");
                                flag++;
                            }
                        }

                    } else {
                        flag++;
                    }

                    if (flag == 0) {
                        printWriter.println("===============================================");
                        printWriter.println(fullname);
                        printWriter.println(email);
                        printWriter.println(password);
                        printWriter.println(phone);
                        printWriter.println("Path:"+"demo.png");
                        printWriter.println(ques);
                        printWriter.println(answer);
                        printWriter.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy")));
                        printWriter.println("===============================================");
                        k++;
                        printWriter.close();
                    }

                } catch (Exception ex) {
                    showMessageDialog(null, ex);
                }

                if (k == 1) {
                    new SignIn();
                    frame.setVisible(false);
                }

            }

        }

        else if(e.getSource()==toggleButton1){
            if(toggleButton1.isSelected()){
                p_password.setEchoChar((char)0);
            }
            else if(new String(p_password.getPassword()).equals(pa)){
                p_password.setEchoChar((char)0);
            }

            else{
                p_password.setEchoChar('*');
            }
        }

        else if(e.getSource()==toggleButton2){
            if(toggleButton2.isSelected()){
                t_answer.setEchoChar((char)0);
            }
            else if(new String(t_answer.getPassword()).equals(an )){
                t_answer.setEchoChar((char)0);
            }

            else{
                t_answer.setEchoChar('*');
            }
        }

    }

    public static boolean isNumeric(String str) {
        
        return str.matches("\\d+");
    }

    public void focusGained(FocusEvent e){

        if(e.getSource()==t_fullname){
           if(t_fullname.getText().equals(full)){
                t_fullname.setText("");
                t_fullname.setForeground(Color.white);
                t_fullname.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
            }
        }

        else if(e.getSource()==t_email){
            if(t_email.getText().equals(em)){
                 t_email.setText("");
                 t_email.setForeground(Color.white);
                 t_email.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
             }
         }

         else if(e.getSource()==p_password){
            if(new String (p_password.getPassword()).equals(pa)){
                p_password.setText("");
                p_password.setForeground(Color.white);
                p_password.setEchoChar('*');
                p_password.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
             }
         }
         else if(e.getSource()==t_phone){
            if(t_phone.getText().equals(ph)){
                t_phone.setText("+880");
                t_phone.setForeground(Color.white);
                t_phone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
             }
         }

         else if(e.getSource()==t_answer){
            if(new String(t_answer.getPassword()).equals(an)){
                t_answer.setText("");
                t_answer.setForeground(Color.white);
                t_answer.setEchoChar('*');
                t_answer.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.green));
             }
         }

    }

    public void focusLost(FocusEvent e){

        if(e.getSource()==t_fullname){
            if(t_fullname.getText().equals("")){
                 t_fullname.setText(full);
                 t_fullname.setForeground(Color.GRAY);
                 t_fullname.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
             }
         }

         else if(e.getSource()==t_email){
            if(t_email.getText().equals("")){
                 t_email.setText(em);
                 t_email.setForeground(Color.GRAY);
                 t_email.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
             }
         }

         else if(e.getSource()==p_password){
            if(new String (p_password.getPassword()).equals("")){
                p_password.setText(pa);
                p_password.setForeground(Color.GRAY);
                p_password.setEchoChar((char)0);
                p_password.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
             }
         }

         else if(e.getSource()==t_phone){
            if(t_phone.getText().equals("+880")){
                t_phone.setText(ph);
                t_phone.setForeground(Color.GRAY);
                t_phone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
             }
         }

         else if(e.getSource()==t_answer){
            if(new String(t_answer.getPassword()).equals("")){
                t_answer.setText(an);
                t_answer.setForeground(Color.GRAY);
                t_answer.setEchoChar((char)0);
                t_answer.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
             }
         }



    }

     

}