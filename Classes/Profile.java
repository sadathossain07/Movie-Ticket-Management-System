package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class Profile implements ActionListener {

    private JFrame frame;
    private JLabel firstname;
    private JLabel email;
    private JLabel phone;
    private JLabel profilePictureLabel;
    private JTextField t_first;
    private JTextField t_email;
    private JTextField t_phone;
    private JButton editButton;
    private JButton uploadButton;
    private JButton backButton;
    private String user;
    private Details details = new Details();

    public Profile(String username) {

        user = username;
        String setEmail = username.substring("Username:".length());

        frame = new JFrame("User Profile");
        firstname = new JLabel("FirstName       :");
        email = new JLabel("Email              :");
        phone = new JLabel("Phone Number :");
        profilePictureLabel = new JLabel();

        t_first = new JTextField(details.findDetails(1, username));
        t_email = new JTextField(setEmail);
        t_phone = new JTextField(details.findDetails(3, username));

        editButton = new JButton("Edit");
        uploadButton = new JButton("Upload Your\n Profile  here.");
        backButton = new JButton("back");

        profilePictureLabel.setBounds(110, 20, 160, 100);
        firstname.setBounds(40, 130, 140, 30);
        email.setBounds(40, 170, 140, 30);
        phone.setBounds(40, 210, 140, 30);

        t_first.setBounds(170, 130, 170, 30);
        t_email.setBounds(170, 170, 170, 30);
        t_phone.setBounds(170, 210, 170, 30);

        uploadButton.setBounds(110, 20, 160, 100);
        editButton.setBounds(140, 280, 100, 30);
        backButton.setBounds(10, 10, 60, 30);

        uploadButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilePictureLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));


        Font font = firstname.getFont();
        int fontSize = font.getSize() + 2; // Increase font size by 5
        Font newFont = new Font(font.getName(), font.getStyle(), fontSize);

        firstname.setFont(newFont);
        email.setFont(newFont);
        phone.setFont(newFont);
        t_first.setFont(newFont);
        t_email.setFont(newFont);
        t_phone.setFont(newFont);

        t_first.setBorder(BorderFactory.createEmptyBorder());
        t_email.setBorder(BorderFactory.createEmptyBorder());
        t_phone.setBorder(BorderFactory.createEmptyBorder());

        t_first.setBackground(new Color(238, 238, 238));
        t_email.setBackground(new Color(238, 238, 238));
        t_phone.setBackground(new Color(238, 238, 238));

        t_first.setEditable(false);
        t_email.setEditable(false);
        t_phone.setEditable(false);

        editButton.addActionListener(this);
        uploadButton.addActionListener(this);
        backButton.addActionListener(this);
       

        ImageIcon imageIcon = new ImageIcon( details.findDetails(7, user)); // your image file path
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(profilePictureLabel.getWidth(), profilePictureLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        profilePictureLabel.setIcon(scaledImageIcon);


        frame.add(profilePictureLabel);
        frame.add(firstname);
        frame.add(email);
        frame.add(phone);
        frame.add(t_first);
        frame.add(t_email);
        frame.add(t_phone);
        frame.add(editButton);
        frame.add(uploadButton);
        frame.add(backButton);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    

    public static boolean isNumeric(String str) {
        
        return str.matches("\\d+");
    }
    
   
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == editButton) {

            if (editButton.getText().equals("Edit")) {

                t_first.setEditable(true);
                t_phone.setEditable(true);

                t_first.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                t_phone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

                editButton.setText("Save");

            } else if (editButton.getText().equals("Save")) {
                    
                String k =t_phone.getText().substring(1);

                if (((t_first.getText().isEmpty()==false) && (t_phone.getText().length() == 14)&& t_phone.getText().contains("+880") && isNumeric(k))&&(t_phone.getText().contains("+88017")|| t_phone.getText().contains("+88018") || t_phone.getText().contains("+88019") || t_phone.getText().contains("+88016") || t_phone.getText().contains("+88013") || t_phone.getText().contains("+88015"))) {
                    details.changeFirstname(t_first, user, 1);
                    details.changePhone(t_phone, user, 3);
                    showMessageDialog(null, "Succesfully Updated.");

                    t_first.setEditable(false);
                    t_phone.setEditable(false);

                    t_first.setBorder(BorderFactory.createEmptyBorder());
                    t_phone.setBorder(BorderFactory.createEmptyBorder());

                    editButton.setText("Edit");
                    

                } else {
                    showMessageDialog(null, "Not Updated");
                }

            }

        }

        if (e.getSource() == uploadButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                Path filePath = Paths.get(file.getAbsolutePath());
                String userPath = details.findDetails(6, user);

                File diretory = new File("Images/"+userPath);

                if (!diretory.exists()) {
                    try {
                        diretory.mkdir();
                    } catch (SecurityException se) {
                       
                        se.printStackTrace();
                    }
                }

                Path destPath = Paths.get("Images/"+userPath +"/" + file.getName());

                try {
                    Files.copy(filePath, destPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                
               details.changePath(destPath.toString(),user ,7);

               String paths = details.findDetails(7, user);

                ImageIcon imageIcon = new ImageIcon(paths);
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(profilePictureLabel.getWidth(), profilePictureLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                profilePictureLabel.setIcon(scaledImageIcon);
            }
            

        }

        if (e.getSource() == backButton){
            new Dashboard(user);
            frame.setVisible(false);
        }

    }

}