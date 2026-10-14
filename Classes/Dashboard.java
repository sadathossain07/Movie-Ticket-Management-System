package Classes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import MovieClass.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Dashboard extends Details implements ActionListener{
    private JFrame frame;
    private JButton profilebtn,logoutbtn,backslider,forwordslider,searchButton;
    private JButton ticketViewButton,upcomingButton,noticeButton,supporButton;
    JLabel background,sliderspace,search;
    JButton movie1name,movie2name,movie3name,movie4name;
    JLabel movie1,movie2,movie3,movie4;
    JButton title;
    JTextField searchField;
    JPanel panel1,panel2,panel3,panel4;
    String user;
    MovieDetails movieDetails;
    ImageIcon sliderImage[];
    ImageIcon movieImage[];



    public Dashboard(String username){

        user =username;

        frame = new JFrame("DashBoard");
        profilebtn = new  JButton(findDetails(1,username));
        logoutbtn = new  JButton("Logout");
        searchButton = new  JButton("Search");
        background = new JLabel(new ImageIcon("Images/DashboardBackGround.png"));
        sliderspace = new JLabel();
        search = new JLabel("Search");
        searchField = new JTextField();
        title = new JButton("CINEHUB");
        backslider = new JButton("<<");
        forwordslider = new JButton(">>");
        ticketViewButton = new JButton("Your Ticket");
        upcomingButton = new JButton("Upcoming Movies");
        noticeButton = new JButton("Notice");
        supporButton = new JButton("Support");
        movieDetails = new MovieDetails();
        movie1name = new JButton(movieDetails.findMovieName(1));
        movie2name = new JButton(movieDetails.findMovieName(2));
        movie3name = new JButton(movieDetails.findMovieName(3));
        movie4name = new JButton(movieDetails.findMovieName(4));
        movie1 = new JLabel();
        movie2 = new JLabel();
        movie3 = new JLabel();
        movie4 = new JLabel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        

        profilebtn.setBounds(870, 25, profilebtn.getPreferredSize().width, 40);
        logoutbtn.setBounds(20, 290,100,40);
        background.setBounds(0, 0, 1000, 700);
        title.setBounds(20, 20, 200, 50);
        panel1.setBounds(0, 2, 1000, 80);
        panel2.setBounds(0, 100, 150, 540);
        panel3.setBounds(180, 100, 805, 350);
        panel4.setBounds(180, 470, 805, 170);
        sliderspace.setBounds(220, 120, 730, 300);
        backslider.setBounds(-10, 90, 60, 40);
        forwordslider.setBounds(680, 90, 60, 40);
        search.setBounds(280, 20, 100, 50);
        searchField.setBounds(350, 27, 330, 40);
        searchButton.setBounds(685, 27, 60, 40);
        ticketViewButton.setBounds(05, 150, 140, 40);
        upcomingButton.setBounds(05, 220, 140, 40);
        noticeButton.setBounds(05, 290, 140, 40);
        supporButton.setBounds(05, 360, 140, 40);
        movie1.setBounds(210, 480, 160, 120);
        movie2.setBounds(405, 480, 160, 120);
        movie3.setBounds(600, 480, 160, 120);
        movie4.setBounds(795, 480, 160, 120);
        movie1name.setBounds(205, 600, 160, 40);
        movie2name.setBounds(400, 600, 160, 40);
        movie3name.setBounds(595, 600, 160, 40);
        movie4name.setBounds(790, 600, 160, 40);

        
        Font font = title.getFont();
        int fontSize = font.getSize() + 15; // Increase font size by 5
        Font newFont = new Font("serif", font.getStyle(), fontSize);
        
        title.setFont(newFont);
        

        search.setForeground(Color.white);
        search.setFont(new Font("serif",Font.PLAIN,20));


        panel1.setBackground(new Color(0,0,0,140));
        panel2.setBackground(new Color(0,0,0,140));
        panel3.setBackground(new Color(0,0,0,120));
        panel4.setBackground(new Color(0,0,0,120));

        
        profilebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilebtn.setForeground(new Color(211,211,211));
		profilebtn.setFont(new Font("serif",Font.PLAIN,25));
        profilebtn.setBorder(BorderFactory.createEmptyBorder());
        profilebtn.setContentAreaFilled(false);
		profilebtn.setFocusPainted(false);

        logoutbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutbtn.setForeground(new Color(211,211,211));
		logoutbtn.setFont(new Font("serif",Font.PLAIN,22));
        logoutbtn.setBorder(BorderFactory.createEmptyBorder());
        logoutbtn.setContentAreaFilled(false);
		logoutbtn.setFocusPainted(false);

        title.setCursor(new Cursor(Cursor.HAND_CURSOR));
        title.setForeground(Color.RED);
        title.setBorder(BorderFactory.createEmptyBorder());
        title.setContentAreaFilled(false);
		title.setFocusPainted(false);

        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchButton.setFont(new Font("serif",Font.PLAIN,15));


        ticketViewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ticketViewButton.setForeground(new Color(211,211,211));
		ticketViewButton.setFont(new Font("serif",Font.PLAIN,22));
        ticketViewButton.setBorder(BorderFactory.createEmptyBorder());
        ticketViewButton.setContentAreaFilled(false);
		ticketViewButton.setFocusPainted(false);

        upcomingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        upcomingButton.setForeground(new Color(211,211,211));
		upcomingButton.setFont(new Font("serif",Font.PLAIN,17));
        upcomingButton.setBorder(BorderFactory.createEmptyBorder());
        upcomingButton.setContentAreaFilled(false);
		upcomingButton.setFocusPainted(false);

        noticeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        noticeButton.setForeground(new Color(211,211,211));
		noticeButton.setFont(new Font("serif",Font.PLAIN,20));
        noticeButton.setBorder(BorderFactory.createEmptyBorder());
        noticeButton.setContentAreaFilled(false);
		noticeButton.setFocusPainted(false);

        supporButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        supporButton.setForeground(new Color(211,211,211));
		supporButton.setFont(new Font("serif",Font.PLAIN,20));
        supporButton.setBorder(BorderFactory.createEmptyBorder());
        supporButton.setContentAreaFilled(false);
		supporButton.setFocusPainted(false);

        movie1name.setCursor(new Cursor(Cursor.HAND_CURSOR));
        movie1name.setForeground(new Color(211,211,211));
		movie1name.setFont(new Font("serif",Font.PLAIN,20));
        movie1name.setBorder(BorderFactory.createEmptyBorder());
        movie1name.setContentAreaFilled(false);
		movie1name.setFocusPainted(false);

        movie2name.setCursor(new Cursor(Cursor.HAND_CURSOR));
        movie2name.setForeground(new Color(211,211,211));
		movie2name.setFont(new Font("serif",Font.PLAIN,20));
        movie2name.setBorder(BorderFactory.createEmptyBorder());
        movie2name.setContentAreaFilled(false);
		movie2name.setFocusPainted(false);

        movie3name.setCursor(new Cursor(Cursor.HAND_CURSOR));
        movie3name.setForeground(new Color(211,211,211));
		movie3name.setFont(new Font("serif",Font.PLAIN,20));
        movie3name.setBorder(BorderFactory.createEmptyBorder());
        movie3name.setContentAreaFilled(false);
		movie3name.setFocusPainted(false);
        
        movie4name.setCursor(new Cursor(Cursor.HAND_CURSOR));
        movie4name.setForeground(new Color(211,211,211));
		movie4name.setFont(new Font("serif",Font.PLAIN,20));
        movie4name.setBorder(BorderFactory.createEmptyBorder());
        movie4name.setContentAreaFilled(false);
		movie4name.setFocusPainted(false);

        
        sliderImage = new ImageIcon[4]; 
        sliderImage[0] = new ImageIcon(movieDetails.findSliderPath(1));
        sliderImage[1] = new ImageIcon(movieDetails.findSliderPath(2));
        sliderImage[2] = new ImageIcon(movieDetails.findSliderPath(3));
        sliderImage[3] = new ImageIcon(movieDetails.findSliderPath(4));
        sliderspace.setIcon(imageResize(0,sliderspace,sliderImage));

        int delay = 2500; // 3.5 seconds
        Timer timer = new Timer(delay, new ActionListener() {
            int i = 0;
            public void actionPerformed(ActionEvent e) {
                i = (i + 1) % sliderImage.length;
                sliderspace.setIcon(imageResize(i, sliderspace, sliderImage));
                
            }
        });
        timer.start();



        movieImage = new ImageIcon[4];
        movieImage[0] = new ImageIcon(movieDetails.findMoviePath(1));
        movieImage[1] = new ImageIcon(movieDetails.findMoviePath(2));
        movieImage[2] = new ImageIcon(movieDetails.findMoviePath(3));
        movieImage[3] = new ImageIcon(movieDetails.findMoviePath(4));

        movie1.setIcon(imageResize(0, movie1, movieImage));
        movie2.setIcon(imageResize(1, movie2, movieImage));
        movie3.setIcon(imageResize(2, movie3, movieImage));
        movie4.setIcon(imageResize(3, movie4, movieImage));


        background.add(profilebtn);
        background.add(logoutbtn);
        background.add(title);
        background.add(search);
        background.add(searchField);
        background.add(searchButton);
        background.add(ticketViewButton);
        background.add(upcomingButton);
        // background.add(noticeButton);
        // background.add(supporButton);
        background.add(movie1name);
        background.add(movie2name);
        background.add(movie3name);
        background.add(movie4name);
        background.add(movie1);
        background.add(movie2);
        background.add(movie3);
        background.add(movie4);
        background.add(panel1);
        background.add(panel2);
        background.add(sliderspace);
        background.add(panel3);
        background.add(panel4);
        
        
        sliderspace.add(backslider);
        sliderspace.add(forwordslider);


        frame.add(background);

        logoutbtn.addActionListener(this);
        profilebtn.addActionListener(this);
        backslider.addActionListener(this);
        forwordslider.addActionListener(this);
        title.addActionListener(this);
        ticketViewButton.addActionListener(this);
        upcomingButton.addActionListener(this);
        noticeButton.addActionListener(this);
        supporButton.addActionListener(this);
        movie1name.addActionListener(this);
        movie2name.addActionListener(this);
        movie3name.addActionListener(this);
        movie4name.addActionListener(this);
        searchButton.addActionListener(this);

        frame.setSize(1000, 700);        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }



    private static int i=0;
    public void actionPerformed(ActionEvent e) {

       if(e.getSource()==logoutbtn){
            int check = JOptionPane.showOptionDialog(null, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{ "Yes","No"}, null);
            if(check == JOptionPane.YES_OPTION){
                new SignIn();
                frame.setVisible(false);
            }
            else{

            }
       }
       else if(e.getSource()==profilebtn){
            new Profile(user);
            frame.setVisible(false);


       }

        else if(e.getSource()==backslider){
         
            if(i==0){
                i=3;
                sliderspace.setIcon(imageResize(i,sliderspace,sliderImage));
            }
            
            else{
                i--;
                sliderspace.setIcon(imageResize(i,sliderspace,sliderImage));
            }
                
                
        }

        else if(e.getSource()==forwordslider){
            if(i==3){
                i=0;
                sliderspace.setIcon(imageResize(i,sliderspace,sliderImage));
            }
            else{
                i++;
                sliderspace.setIcon(imageResize(i,sliderspace,sliderImage));
            }
            
            
        }

        else if(e.getSource()==title){
            new Dashboard(user);
            frame.setVisible(false);
        }

        else if(e.getSource()==movie1name){
            new Movie1(movie1name.getText(),user);
            frame.setVisible(false);
        }

        else if(e.getSource()==movie2name){
            new Movie2(movie2name.getText(),user);
            frame.setVisible(false);
        }

        else if(e.getSource()==movie3name){
            new Movie3(movie3name.getText(),user);
            frame.setVisible(false);
        }

        else if(e.getSource()==movie4name){
            new Movie4(movie4name.getText(),user);
            frame.setVisible(false);
        }

        else if(e.getSource()==ticketViewButton){
            new TicketView(user);
            frame.setVisible(false);

        }

        else if(e.getSource()==searchButton){
            if(searchField.getText().equals(movie1name.getText())){
                new Movie1(movie1name.getText(),user);
                frame.setVisible(false);
            }
            else if(searchField.getText().equals(movie2name.getText())){
                new Movie2(movie2name.getText(),user);
                frame.setVisible(false);
            }
            else if(searchField.getText().equals(movie3name.getText())){
                new Movie3(movie3name.getText(),user);
                frame.setVisible(false);
            }
            else if(searchField.getText().equals(movie4name.getText())){
                new Movie4(movie4name.getText(),user);
                frame.setVisible(false);
            }
            else{
                showMessageDialog(null,"No Movie Found");
            }

        }

        else if(e.getSource()==upcomingButton){
            new MovieRelaseUpdate(user);
            frame.setVisible(false);
        }
       
       
    }

    public ImageIcon imageResize(int imagenumber,JLabel a,ImageIcon b[]){
        Image image = b[imagenumber].getImage();
        Image scaledImage = image.getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

                return scaledImageIcon;
        
    }


    
}
