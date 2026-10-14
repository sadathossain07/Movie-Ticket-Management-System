package MovieClass;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

import Classes.AdminDashBoard;


public class MovieUpdate extends MovieDetails implements ActionListener {
    
    private JFrame frame;
    private JButton title,saveButton;
    private JRadioButton radio1Button,radio2Button,radio3Button,radio4Button;
    private JLabel radio1movie,radio2movie,radio3movie,radio4movie;
    private JButton movie1upload;
    private JTextField movie1name,priceTextField,genreTextField,yearTextField,ratingTextField;
    private JLabel movie1,rating,price,year,genre;
    private JLabel movie1nametext;
    JPanel panel1,panel2;
    JLabel background;
    MovieDetails movieDetails;
    String user;

    public MovieUpdate(String User){

      user = User;
       
       
       frame = new JFrame();
       title = new JButton("CINEHUB");
       background = new JLabel(new ImageIcon("Images/userbg.jpg"));
       radio1Button = new JRadioButton();
       radio2Button = new JRadioButton();
       radio3Button = new JRadioButton();
       radio4Button = new JRadioButton();
       radio1movie = new JLabel("Movie 1");
       radio2movie = new JLabel("Movie 2");
       radio3movie = new JLabel("Movie 3");
       radio4movie = new JLabel("Movie 4");
       movie1upload = new JButton("Upload");
       movie1 = new JLabel("Change Picture");
       movie1name = new JTextField();
       ratingTextField = new JTextField();
       priceTextField = new JTextField();
       yearTextField = new JTextField();
       genreTextField = new JTextField();
       movie1nametext = new JLabel("Change Name");
       rating = new JLabel("Change Rating");
       price = new JLabel("Change Price");
       genre = new JLabel("Change Genre");
       year = new JLabel("ShowTime");
       saveButton = new JButton("Edit");
       movieDetails = new MovieDetails();
       panel1 = new JPanel();
       panel2 = new JPanel();
       


       title.setBounds(20, 20, 200, 50);
       radio1Button.setBounds(160, 170, 40, 20);
       radio2Button.setBounds(320, 170, 40, 20);
       radio3Button.setBounds(480, 170, 40, 20);
       radio4Button.setBounds(640, 170, 40, 20);
       radio1movie.setBounds(200, 170, 100, 20);
       radio2movie.setBounds(360, 170, 100, 20);
       radio3movie.setBounds(520, 170, 100, 20);
       radio4movie.setBounds(680, 170, 100, 20);
       movie1upload.setBounds(330,310,80,40);
       movie1.setBounds(220,310,140,40);
       movie1name.setBounds(320,250,200,30);
       movie1nametext.setBounds(220,250,140,30);
       rating.setBounds(220,370,140,30);
       genre.setBounds(220,430,140,30);
       price.setBounds(220,490,140,30);
       year.setBounds(220,550,140,30);
       ratingTextField.setBounds(320,370,200,30);
       genreTextField.setBounds(320,430,200,30);
       priceTextField.setBounds(320,490,200,30);
       yearTextField.setBounds(320,550,200,30);
       saveButton.setBounds(600,370,80,40);
       panel1.setBounds(0, 2, 1000, 80);
       panel2.setBounds(100, 100, 800, 540);
       background.setBounds(0, 0, 1000, 700);


       panel1.setBackground(new Color(0,0,0,140));
       panel2.setBackground(new Color(0,0,0,140));

       movie1.setForeground(Color.white);
       movie1nametext.setForeground(Color.white);
    

       movie1.setFont(new Font("serif",Font.PLAIN,15));
       movie1nametext.setFont(new Font("serif",Font.PLAIN,15));
       radio1movie.setForeground(Color.white);
       radio2movie.setForeground(Color.white);
       radio3movie.setForeground(Color.white);
       radio4movie.setForeground(Color.white);
       rating.setForeground(Color.white);
       genre.setForeground(Color.white);
       price.setForeground(Color.white);
       year.setForeground(Color.white);

       radio1movie.setFont(new Font("serif",Font.PLAIN,18));
       radio2movie.setFont(new Font("serif",Font.PLAIN,18));
       radio3movie.setFont(new Font("serif",Font.PLAIN,18));
       radio4movie.setFont(new Font("serif",Font.PLAIN,18));
   
       

       Font font = title.getFont();
       int fontSize = font.getSize() + 15; // Increase font size by 5
       Font newFont = new Font("serif", font.getStyle(), fontSize);
        
        title.setFont(newFont);

        title.setCursor(new Cursor(Cursor.HAND_CURSOR));
        title.setForeground(Color.RED);
        title.setBorder(BorderFactory.createEmptyBorder());
        title.setContentAreaFilled(false);
	 	  title.setFocusPainted(false);

        movie1upload.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
   



        title.addActionListener(this);
        movie1upload.addActionListener(this);
        saveButton.addActionListener(this);
        radio1Button.addActionListener(this);
        radio2Button.addActionListener(this);
        radio3Button.addActionListener(this);
        radio4Button.addActionListener(this);

        genreTextField.setEditable(false);
        priceTextField.setEditable(false);
        movie1name.setEditable(false);
        yearTextField.setEditable(false);
        priceTextField.setEditable(false);
        ratingTextField.setEditable(false);





       
         background.add(title);
         background.add(radio1Button);
         background.add(radio2Button);
         background.add(radio3Button);
         background.add(radio4Button);
         background.add(radio1movie);
         background.add(radio2movie);
         background.add(radio3movie);
         background.add(radio4movie);
         background.add(movie1upload);
         background.add(movie1);
         background.add(rating);
         background.add(price);
         background.add(genre);
         background.add(year);
         background.add(ratingTextField);
         background.add(priceTextField);
         background.add(genreTextField);
         background.add(yearTextField);
         background.add(saveButton);
       
        background.add(movie1name);
        
        background.add(movie1nametext);
 
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
            new AdminDashBoard(user);
            
        }

        else if(e.getSource()==radio1Button){
            if(radio1Button.isSelected()){
               radio2Button.setSelected(false);
               radio3Button.setSelected(false);
               radio4Button.setSelected(false);

               genreTextField.setEditable(false);
               priceTextField.setEditable(false);
               movie1name.setEditable(false);
               yearTextField.setEditable(false);
               ratingTextField.setEditable(false);

               movie1name.setText(movieDetails.findMovieName(1));
               ratingTextField.setText(movieDetails.findMovieRating(1));
               genreTextField.setText(movieDetails.findMovieGenre(1));
               priceTextField.setText(movieDetails.findMoviePrice(1));
               yearTextField.setText(movieDetails.findMovieYear(1));

            }

            else if(radio1Button.isSelected()==false){
               movie1name.setText("");
               ratingTextField.setText("");
               genreTextField.setText("");
               priceTextField.setText("");
               yearTextField.setText("");
            }
        }

        else if(e.getSource()==radio2Button){
            if(radio2Button.isSelected()){
               radio1Button.setSelected(false);
               radio3Button.setSelected(false);
               radio4Button.setSelected(false);

               genreTextField.setEditable(false);
               priceTextField.setEditable(false);
               movie1name.setEditable(false);
               yearTextField.setEditable(false);
               ratingTextField.setEditable(false);

               movie1name.setText(movieDetails.findMovieName(2));
               ratingTextField.setText(movieDetails.findMovieRating(2));
               genreTextField.setText(movieDetails.findMovieGenre(2));
               priceTextField.setText(movieDetails.findMoviePrice(2));
               yearTextField.setText(movieDetails.findMovieYear(2));
            }

            else if(radio1Button.isSelected()==false){
               movie1name.setText("");
               ratingTextField.setText("");
               genreTextField.setText("");
               priceTextField.setText("");
               yearTextField.setText("");
            }
        }

        else if(e.getSource()==radio3Button){
            if(radio3Button.isSelected()){
               radio1Button.setSelected(false);
               radio2Button.setSelected(false);
               radio4Button.setSelected(false);

               genreTextField.setEditable(false);
               priceTextField.setEditable(false);
               movie1name.setEditable(false);
               yearTextField.setEditable(false);
               ratingTextField.setEditable(false);

               movie1name.setText(movieDetails.findMovieName(3));
               ratingTextField.setText(movieDetails.findMovieRating(3));
               genreTextField.setText(movieDetails.findMovieGenre(3));
               priceTextField.setText(movieDetails.findMoviePrice(3));
               yearTextField.setText(movieDetails.findMovieYear(3));
            }

            else if(radio1Button.isSelected()==false){
               movie1name.setText("");
               ratingTextField.setText("");
               genreTextField.setText("");
               priceTextField.setText("");
               yearTextField.setText("");
            }
         }

         else if(e.getSource()==radio4Button){
            if(radio4Button.isSelected()){
               radio1Button.setSelected(false);
               radio2Button.setSelected(false);
               radio3Button.setSelected(false);

               genreTextField.setEditable(false);
               priceTextField.setEditable(false);
               movie1name.setEditable(false);
               yearTextField.setEditable(false);
               ratingTextField.setEditable(false);

               movie1name.setText(movieDetails.findMovieName(4));
               ratingTextField.setText(movieDetails.findMovieRating(4));
               genreTextField.setText(movieDetails.findMovieGenre(4));
               priceTextField.setText(movieDetails.findMoviePrice(4));
               yearTextField.setText(movieDetails.findMovieYear(1));
            }

            else if(radio1Button.isSelected()==false){
               movie1name.setText("");
               ratingTextField.setText("");
               genreTextField.setText("");
               priceTextField.setText("");
               yearTextField.setText("");
            }
         }

        

        else if (e.getSource() == saveButton) {

         if (saveButton.getText().equals("Edit")) {

             genreTextField.setEditable(true);
             movie1name.setEditable(true);
             yearTextField.setEditable(true);
             priceTextField.setEditable(true);
             ratingTextField.setEditable(true);
             




             saveButton.setText("Save");

         } else if (saveButton.getText().equals("Save")) {
                 

             if ((genreTextField.getText().isEmpty()==false) && (priceTextField.getText().isEmpty()==false) && (ratingTextField.getText().isEmpty()==false) && (yearTextField.getText().isEmpty()==false) && (radio1Button.isSelected()||radio1Button.isSelected()||radio2Button.isSelected()||radio3Button.isSelected()||radio4Button.isSelected())) {

               if(radio1Button.isSelected()){

                  movieDetails.changeMovieName(1, movie1name.getText());
                  movieDetails.changeMovieRating(1, ratingTextField.getText());
                  movieDetails.changeMoviePrice(1, priceTextField.getText());
                  movieDetails.changeMovieGenre(1, genreTextField.getText());
                  movieDetails.changeMovieYear(1, yearTextField.getText());
                  showMessageDialog(null, "Succesfully Updated.");

               }
               else if(radio2Button.isSelected()){
                  movieDetails.changeMovieName(2, movie1name.getText());
                  movieDetails.changeMovieRating(2, ratingTextField.getText());
                  movieDetails.changeMoviePrice(2, priceTextField.getText());
                  movieDetails.changeMovieGenre(2, genreTextField.getText());
                  movieDetails.changeMovieYear(2, yearTextField.getText());
                  showMessageDialog(null, "Succesfully Updated.");

               }

               else if(radio3Button.isSelected()){
                  movieDetails.changeMovieName(3, movie1name.getText());
                  movieDetails.changeMovieRating(3, ratingTextField.getText());
                  movieDetails.changeMoviePrice(3, priceTextField.getText());
                  movieDetails.changeMovieGenre(3, genreTextField.getText());
                  movieDetails.changeMovieYear(3, yearTextField.getText());
                  showMessageDialog(null, "Succesfully Updated.");

               }

               else if(radio4Button.isSelected()){
                  movieDetails.changeMovieName(4, movie1name.getText());
                  movieDetails.changeMovieRating(4, ratingTextField.getText());
                  movieDetails.changeMoviePrice(4, priceTextField.getText());
                  movieDetails.changeMovieGenre(4, genreTextField.getText());
                  movieDetails.changeMovieYear(4, yearTextField.getText());
                  showMessageDialog(null, "Succesfully Updated.");

               }
               else{
                  showMessageDialog(null, "Not Updated");
               }

               
               

               

               genreTextField.setEditable(false);
               movie1name.setEditable(false);
               yearTextField.setEditable(false);
               priceTextField.setEditable(false);
               ratingTextField.setEditable(false);

               
               


               saveButton.setText("Edit");
                 

             } else {
                 showMessageDialog(null, "Not Updated");
             }

         }

     }

     if (e.getSource() == movie1upload) {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File("/Users/dipsarker/Documents/CSE/Semester2/project"));
      int result = fileChooser.showOpenDialog(frame);

      if (result == JFileChooser.APPROVE_OPTION) {
          File file = fileChooser.getSelectedFile();
          Path filePath = Paths.get(file.getAbsolutePath());

          Path destPath=Paths.get("");
          int flag = 0;
          
          if(radio1Button.isSelected()){
            destPath = Paths.get("MovieImage/Movie1/"+ file.getName());
            movieDetails.changeMoviePath(1, destPath.toString());
            flag++;

          }
          else if(radio2Button.isSelected()){
            destPath = Paths.get("MovieImage/Movie2/"+ file.getName());
            movieDetails.changeMoviePath(2, destPath.toString());
            flag++;

          }
          else if(radio3Button.isSelected()){
            destPath = Paths.get("MovieImage/Movie3/"+ file.getName());
            movieDetails.changeMoviePath(3, destPath.toString());
            flag++;

          }
          else if(radio4Button.isSelected()){
            destPath = Paths.get("MovieImage/Movie4/"+ file.getName());
            movieDetails.changeMoviePath(4, destPath.toString());
            flag++;

          }

          


          if(flag==1){
            try {
               Files.copy(filePath, destPath, StandardCopyOption.REPLACE_EXISTING);
           } catch (IOException ex) {
               ex.printStackTrace();
           }
           showMessageDialog(null,"Upload Succesful");

          }
          else{
            showMessageDialog(null,"Select the Movie First.");
            
          }

          

          
         

      }
      

  }

    }


}

