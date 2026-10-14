package Classes;


import javax.swing.*;

import MovieClass.*;

import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;


public class AdminDashBoard implements ActionListener{
    
    JFrame Frame;
    
    private JLabel  background,adminlbl,lbl;
    private JButton backbtn, exitbtn,refresh,pageName,logOut;
    private JButton userList,userDelete,adminList,adminDelete,relaseUpdate,movieUpdate,addAdmin;
    private ImageIcon Homeicon, bg;
    private JPanel panel1,panel2;

    String user;
    
    public AdminDashBoard(String user)
    {
        this.user =user;
        
        Frame = new JFrame("Admin DashBoard");
        
        
        
        //LOGO
        // Homeicon = new ImageIcon("images/logo.png");
        
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
        adminlbl = new JLabel("Admin DashBoard");
        adminlbl.setBounds(400,18,400,40);
        adminlbl.setForeground(new Color(255,0,0));
        adminlbl.setFont(new Font("serif",Font.PLAIN,30));
        
        //PROJECT NAME
        lbl = new JLabel("DashBoard");
        lbl.setBounds(460,110,400,40);
        lbl.setForeground(new Color(255,255,255));
        lbl.setFont(new Font("serif",Font.PLAIN,25));
        
        //REFRESH BUTTON
        refresh = new JButton("Refresh");
        refresh.setBounds(460,600,80,40);
        refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refresh.addActionListener(this);
        
        
        

        
        
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

        userList = new JButton("User Information");
        userList.setBounds(200,200,180,40);
        userList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userList.setForeground(new Color(211,211,211));
		userList.setFont(new Font("serif",Font.PLAIN,22));
        userList.setBorder(BorderFactory.createEmptyBorder());
        userList.setContentAreaFilled(false);
		userList.setFocusPainted(false);
        userList.addActionListener(this);


        userDelete = new JButton("Delete User");
        userDelete.setBounds(200,280,180,40);
        userDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userDelete.setForeground(new Color(211,211,211));
		userDelete.setFont(new Font("serif",Font.PLAIN,22));
        userDelete.setBorder(BorderFactory.createEmptyBorder());
        userDelete.setContentAreaFilled(false);
		userDelete.setFocusPainted(false);
        userDelete.addActionListener(this);


        adminList = new JButton("Admin Information");
        adminList.setBounds(420,200,180,40);
        adminList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminList.setForeground(new Color(211,211,211));
		adminList.setFont(new Font("serif",Font.PLAIN,22));
        adminList.setBorder(BorderFactory.createEmptyBorder());
        adminList.setContentAreaFilled(false);
		adminList.setFocusPainted(false);
        adminList.addActionListener(this);


        adminDelete = new JButton("Delete Admin");
        adminDelete.setBounds(420,280,180,40);
        adminDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminDelete.setForeground(new Color(211,211,211));
		adminDelete.setFont(new Font("serif",Font.PLAIN,22));
        adminDelete.setBorder(BorderFactory.createEmptyBorder());
        adminDelete.setContentAreaFilled(false);
		adminDelete.setFocusPainted(false);
        adminDelete.addActionListener(this);

        relaseUpdate = new JButton("Movie Relase Update");
        relaseUpdate.setBounds(640,200,220,40);
        relaseUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        relaseUpdate.setForeground(new Color(211,211,211));
		relaseUpdate.setFont(new Font("serif",Font.PLAIN,22));
        relaseUpdate.setBorder(BorderFactory.createEmptyBorder());
        relaseUpdate.setContentAreaFilled(false);
		relaseUpdate.setFocusPainted(false);
        relaseUpdate.addActionListener(this);

        movieUpdate = new JButton("Movie Update");
        movieUpdate.setBounds(640,280,220,40);
        movieUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        movieUpdate.setForeground(new Color(211,211,211));
		movieUpdate.setFont(new Font("serif",Font.PLAIN,22));
        movieUpdate.setBorder(BorderFactory.createEmptyBorder());
        movieUpdate.setContentAreaFilled(false);
		movieUpdate.setFocusPainted(false);
        movieUpdate.addActionListener(this);

        logOut = new JButton("Logout");
        logOut.setBounds(450,440,100,40);
        logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logOut.setForeground(Color.red);
		logOut.setFont(new Font("serif",Font.PLAIN,22));
        logOut.setBorder(BorderFactory.createEmptyBorder());
        logOut.setContentAreaFilled(false);
		logOut.setFocusPainted(false);
        logOut.addActionListener(this);

        addAdmin = new JButton("Add Admin");
        addAdmin.setBounds(400,360,220,40);
        addAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addAdmin.setForeground(new Color(211,211,211));
		addAdmin.setFont(new Font("serif",Font.PLAIN,22));
        addAdmin.setBorder(BorderFactory.createEmptyBorder());
        addAdmin.setContentAreaFilled(false);
		addAdmin.setFocusPainted(false);
        addAdmin.addActionListener(this);




        
        
        
        
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
        Frame.add(userList);
        Frame.add(userDelete);
        Frame.add(adminList);
        Frame.add(adminDelete);
        Frame.add(relaseUpdate);
        Frame.add(movieUpdate);
        Frame.add(addAdmin);
        Frame.add(logOut);
        Frame.add(panel1);
        Frame.add(panel2);
        Frame.add(background);
        
        
        
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
            new AdminDashBoard(user);
            
        }



        
        else if(e.getSource()==pageName)
        {
            new AdminDashBoard(user);
            Frame.setVisible(false);
            
        }
        

        else if(e.getSource()==userList)
        {
            new UserList(user);
            Frame.setVisible(false);
        }

        else if(e.getSource()==userDelete)
        {
            new UserDelete(user);
            Frame.setVisible(false);
        }

        else if(e.getSource()==adminList)
        {
            new AdminList(user);
            Frame.setVisible(false);
        }

        else if(e.getSource()==adminDelete)
        {

            if(user.equals("owner@gmail.com")){
                new AdminDelete(user);
               Frame.setVisible(false);

            }
            else{
                showMessageDialog(null,"You have no Access to \nuse this feature.");
            }
            
        }

        else if(e.getSource()==relaseUpdate)
        {
            new MovieRelaseControl(user);
            Frame.setVisible(false);
        }

        else if(e.getSource()==movieUpdate)
        {
            new MovieUpdate(user);
            Frame.setVisible(false);
        }

        else if(e.getSource()==logOut)
        {
            new AdminSignIn();
            Frame.setVisible(false);
        }
        
        else if(e.getSource()==addAdmin)
        {
            if(user.equals("owner@gmail.com")){
                new AddAdmin(user);
                Frame.setVisible(false);

            }
            else{
                showMessageDialog(null,"You have no Access to \nuse this feature.");

            }
            
        }
    }
    
    
}


