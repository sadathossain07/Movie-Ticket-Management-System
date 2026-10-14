package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.nio.file.*;
import java.time.*;
import java.io.*;


public class MovieRelaseUpdate implements ActionListener{
	
	JFrame Frame;
	
	private JLabel  background,adminlbl,lbl;
	private JButton backbtn, exitbtn,refresh,pageName;
	private ImageIcon Homeicon, bg;
	private JPanel panel1,panel2;
	
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private String[] column = {"    Movie Name", "    Releasing Date"};
    private String[] rows = new String[6];
	String user;
	
	public MovieRelaseUpdate(String user)
	{
		this.user =user;
		
		Frame = new JFrame("Upcoming Movie");
		
		
		
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
		lbl = new JLabel("Movie List");
		lbl.setBounds(430,110,400,40);
		lbl.setForeground(new Color(255,255,255));
		lbl.setFont(new Font("serif",Font.PLAIN,25));
		
		//REFRESH BUTTON
		refresh = new JButton("Refresh");
		refresh.setBounds(460,600,80,40);
		refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
		refresh.addActionListener(this);
		
		
		
		table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setBackground(new Color(255,255,255));
        table.setRowHeight(30);
		table.setFont(new Font("serif",Font.PLAIN,20));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.setEnabled(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(240);
        table.getColumnModel().getColumn(1).setPreferredWidth(240);
		

        scroll = new JScrollPane(table);
        scroll.setBounds(260, 150, 480, 450);
        Frame.add(scroll);

        String file = "files/UpcomingMovie.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
			{
                totalLines++;
			}
            reader.close();

            for (int i = 0; i < totalLines; i++)


			{
				String lines = Files.readAllLines(Paths.get(file)).get((i));
				String check[]=new String[100];;

				for(int k=1;k<100;k++){
					
					check[k]=String.valueOf(k);

		                if(lines.equals(check[k])){

							String test= Files.readAllLines(Paths.get(file)).get((i + 2)).substring("Releasing Date:".length());

							try{
								if(test.matches("^\\d{4}-\\d{2}-\\d{2}$")){

									LocalDate date = LocalDate.parse(Files.readAllLines(Paths.get(file)).get((i + 2)).substring("Releasing Date:".length()));
								    if(date.compareTo(LocalDate.now())>0){
									rows[0] ="   "+ Files.readAllLines(Paths.get(file)).get((i+1)).substring("Movie Name:".length());
									rows[1] ="   "+ Files.readAllLines(Paths.get(file)).get((i + 2)).substring("Releasing Date:".length());
									
									
									model.addRow(rows);

								}
								
	
								}

							}
							catch(Exception ex){
								ex.printStackTrace();

							}
							
						

					}

					
					

					
				}
              
                    
                			
                    
                    
               
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
        panel2.setBounds(100,100,850,550);
        panel2.setBackground(new Color(37,37,37,210));
		
		//BACKGROUND IMAGE
		bg = new ImageIcon("images/userbg.jpg");
		background = new JLabel();
		background.setIcon(bg);
		background.setBounds(0,0,1000,700);
		
		
		//ADDING COMPONENTS
		Frame.add(pageName);
		Frame.add(adminlbl);
		Frame.add(lbl);
		Frame.add(backbtn);
		Frame.add(exitbtn);
		Frame.add(refresh);
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

	public void Getvalue(String k){


	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==refresh)
		{
			Frame.setVisible(false);
			new MovieRelaseUpdate(user);
			
		}



		
		else if(e.getSource()==pageName)
		{
			new Dashboard(user);
			Frame.setVisible(false);
			
		}
		
		else if(e.getSource()==exitbtn)
		{
			System.exit(0);
		}
		
	}
	
	
}
