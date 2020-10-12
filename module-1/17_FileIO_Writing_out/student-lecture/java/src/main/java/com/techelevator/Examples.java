package com.techelevator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.Scanner;

public class Examples {

    public static void main(String[] args) {
    	Examples examples = new Examples();

		//examples.inspectFilesystem();
		//examples.makeNewDirectory();
		//examples.createOrReplaceFile();
		//examples.addToFile();
	}
	
	private String promptForString(String prompt) {
		Scanner userInput = new Scanner(System.in);
		System.out.print(prompt);
		return userInput.nextLine();
	}

	private void inspectFilesystem() {
		String input = promptForString("Enter the path of a file or directory >>> ");
		Path path = Paths.get(input); //constructs a relative path to that file

        if (Files.exists(path)) { //if the file path exists
            path = path.toAbsolutePath(); //changes path to an absolute path (from root directory)
			System.out.println(path + " exists.");//checks to see if file exists
			if (Files.isDirectory(path)) { //looks to see if file is a directory (folder)
				System.out.println("Type: Directory");
			} else if (Files.isRegularFile(path)) { //looks to see if file is a file (single file)
				System.out.println("Type: File");
				try {
                    System.out.println("Size: " + Files.size(path));//tries to figure out the size of the file
                } catch (IOException e) {
				    System.out.println("Couldn't get file size.");//check for exception if file doesn't exist (even though we know it does if it gets to here, the compiler doesn't know and .size could potentially throw a checked exception if we hadn't already accounted for it)
                }
			}
		} else {
			System.out.println("File does not exist.");
		}
    }

    private void makeNewDirectory() {
    	String input = promptForString("Enter the path of a new directory: ");
    	Path newDir = Paths.get(input);//creates file path for new directory
    	try {
			Files.createDirectory(newDir); //creates directory- pass the directory path to it
			System.out.println("Directory created.");
		} catch (FileAlreadyExistsException e) { //catches if directory already exists
    		System.out.println("That directory already exists.");
		} catch (IOException e) { //catches other reasons a directory might not be able to be created (not enough space, trying to create directory outside the project)
    		System.out.println("Unable to create directory.");
		}
	}

	private void createOrReplaceFile() { //Scanners read files, PrintWriters write to files- by default, printwriters create or replace text in a file
    	String target = promptForString("Enter the path of the file to create or replace: ");
    	String content = promptForString("Enter content for the file: ");

    	try { //can avoid writing a close statement by declaring and initializing the printwriter like : try(Printwriter writer = new PrintWriter(target){
			PrintWriter writer = new PrintWriter(target); //make new Printerwriter and pass it the file name (doesn't need a path, can take a string)
    		writer.println(content); //similar to system.out.println, just writes to the file instead of the console
    		writer.close(); //closes the writer (which will flush the buffer) can use .flush() to force a flush before close
    		System.out.println("File has been created (or replaced).");
		} catch (IOException e) {
    		System.out.println("Couldn't create or replace file.");
		}
	}

	private void addToFile() { //because PrintWriter will only create or replace a file (overwriting existing, not adding to) this will add to what's already in the file
		String target = promptForString("Enter the path of the file to be added to: ");
		String content = promptForString("Enter additional content for the file: ");

		try {
			FileOutputStream stream = new FileOutputStream(target, true);//uses FileOutputStream object which allows us to pass a target file AND a true or false to indicate if we want to add (true) or overwrite(false)
			PrintWriter writer = new PrintWriter(stream);//create PrintWriter that utilizes the FileOutputStream
			writer.println(content);
			writer.close(); //both PrintWriter and FileOutputStream have to be closed to flush the buffer
			stream.close();
			System.out.println("File has been added to.");
		} catch (IOException e) {
			System.out.println("Couldn't append to file.");
		}
	}
}
//to put stream and writer in try with exceptions
//try(FileOutputStream stream = new FileOutputStream(target,true);
// PrintWriter writer = new PrintWriter(stream)){