package com.techelevator.readfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileReader {


    public static void main(String[] args) {
        //Two ways to represent a file:
        File myFile = new File("input.txt"); //Older style, can convert to Path with .toPath()
        Path myPath = Paths.get("input.txt");    //Newer style, can convert to File with .toFile()

        Scanner userInput = new Scanner(System.in); // how to create a scanner that opens the console

        try (Scanner fileInput = new Scanner(myPath)){ //putting the scanner in the argument of the try block automatically closes anything that's opened after the block is done

            while(fileInput.hasNextLine()) { //executes until file runs out of lines
                String line = fileInput.nextLine(); //this says "read that file from the scanner and get the next line (starts with first line)
                System.out.println(line);// this says "print what is stored as the next line
            }
           // fileInput.close(); --> can add this to a normal try block to make sure the open file gets closed, or use a try-with-resources block to do it automatically
        } catch (IOException e){
            System.out.println("Could not open file.");
        }

    }

}
