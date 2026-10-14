package MovieClass;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

import javax.swing.*;

import Classes.Dashboard;
import Classes.TicketView;



public class Payment extends MovieDetails implements ActionListener {
    
    private JFrame frame;
    private JButton title;
    JPanel panel1,panel2;
    JLabel background,moviedetailsJLabel,movienameJLabel,showTimeJLabel,ticketPriceJLabel,supportJLabel;
    private JLabel nameLabel, cardNumberLabel, expiryDateLabel, cvvLabel;
    private JTextField nameField, cardNumberField, expiryDateField, cvvField;
    private JButton payButton,cancelButton;

    ImageIcon movie;
    String user;
    String moviename,price,showTime;
    int quantity;

    public Payment(String moviename,String user,String price,String showTime,int quantity){
       
      
       this.user = user;
       this.moviename = moviename;
       this.price = price;
       this.showTime = showTime;
       this.quantity = quantity;

       frame = new JFrame(moviename);
       title = new JButton("CINEHUB");
       background = new JLabel(new ImageIcon("Images/userbg.jpg"));
       supportJLabel = new JLabel("Now We are Accepting MasterCard only");
    //    moviepicLabel = new JLabel();
    //    movieNameButton = new JButton(super.findMovieName(1));
       movienameJLabel = new JLabel("Name : "+moviename);
    //    ratingJLabel = new JLabel("IMDB Rating : "+super.findMovieRating(1));
    //    genreJLabel = new JLabel("Genre : "+super.findMovieGenre(1));
       showTimeJLabel = new JLabel("ShowTime : "+showTime);
       ticketPriceJLabel = new JLabel("Ticket Price : "+price+" Tk");
    //    buyJButton = new JButton("Buy Ticket");
       moviedetailsJLabel = new JLabel("Selected Movie");
    nameLabel = new JLabel("Name on Card:");
    nameField = new JTextField();
    cardNumberLabel = new JLabel("Card Number:");
    cardNumberField = new JTextField();
    expiryDateLabel = new JLabel("Expiry Date (MM/YY):");
    expiryDateField = new JTextField();
    cvvLabel = new JLabel("CVV:");
    cvvField = new JTextField(); 
    payButton = new JButton("Pay Now");
    cancelButton = new JButton("Cancel");
       panel1 = new JPanel();
       panel2 = new JPanel();
       


       title.setBounds(20, 20, 200, 50);
       moviedetailsJLabel.setBounds(420, 140, 200, 40);
    //    moviepicLabel.setBounds(220, 160, 200, 230);
    //    movieNameButton.setBounds(250,400,140,40);
       movienameJLabel.setBounds(270, 200, 350, 40);
    //    ratingJLabel.setBounds(480, 210, 350, 40);
    //    genreJLabel.setBounds(480, 260, 350, 40);
       showTimeJLabel.setBounds(270, 250, 350, 40);
       ticketPriceJLabel.setBounds(270, 300, 350, 40);
       supportJLabel.setBounds(300, 360, 350, 40);
    //    buyJButton.setBounds(450, 500, 120, 40);
        nameLabel.setBounds(270, 420, 160, 30);
        nameField.setBounds(400, 420, 220, 30);
        cardNumberLabel.setBounds(270, 470, 160, 30);
        cardNumberField.setBounds(400, 470, 220, 30);
        expiryDateLabel.setBounds(270, 520, 160, 30);
        expiryDateField.setBounds(420, 520, 80, 30);
        cvvLabel.setBounds(505, 520, 80, 30);
        cvvField.setBounds(540, 520, 80, 30);
        payButton.setBounds(540, 570, 80, 40);
        cancelButton.setBounds(400, 570, 80, 40);

       panel1.setBounds(0, 2, 1000, 80);
       panel2.setBounds(150, 100, 700, 540);
       background.setBounds(0, 0, 1000, 700);

       panel1.setBackground(new Color(0,0,0,140));
       panel2.setBackground(new Color(0,0,0,140));

    //    movieNameButton.setForeground(new Color(211,211,211));
    //    movieNameButton.setFont(new Font("serif",Font.PLAIN,20));
    //    movieNameButton.setBorder(BorderFactory.createEmptyBorder());
    //    movieNameButton.setContentAreaFilled(false);
    //    movieNameButton.setFocusPainted(false);
       
    //    buyJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    //    buyJButton.setFont(new Font("serif",Font.PLAIN,20));

       movienameJLabel.setForeground(new Color(211,211,211));
       movienameJLabel.setFont(new Font("serif",Font.PLAIN,23));

    //    ratingJLabel.setForeground(new Color(211,211,211));
    //    ratingJLabel.setFont(new Font("serif",Font.PLAIN,23));

    //    genreJLabel.setForeground(new Color(211,211,211));
    //    genreJLabel.setFont(new Font("serif",Font.PLAIN,20));

       showTimeJLabel.setForeground(new Color(211,211,211));
       showTimeJLabel.setFont(new Font("serif",Font.PLAIN,20));

       ticketPriceJLabel.setForeground(new Color(211,211,211));
       ticketPriceJLabel.setFont(new Font("serif",Font.PLAIN,23));

         moviedetailsJLabel.setForeground(new Color(211,211,211));
         moviedetailsJLabel.setFont(new Font("serif",Font.PLAIN,25));

         nameLabel.setForeground(new Color(211,211,211));
         nameLabel.setFont(new Font("serif",Font.PLAIN,20));

         cardNumberLabel.setForeground(new Color(211,211,211));
         cardNumberLabel.setFont(new Font("serif",Font.PLAIN,20));

         expiryDateLabel.setForeground(new Color(211,211,211));
         expiryDateLabel.setFont(new Font("serif",Font.PLAIN,15));

         cvvLabel.setForeground(new Color(211,211,211));
         cvvLabel.setFont(new Font("serif",Font.PLAIN,15));

         supportJLabel.setForeground(Color.red);
         supportJLabel.setFont(new Font("serif",Font.PLAIN,20));

         cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         payButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

       

       Font font = title.getFont();
       int fontSize = font.getSize() + 15; // Increase font size by 5
       Font newFont = new Font("serif", font.getStyle(), fontSize);
        
        title.setFont(newFont);

        title.setCursor(new Cursor(Cursor.HAND_CURSOR));
        title.setForeground(Color.RED);
        title.setBorder(BorderFactory.createEmptyBorder());
        title.setContentAreaFilled(false);
		title.setFocusPainted(false);

        // movie = new ImageIcon(super.findMoviePath(1));
        // moviepicLabel.setIcon(imageResize(moviepicLabel, movie));



        title.addActionListener(this);
        cancelButton.addActionListener(this);
        payButton.addActionListener(this);
        // buyJButton.addActionListener(this);


        background.add(title);
        background.add(moviedetailsJLabel);
        
        // background.add(moviepicLabel);
        // background.add(movieNameButton);
        background.add(movienameJLabel);
        // background.add(ratingJLabel);
        // background.add(genreJLabel);
        background.add(showTimeJLabel);
        background.add(ticketPriceJLabel);
        background.add(nameLabel);
        background.add(nameField);
        background.add(cardNumberLabel);
        background. add(cardNumberField);
        background.add(expiryDateLabel);
        background.add(expiryDateField);
        background.add(cvvLabel);
        background.add(cvvField);
        background.add(payButton);
        background.add(cancelButton);
        background.add(supportJLabel);
        // background.add(buyJButton);
        background.add(panel1);
        background.add(panel2);

        frame.add(background);

        frame.setSize(1000, 700);        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    

    public void actionPerformed(ActionEvent e) {

        int value;
            try {
                 value = Integer.parseInt(cardNumberField.getText());
                // use the integer value here
            } catch (NumberFormatException ex) {
                value = -1;
            }

        if(e.getSource()==title){
            int check = JOptionPane.showOptionDialog(null, "You Payment will be Cancel.\n Are you sure?", "Payment Cancel Alert", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{ "Yes","NO"}, null);
            if(check == JOptionPane.YES_OPTION){
               new Dashboard(user);
               frame.setVisible(false);
            }
            else{
               
            }

        }

        else if(e.getSource()==cancelButton){
            new Dashboard(user);
            frame.setVisible(false);
        }

        else if(e.getSource()==payButton){
            

            if(nameField.getText().isEmpty()||cardNumberField.getText().isEmpty()||expiryDateField.getText().isEmpty()||cvvField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Fill the Details Correctly");
            }
            
            else if(cardNumberField.getText().length()!=16){
                JOptionPane.showMessageDialog(null,"Wrong Card number");
            }
            else{
                  
                try { 
                    String username = user.substring("UserName:".length());
                    File file = new File("files/TicketView.txt");
                    Random rand = new Random();
                    int num = rand.nextInt(900000) + 100000; 
                    // String path = "files/TicketView.txt";
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    try (PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                        printWriter.println("====================");
                        printWriter.println("Username:"+username);
                        printWriter.println("TicketNumber:"+num);
                        printWriter.println("Movie Name:"+moviename);
                        printWriter.println("ShowTime:"+showTime);
                        printWriter.println("Quantity:"+quantity);
                        printWriter.println("TicketPrice:"+price);
                        printWriter.println("====================");
                        JOptionPane.showMessageDialog(null,"Payment Succesful.\n Redirecting to Your Ticket.");
                        new TicketView(user);
                        frame.setVisible(false);
                    }

                    

                   

                }
                catch(Exception ex){

                }
                
                    

                 


            }
        }


    }

    


    public ImageIcon imageResize(JLabel a,ImageIcon movie){
        Image image = movie.getImage();
        Image scaledImage = image.getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

                return scaledImageIcon;
        
    }


}
