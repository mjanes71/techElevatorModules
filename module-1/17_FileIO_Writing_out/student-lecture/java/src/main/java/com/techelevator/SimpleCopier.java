package com.techelevator;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SimpleCopier {

    private String source; //file we want to copy from
    private String destination; //file we want to copy to

    public SimpleCopier(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public void makeCopy() {
        Path sourcePath = Paths.get(source); //make a path to feed the scanner
        try (Scanner sourceScanner = new Scanner(sourcePath); //make new scanner (with resources)
             PrintWriter destinationWriter = new PrintWriter(destination)) { //make new printwriter (with resources)
            while(sourceScanner.hasNextLine()){ //while the scanner has a next line in the file that it can read
                String line = sourceScanner.nextLine(); //store the line in a variable line
                destinationWriter.println(line); //pass that line to the printwriter for writing
            }

        } catch (IOException exception) {
            System.out.println("Couldn't read from source file.");

        }
    }

    public static void main(String[] args) {
        SimpleCopier mycopier = new SimpleCopier("demo/example.txt", "demo/copyofexample.txt");
        mycopier.makeCopy();
    }
}