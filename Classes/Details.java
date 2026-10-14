package Classes;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;

import Interfaces.IDetails;

import static javax.swing.JOptionPane.showMessageDialog;

public class Details implements IDetails{


    public String findDetails(int n,String username){
            String value="";

            try{
                
                String path = "files/user.txt";
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                int check = 0;
                while (bufferedReader.readLine() != null) {
                    check++;
                }

                switch(n){
                    case 1:
                        for (int i = 0; i < check; i++) {
                            String line = Files.readAllLines(Paths.get(path)).get(i);
                            
                            if(line.equals(username)){
                                String line1 = Files.readAllLines(Paths.get(path)).get(i-1);
                                bufferedReader.close();
                                String fullname=line1.substring("FullName:".length());
                                value=fullname;
                                
                            }
                            
                        }
                        break;

                        case 2:
                            for (int i = 0; i < check; i++) {
                                String line = Files.readAllLines(Paths.get(path)).get(i);
                                if(line.equals(username)){
                                    String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                                    bufferedReader.close();
                                    String Password=line1.substring("Password:".length());
                                    value=Password;
                                    
                                }
                                
                            } 
                            break;
                        
                        case 3:
                            for (int i = 0; i < check; i++) {
                                String line = Files.readAllLines(Paths.get(path)).get(i);
                                if(line.equals(username)){
                                    String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                                    bufferedReader.close();
                                    String Phone=line1.substring("Phone Number:".length());
                                    value=Phone;
                                    
                                }
                                
                            }
                            break;

                        case 4:
                            for (int i = 0; i < check; i++) {
                                String line = Files.readAllLines(Paths.get(path)).get(i);
                                if(line.equals(username)){
                                    String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                                    bufferedReader.close();
                                    String Question=line1.substring("Security Question is:".length());
                                    value=Question;
                                    
                                }
                                
                            }
                            break;

                            case 5:
                                for (int i = 0; i < check; i++) {
                                    String line = Files.readAllLines(Paths.get(path)).get(i);
                                    if(line.equals(username)){
                                        String line1 = Files.readAllLines(Paths.get(path)).get(i+5);
                                        bufferedReader.close();
                                        String answer=line1.substring("Answer is:".length());
                                        value=answer;
                                        
                                    }
                                    
                                }
                                break; 
                                
                                case 6:
                                for (int i = 0; i < check; i++) {
                                    String line = Files.readAllLines(Paths.get(path)).get(i);
                                    if(line.equals(username)){
                                        String answer=line.substring("Username:".length());
                                        value=answer;
                                    }
                                        
                                        
                                    }
                                    break; 

                                    case 7:
                                    for (int i = 0; i < check; i++) {
                                        String line = Files.readAllLines(Paths.get(path)).get(i);
                                        if(line.equals(username)){
                                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                                            bufferedReader.close();
                                            String answer=line1.substring("Path:".length());
                                            value=answer;
                                            
                                        }
                                        
                                    }
                                    break;     

                                
                                    
                                    
                 }
                                
                              
                                
                            }    
                            
                            catch(Exception e){
                                showMessageDialog(null,e);
                            }
                            return value;
                        
                }
                       
        
             
            

        


        public void changeFirstname( JTextField test,String username,int a ){
            try {
                Path path = Paths.get("files/user.txt");
                String oldLine ="FullName:" + findDetails(a, username)+ System.lineSeparator()+username;
                
                if(test.getText()!=""){
                    String newLine ="FullName:" + test.getText()+System.lineSeparator()+username;
                    String fileContent = new String(Files.readAllBytes(path));
                    fileContent = fileContent.replaceAll(oldLine, newLine);
                    Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                
                }
                
                
                
            } catch (IOException ex) {
                ex.printStackTrace();
            } 

        }

        public void changePassword( JPasswordField test,String username,int a ){
            try {
                Path path = Paths.get("files/user.txt");
                String oldLine = username +System.lineSeparator()+"Password:"+findDetails(a, username);
                
                    String newLine = username +System.lineSeparator()+ "Password:" + new String(test.getPassword());
                    String fileContent = new String(Files.readAllBytes(path));
                    fileContent = fileContent.replaceAll(oldLine, newLine);
                    Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                } 
            catch (IOException ex) {
                  ex.printStackTrace();
            } 

        }

        public void changePhone( JTextField test,String username,int a ){
            try {
                Path path = Paths.get("files/user.txt");
                String oldLine =username +System.lineSeparator()+"Password:"+findDetails(2, username)+System.lineSeparator()+"Phone Number:\\" + findDetails(a, username);
                
                
                    String newLine =username +System.lineSeparator()+"Password:"+findDetails(2, username)+System.lineSeparator()+"Phone Number:" + test.getText();
                    String fileContent = new String(Files.readAllBytes(path));
                    fileContent = fileContent.replaceAll(oldLine, newLine);
                    Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                
                } catch (IOException ex) {
                        ex.printStackTrace();
                  } 

        }

        public void changePath(String loco,String username,int a ){
            try {
                Path path = Paths.get("files/user.txt");
                String oldLine =username +System.lineSeparator()+"Password:"+findDetails(2, username)+System.lineSeparator()+"Phone Number:\\" + findDetails(3, username)+System.lineSeparator()+"Path:"+findDetails(a, username);
                
                
                    String newLine =username +System.lineSeparator()+"Password:"+findDetails(2, username)+System.lineSeparator()+"Phone Number:\\" + findDetails(3, username)+System.lineSeparator()+"Path:"+loco;
                    String fileContent = new String(Files.readAllBytes(path));
                    fileContent = fileContent.replaceAll(oldLine, newLine);
                    Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                
                } catch (IOException ex) {
                        ex.printStackTrace();
                  } 

        }
        
        
    }
    