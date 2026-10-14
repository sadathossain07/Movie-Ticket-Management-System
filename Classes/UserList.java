package Classes;


import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;


public class UserList implements ActionListener{
    
    JFrame Frame;
    
    private JLabel  background,adminlbl,lbl;
    private JButton backbtn, exitbtn,refresh,pageName;
    private ImageIcon Homeicon, bg;
    private JPanel panel1,panel2;

    private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private String[] column = {"Username","FullName","Password","Phone Number","Question","Answer","Joinig Date"};
    private String[] rows = new String[7];

    String user;
    
    public UserList(String user)
    {
        this.user =user;
        
        Frame = new JFrame("Admin Panel");
        
        
        
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
        adminlbl = new JLabel("Admin Panel");
        adminlbl.setBounds(410,18,400,40);
        adminlbl.setForeground(new Color(255,0,0));
        adminlbl.setFont(new Font("serif",Font.PLAIN,30));
        
        //PROJECT NAME
        lbl = new JLabel("User List");
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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
        table.setEnabled(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);
        table.getColumnModel().getColumn(5).setPreferredWidth(160);
        table.getColumnModel().getColumn(6).setPreferredWidth(160);
        table.setFont(new Font("serif",Font.PLAIN,14));
		

        scroll = new JScrollPane(table);
        scroll.setBounds(160, 150, 700, 450);
        Frame.add(scroll);
        
        
        

        String file = "files/user.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
            {
                totalLines++;
            }
            reader.close();

            for (int i = 0; i < totalLines; i++){

                String lines = Files.readAllLines(Paths.get(file)).get(i);

                
                
                if(lines.contains("#Delete!")==false){
                    if(lines.contains("Username:")){
                        String answer=lines.substring("Username:".length());
                        rows[0] = answer;
                        rows[1] = Files.readAllLines(Paths.get(file)).get((i-1)).substring("FullName:".length());
                        rows[2] = Files.readAllLines(Paths.get(file)).get((i+1)).substring("Password:".length());
                        rows[3] = Files.readAllLines(Paths.get(file)).get((i+2)).substring("Phone Number:".length());;
                        rows[4] = Files.readAllLines(Paths.get(file)).get((i+4)).substring("Security Question is:".length());
                        rows[5] = Files.readAllLines(Paths.get(file)).get((i+5)).substring("Answer is:".length());;
                        rows[6] = Files.readAllLines(Paths.get(file)).get((i+6));
                  
                        
                        model.addRow(rows);
                     
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
        Frame.add(backbtn);
        Frame.add(refresh);
        Frame.add(lbl);
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
        if(e.getSource()==refresh)
        {
            Frame.setVisible(false);
            new UserList(user);
            
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



