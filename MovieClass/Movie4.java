package MovieClass;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
import Classes.Dashboard;

public class Movie4 extends MovieDetails implements ActionListener {

    private JFrame frame;
    private JButton title,movieNameButton,buyJButton;
    JPanel panel1,panel2;
    JLabel background,moviepicLabel,movienameJLabel,ratingJLabel,genreJLabel,showTimeJLabel,ticketPriceJLabel,quantityJLabel;
    JTextField quanTextField;
    ImageIcon movie;
    String user;

    public Movie4(String moviename,String user){

        this.user = user;

       frame = new JFrame(moviename);
       title = new JButton("CINEHUB");
       background = new JLabel(new ImageIcon("Images/userbg.jpg"));
       moviepicLabel = new JLabel();
       movieNameButton = new JButton(super.findMovieName(4));
       movienameJLabel = new JLabel("Name : "+super.findMovieName(4));
       ratingJLabel = new JLabel("IMDB Rating : "+super.findMovieRating(4));
       genreJLabel = new JLabel("Genre : "+super.findMovieGenre(4));
       showTimeJLabel = new JLabel("ShowTime : "+super.findMovieYear(4));
       ticketPriceJLabel = new JLabel("Ticket Price : "+super.findMoviePrice(4)+" Tk");
       quantityJLabel =new JLabel("Ticket Quantity : ");
       quanTextField = new JTextField();
       buyJButton = new JButton("Buy Ticket");
       panel1 = new JPanel();
       panel2 = new JPanel();
       


       title.setBounds(20, 20, 200, 50);
       moviepicLabel.setBounds(220, 160, 200, 230);
       movieNameButton.setBounds(250,400,140,40);
       movienameJLabel.setBounds(480, 160, 350, 40);
       ratingJLabel.setBounds(480, 210, 350, 40);
       genreJLabel.setBounds(480, 260, 350, 40);
       showTimeJLabel.setBounds(480, 310, 350, 40);
       ticketPriceJLabel.setBounds(480, 360, 350, 40);
       quantityJLabel.setBounds(480, 410, 350, 40);
       quanTextField.setBounds(640, 410, 50, 40);
       buyJButton.setBounds(450, 500, 120, 40);
       panel1.setBounds(0, 2, 1000, 80);
       panel2.setBounds(150, 100, 700, 540);
       background.setBounds(0, 0, 1000, 700);

       panel1.setBackground(new Color(0,0,0,140));
       panel2.setBackground(new Color(0,0,0,140));

       quanTextField.setForeground(Color.WHITE);
       quanTextField.setBackground(new Color(0,0,0,220));
       quanTextField.setBorder(BorderFactory.createEmptyBorder());
       quanTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
       quanTextField.setFont(new Font("serif",Font.PLAIN,20));

       movieNameButton.setForeground(new Color(211,211,211));
       movieNameButton.setFont(new Font("serif",Font.PLAIN,20));
       movieNameButton.setBorder(BorderFactory.createEmptyBorder());
       movieNameButton.setContentAreaFilled(false);
       movieNameButton.setFocusPainted(false);
       
       buyJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
       buyJButton.setFont(new Font("serif",Font.PLAIN,20));

       movienameJLabel.setForeground(new Color(211,211,211));
       movienameJLabel.setFont(new Font("serif",Font.PLAIN,23));

       ratingJLabel.setForeground(new Color(211,211,211));
       ratingJLabel.setFont(new Font("serif",Font.PLAIN,23));

       genreJLabel.setForeground(new Color(211,211,211));
       genreJLabel.setFont(new Font("serif",Font.PLAIN,20));

       showTimeJLabel.setForeground(new Color(211,211,211));
       showTimeJLabel.setFont(new Font("serif",Font.PLAIN,20));

       ticketPriceJLabel.setForeground(new Color(211,211,211));
       ticketPriceJLabel.setFont(new Font("serif",Font.PLAIN,23));

       quantityJLabel.setForeground(new Color(211,211,211));
       quantityJLabel.setFont(new Font("serif",Font.PLAIN,23));

       Font font = title.getFont();
       int fontSize = font.getSize() + 15; // Increase font size by 5
       Font newFont = new Font("serif", font.getStyle(), fontSize);
        
        title.setFont(newFont);

        title.setCursor(new Cursor(Cursor.HAND_CURSOR));
        title.setForeground(Color.RED);
        title.setBorder(BorderFactory.createEmptyBorder());
        title.setContentAreaFilled(false);
		title.setFocusPainted(false);

        movie = new ImageIcon(super.findMoviePath(4));
        moviepicLabel.setIcon(imageResize(moviepicLabel, movie));



        title.addActionListener(this);
        buyJButton.addActionListener(this);


        background.add(title);
        background.add(moviepicLabel);
        background.add(movieNameButton);
        background.add(movienameJLabel);
        background.add(ratingJLabel);
        background.add(genreJLabel);
        background.add(showTimeJLabel);
        background.add(ticketPriceJLabel);
        background.add(quantityJLabel);
        background.add(quanTextField);
        background.add(buyJButton);
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
        if(e.getSource()==title){
            new Dashboard(user);
            frame.setVisible(false);

        }
        else if(e.getSource()== buyJButton){
            if(quanTextField.getText().isEmpty()){
                showMessageDialog(null,"Please Enter Your Ticket Quantity.");
           }
           try{
               int value = Integer.parseInt(quanTextField.getText());
               int value2 = Integer.parseInt(super.findMoviePrice(4));
               String totalprice = String.valueOf(value*value2);

               if(value<=4){
                   new Payment(super.findMovieName(4), user, totalprice, super.findMovieYear(4),value);
                   frame.setVisible(false);
               }
               else if(value>4){
                   showMessageDialog(null,"Maximum Quantity is 4.");

               }


           }
           catch(Exception ex){
               if(quanTextField.getText().isEmpty()==false){
                   showMessageDialog(null, "Please Enter only number.");

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
