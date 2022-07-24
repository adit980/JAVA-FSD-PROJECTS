package fhandling;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;

public class Fhandle {
    public static void main(String[] args) {

        File myFile = new File("admax.txt");
        try {
            myFile.createNewFile();
            System.out.println("File created successfully.");
            FileWriter fileWriter = new FileWriter("admax.txt");
            // method to write contents into the file created
            
            fileWriter.write("Welcome everyone .\nThis is a new file creation in java.\nA new file is created and contents are written\nRest of the activities are also being done.");
            fileWriter.close();
            System.out.println("File has contents now.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
      
    }

}