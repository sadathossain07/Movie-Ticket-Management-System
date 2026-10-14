package MovieClass;

import java.io.*;
import java.nio.file.*;


public class MovieDetails {
    
    public String findMoviePath(int n){
        String value="";
         
        try{

            String path = "files/MovieUpdate.txt";
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
                        if(line.equals("start")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                            bufferedReader.close();
                            String movie1=line1.substring("movie1path:".length());
                            value = movie1;

                            
                        }
                        
                    }

                    break;

                    case 2:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                            bufferedReader.close();
                            String movie2=line1.substring("movie2path:".length());
                            value = movie2;

                            
                        }
                        
                    }
                    break;

                    case 3:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                            bufferedReader.close();
                            String movie3=line1.substring("movie3path:".length());
                            value = movie3;

                            
                        }
                        
                    }
                    break;

                    case 4:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                            bufferedReader.close();
                            String movie4=line1.substring("movie4path:".length());
                            value = movie4;

                            
                        }
                        
                    }
                    break;


                }


        }

        catch(Exception e){

        }

        return value;

    }  


    public void changeMoviePath(int n,String gotpath){
        
        try {
            Path path = Paths.get("files/MovieUpdate.txt");
            String oldLine="";
            String newLine ="";

            if(n==1){
                oldLine = "movie1path:"+this.findMoviePath(1);
                newLine = "movie1path:" + gotpath;
            }
            else if(n==2){
                oldLine ="movie2path:"+this.findMoviePath(2);
                newLine = "movie2path:" + gotpath;
            }
            else if(n==3){
                oldLine ="movie3path:"+this.findMoviePath(3);
                newLine = "movie3path:" + gotpath;
            }
            else if(n==4){
                oldLine ="movie4path:"+this.findMoviePath(4);
                newLine = "movie4path:" + gotpath;
            }
            
            
            
            System.out.println(newLine);
            System.out.println(oldLine);
            System.out.println(findMoviePath(2));
            
                String fileContent = new String(Files.readAllBytes(path));
                fileContent = fileContent.replaceAll(oldLine, newLine);
                Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            
            } catch (IOException ex) {
                    ex.printStackTrace();
              } 

    }


    public String findMovieName(int n){
     
         String value ="";

         try{

            String path = "files/MovieUpdate.txt";
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
                        if(line.equals("start2")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                            bufferedReader.close();
                            String movie1name=line1.substring("movie1name:".length());
                            value = movie1name;

                            
                        }
                        
                    }

                    break;

                    case 2:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start2")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                            bufferedReader.close();
                            String movie2name=line1.substring("movie2name:".length());
                            value = movie2name;

                            
                        }
                        
                    }
                    break;

                    case 3:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start2")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                            bufferedReader.close();
                            String movie3name=line1.substring("movie2name:".length());
                            value = movie3name;

                            
                        }
                        
                    }
                    break;

                    case 4:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start2")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                            bufferedReader.close();
                            String movie4name=line1.substring("movie4name:".length());
                            value = movie4name;

                            
                        }
                        
                    }
                    break;


                }


        }

        catch(Exception e){

        }

         return value;

    }

    public void changeMovieName(int n,String gotName){
        
        try {
            Path path = Paths.get("files/MovieUpdate.txt");
            String oldLine="";
            String newLine ="";

            if(n==1){
                oldLine = "movie1name:"+this.findMovieName(1);
                newLine = "movie1name:" + gotName;
            }
            else if(n==2){
                oldLine ="movie2name:"+this.findMovieName(2);
                newLine = "movie2name:" + gotName;
            }
            else if(n==3){
                oldLine ="movie3name:"+this.findMovieName(3);
                newLine = "movie3name:" + gotName;
            }
            else if(n==4){
                oldLine ="movie4name:"+this.findMovieName(4);
                newLine = "movie4name:" + gotName;
            }
            
            
            
            
                String fileContent = new String(Files.readAllBytes(path));
                fileContent = fileContent.replaceAll(oldLine, newLine);
                Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            
            } catch (IOException ex) {
                    ex.printStackTrace();
              } 

    }

    public String findSliderPath(int n){
        String value="";

        try{

            String path = "files/MovieUpdate.txt";
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
                        if(line.equals("start3")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                            bufferedReader.close();
                            String slider1=line1.substring("slider1:".length());
                            value = slider1;

                            
                        }
                        
                    }

                    break;

                    case 2:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start3")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                            bufferedReader.close();
                            String slider1=line1.substring("slider2:".length());
                            value = slider1;

                            
                        }
                        
                    }
                    break;

                    case 3:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start3")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                            bufferedReader.close();
                            String slider3=line1.substring("slider3:".length());
                            value = slider3;

                            
                        }
                        
                    }
                    break;

                    case 4:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start3")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                            bufferedReader.close();
                            String slider4=line1.substring("slider4:".length());
                            value = slider4;

                            
                        }
                        
                    }
                    break;


                }


        }

        catch(Exception e){

        }

        return value;
    }

    public void changeSlider(int n,String gotslider){
        
        try {
            Path path = Paths.get("files/MovieUpdate.txt");
            String oldLine="";
            String newLine ="";

            if(n==1){
                oldLine = "slider1:"+this.findSliderPath(1);
                newLine = "slider1:" + gotslider;
            }
            else if(n==2){
                oldLine ="slider2:"+this.findSliderPath(2);
                newLine = "slider2:" + gotslider;
            }
            else if(n==3){
                oldLine ="slider3:"+this.findSliderPath(3);
                newLine = "slider3:" + gotslider;
            }
            else if(n==4){
                oldLine ="slider4:"+this.findSliderPath(4);
                newLine = "slider4:" + gotslider;
            }
            
            
            
            
                String fileContent = new String(Files.readAllBytes(path));
                fileContent = fileContent.replaceAll(oldLine, newLine);
                Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            
            } catch (IOException ex) {
                    ex.printStackTrace();
              } 

    }

    public String findMovieRating(int n){
        String value="";
         
        try{

            String path = "files/MovieUpdate.txt";
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
                        if(line.equals("start4")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                            bufferedReader.close();
                            String movie1=line1.substring("movierating1:".length());
                            value = movie1;

                            
                        }
                        
                    }

                    break;

                    case 2:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start4")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                            bufferedReader.close();
                            String movie2=line1.substring("movierating2:".length());
                            value = movie2;

                            
                        }
                        
                    }
                    break;

                    case 3:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start4")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                            bufferedReader.close();
                            String movie3=line1.substring("movierating3:".length());
                            value = movie3;

                            
                        }
                        
                    }
                    break;

                    case 4:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start4")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                            bufferedReader.close();
                            String movie4=line1.substring("movierating4:".length());
                            value = movie4;

                            
                        }
                        
                    }
                    break;


                }


        }

        catch(Exception e){

        }

        return value;

    }

    public void changeMovieRating(int n,String gotName){
        
        try {
            Path path = Paths.get("files/MovieUpdate.txt");
            String oldLine="";
            String newLine ="";

            if(n==1){
                oldLine = "movierating1:"+this.findMovieRating(1);
                newLine = "movierating1:" + gotName;
            }
            else if(n==2){
                oldLine ="movierating2:"+this.findMovieRating(2);
                newLine = "movierating2:" + gotName;
            }
            else if(n==3){
                oldLine ="movierating3:"+this.findMovieRating(3);
                newLine = "movierating3:" + gotName;
            }
            else if(n==4){
                oldLine ="movierating4:"+this.findMovieRating(4);
                newLine = "movierating4:" + gotName;
            }
            
            
            
            
                String fileContent = new String(Files.readAllBytes(path));
                fileContent = fileContent.replaceAll(oldLine, newLine);
                Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            
            } catch (IOException ex) {
                    ex.printStackTrace();
              } 

    }

    public String findMoviePrice(int n){
        String value="";
         
        try{

            String path = "files/MovieUpdate.txt";
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
                        if(line.equals("start5")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                            bufferedReader.close();
                            String movie1=line1.substring("movieprice1:".length());
                            value = movie1;

                            
                        }
                        
                    }

                    break;

                    case 2:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start5")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                            bufferedReader.close();
                            String movie2=line1.substring("movieprice2:".length());
                            value = movie2;

                            
                        }
                        
                    }
                    break;

                    case 3:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start5")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                            bufferedReader.close();
                            String movie3=line1.substring("movieprice3:".length());
                            value = movie3;

                            
                        }
                        
                    }
                    break;

                    case 4:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start5")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                            bufferedReader.close();
                            String movie4=line1.substring("movieprice4:".length());
                            value = movie4;

                            
                        }
                        
                    }
                    break;


                }


        }

        catch(Exception e){

        }

        return value;

    }

    public void changeMoviePrice(int n,String gotName){
        
        try {
            Path path = Paths.get("files/MovieUpdate.txt");
            String oldLine="";
            String newLine ="";

            if(n==1){
                oldLine = "movieprice1:"+this.findMoviePrice(1);
                newLine = "movieprice1:" + gotName;
            }
            else if(n==2){
                oldLine ="movieprice2:"+this.findMoviePrice(2);
                newLine = "movieprice2:" + gotName;
            }
            else if(n==3){
                oldLine ="movieprice3:"+this.findMoviePrice(3);
                newLine = "movieprice3:" + gotName;
            }
            else if(n==4){
                oldLine ="movieprice4:"+this.findMoviePrice(4);
                newLine = "movieprice4:" + gotName;
            }
            
            
            
            
                String fileContent = new String(Files.readAllBytes(path));
                fileContent = fileContent.replaceAll(oldLine, newLine);
                Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            
            } catch (IOException ex) {
                    ex.printStackTrace();
              } 

    }

    public String findMovieGenre(int n){
        String value="";
         
        try{

            String path = "files/MovieUpdate.txt";
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
                        if(line.equals("start6")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                            bufferedReader.close();
                            String movie1=line1.substring("moviegenre1:".length());
                            value = movie1;

                            
                        }
                        
                    }

                    break;

                    case 2:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start6")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                            bufferedReader.close();
                            String movie2=line1.substring("moviegenre2:".length());
                            value = movie2;

                            
                        }
                        
                    }
                    break;

                    case 3:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start6")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                            bufferedReader.close();
                            String movie3=line1.substring("moviegenre3:".length());
                            value = movie3;

                            
                        }
                        
                    }
                    break;

                    case 4:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start6")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                            bufferedReader.close();
                            String movie4=line1.substring("moviegenre4:".length());
                            value = movie4;

                            
                        }
                        
                    }
                    break;


                }


        }

        catch(Exception e){

        }

        return value;

    }

    public void changeMovieGenre(int n,String gotName){
        
        try {
            Path path = Paths.get("files/MovieUpdate.txt");
            String oldLine="";
            String newLine ="";

            if(n==1){
                oldLine = "moviegenre1:"+this.findMovieGenre(1);
                newLine = "moviegenre1:" + gotName;
            }
            else if(n==2){
                oldLine ="moviegenre2:"+this.findMovieGenre(2);
                newLine = "moviegenre2:" + gotName;
            }
            else if(n==3){
                oldLine ="moviegenre3:"+this.findMovieGenre(3);
                newLine = "moviegenre3:" + gotName;
            }
            else if(n==4){
                oldLine ="moviegenre4:"+this.findMovieGenre(4);
                newLine = "moviegenre4:" + gotName;
            }
            
            
            
            
                String fileContent = new String(Files.readAllBytes(path));
                fileContent = fileContent.replaceAll(oldLine, newLine);
                Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            
            } catch (IOException ex) {
                    ex.printStackTrace();
              } 

    }

    public String findMovieYear(int n){
        String value="";
         
        try{

            String path = "files/MovieUpdate.txt";
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
                        if(line.equals("start7")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+1);
                            bufferedReader.close();
                            String movie1=line1.substring("movieyear1:".length());
                            value = movie1;

                            
                        }
                        
                    }

                    break;

                    case 2:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start7")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+2);
                            bufferedReader.close();
                            String movie2=line1.substring("movieyear2:".length());
                            value = movie2;

                            
                        }
                        
                    }
                    break;

                    case 3:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start7")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+3);
                            bufferedReader.close();
                            String movie3=line1.substring("movieyear3:".length());
                            value = movie3;

                            
                        }
                        
                    }
                    break;

                    case 4:
                    for (int i = 0; i < check; i++) {
                        String line = Files.readAllLines(Paths.get(path)).get(i);
                        if(line.equals("start7")){
                            String line1 = Files.readAllLines(Paths.get(path)).get(i+4);
                            bufferedReader.close();
                            String movie4=line1.substring("movieyear4:".length());
                            value = movie4;

                            
                        }
                        
                    }
                    break;


                }


        }

        catch(Exception e){

        }

        return value;

    }

    public void changeMovieYear(int n,String gotName){
        
        try {
            Path path = Paths.get("files/MovieUpdate.txt");
            String oldLine="";
            String newLine ="";

            if(n==1){
                oldLine = "movieyear1:"+this.findMovieYear(1);
                newLine = "movieyear1:" + gotName;
            }
            else if(n==2){
                oldLine ="movieyear2:"+this.findMovieYear(2);
                newLine = "movieyear2:" + gotName;
            }
            else if(n==3){
                oldLine ="movieyear3:"+this.findMovieYear(3);
                newLine = "movieyear3:" + gotName;
            }
            else if(n==4){
                oldLine ="movieyear4:"+this.findMovieYear(4);
                newLine = "movieyear4:" + gotName;
            }
            
            
            
            
                String fileContent = new String(Files.readAllBytes(path));
                fileContent = fileContent.replaceAll(oldLine, newLine);
                Files.write(path, fileContent.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            
            } catch (IOException ex) {
                    ex.printStackTrace();
              } 

    }




    

}



