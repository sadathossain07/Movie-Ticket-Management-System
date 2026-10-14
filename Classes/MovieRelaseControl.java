package Classes;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class MovieRelaseControl implements ActionListener{
	
	JFrame Frame;
	
	private JLabel  background,adminlbl,lbl;
	private JButton backbtn, exitbtn,refresh,pageName;
	private ImageIcon Homeicon, bg;
    private JLabel moviename,RelesingDate;
    private JTextField movieTextField,relesingDateTextField;
	private JPanel panel1,panel2;

	String user;
	
	public MovieRelaseControl(String user)
	{
		this.user =user;
		
		Frame = new JFrame("Upcoming Movie Update");
		
		
		
		//LOGO
		Homeicon = new ImageIcon("images/logo.png");
		
		//PROJECT NAME
		pageName = new JButton("CINEHUB");
		pageName.setBounds(15,18,200,50);
		pageName.setForeground(new Color(255,0,0));
		pageName.setFont(new Font("serif",Font.PLAIN,35));
		pageName.setBorder(BorderFactory.createEmptyBorder());
        pageName.setContentAreaFilled(false);
		pageName.setFocusPainted(false);
		pageName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pageName.addActionListener(this);
		
		//PROJECT NAME
		adminlbl = new JLabel("Upcoming Movie");
		adminlbl.setBounds(400,18,400,40);
		adminlbl.setForeground(new Color(255,0,0));
		adminlbl.setFont(new Font("serif",Font.PLAIN,30));
		
		//PROJECT NAME
		lbl = new JLabel("Update");
		lbl.setBounds(460,110,400,40);
		lbl.setForeground(new Color(255,255,255));
		lbl.setFont(new Font("serif",Font.PLAIN,25));
		
		//REFRESH BUTTON
		refresh = new JButton("Save");
		refresh.setBounds(460,440,80,40);
		refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
		refresh.addActionListener(this);

        moviename = new JLabel("Movie Name");
        moviename.setBounds(350,250,140,30);
        moviename.setForeground(Color.white);
        moviename.setFont(new Font("serif",Font.PLAIN,18));

        movieTextField = new JTextField();
        movieTextField.setBounds(450,250,200,30);

        RelesingDate = new JLabel("Releasing Date");
        RelesingDate.setBounds(345,340,140,30);
        RelesingDate.setForeground(Color.white);
        RelesingDate.setFont(new Font("serif",Font.PLAIN,18));

        relesingDateTextField = new JTextField();
        relesingDateTextField.setBounds(450,340,200,30);

		
		
		

        String file = "files/UpcomingMovie.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
			{
                totalLines++;
			}
            reader.close();

            for (int i = 0; i < totalLines; i++){

				    
               
            }

        } catch (Exception ex) {
			ex.printStackTrace();
        }
		
		//BACK BUTTON
		backbtn = new JButton("Back");
		backbtn.setBounds(03,700,100,30);
		backbtn.setForeground(new Color(255,255,255));
		backbtn.setBackground(new Color(0,0,0));
		backbtn.setFocusPainted(false);
		backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backbtn.addActionListener(this);
		
		
		
		//EXIT BUTTON
		exitbtn = new JButton("Exit");
		exitbtn.setBounds(1250,700,100,30);
		exitbtn.setForeground(new Color(255,255,255));
		exitbtn.setBackground(new Color(0,0,0));
		exitbtn.setFocusPainted(false);
		exitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitbtn.addActionListener(this);
		
		
		
		
		//PANEL 1
		panel1 = new JPanel();
        panel1.setBounds(0,0,1000,70);
        panel1.setBackground(new Color(37,37,37,210));
		//PANEL
		panel2 = new JPanel();
        panel2.setBounds(220,100,550,550);
        panel2.setBackground(new Color(37,37,37,210));
		
		//BACKGROUND IMAGE
		bg = new ImageIcon("images/userbg.jpg");
		background = new JLabel();
		background.setIcon(bg);
		background.setBounds(0,0,1000,700);
		
		
		//ADDING COMPONENTS
		Frame.add(pageName);
		Frame.add(adminlbl);
		Frame.add(backbtn);
        Frame.add(lbl);
        Frame.add(moviename);
        Frame.add(movieTextField);
        Frame.add(RelesingDate);
        Frame.add(relesingDateTextField);
        Frame.add(refresh);
		Frame.add(exitbtn);
		Frame.add(panel1);
		Frame.add(panel2);
		Frame.add(background);
		
		
		
		Frame.setIconImage(Homeicon.getImage());
		Frame.setSize(1000,700);
		Frame.setLayout(null);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		Frame.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==refresh){


			String fileName = "files/UpcomingMovie.txt"; 
			int nextEntryNumber = 1;
			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.matches("^\\d+$")) {
						nextEntryNumber = Integer.parseInt(line) + 1;
					}
				}
			} catch (IOException ex) {
				System.err.format("IOException: %s%n", e);
			}
			

			
	
			 

			try{
				File file = new File("files/UpcomingMovie.txt");
				FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


			if(movieTextField.getText().isEmpty()&&relesingDateTextField.getText().isEmpty()){
				showMessageDialog(null,"Fill the box Correctly.");
			}

			else {
				try (PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
					printWriter.println("====================");
					printWriter.println(nextEntryNumber);
					printWriter.println("Movie Name:"+movieTextField.getText());
					printWriter.println("Releasing Date:"+relesingDateTextField.getText());
					printWriter.println("====================");

					showMessageDialog(null,"SuccessFully Updated");
				    new AdminDashBoard(user);
				   
				}

				

			}

			}
			catch(Exception ex){

			}

			

		}
				

                


		else if(e.getSource()==pageName)
		{
			new AdminDashBoard(user);
			Frame.setVisible(false);
			
		}
		
		else if(e.getSource()==exitbtn)
		{
			System.exit(0);
		}

                

                

               

     }
            
			
}



		
		
		

