package Classes;

import java.io.*;
import java.nio.file.*;

public class TicketDetails {

    public void findTicket(){

        try{

            String path = "files/TicketView.txt";
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                int check = 0;
                while (bufferedReader.readLine() != null) {
                    check++;
                }


                for (int i = 0; i < check; i++) {
                    String line = Files.readAllLines(Paths.get(path)).get(i);
                    if(line.equals("username:dip")){
                        String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                        bufferedReader.close();
                        String movie1=line1.substring("ticket:".length());
                        System.out.println(movie1);
                    }
                }

        }   
        catch(Exception e){

             System.out.println("null");
        }     

    }

   
}
