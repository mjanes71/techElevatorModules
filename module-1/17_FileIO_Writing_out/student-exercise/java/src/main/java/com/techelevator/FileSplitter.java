package com.techelevator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileSplitter {



	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Where is the input file (please include the path to the file)?");
		String pathFromUser = userInput.nextLine();
		String[] reformattedPath = pathFromUser.split("\\.");
		Path filePath = Paths.get(pathFromUser);

		int totalNumberOfLines = 0;
		try(Scanner howManyLines = new Scanner(filePath)){
			while(howManyLines.hasNextLine()){
				howManyLines.nextLine();
				totalNumberOfLines++;
			}
		}catch(IOException x){
			System.out.println("Could not locate file");
		}

		System.out.println("How many lines of text (max) should there be in the split files?");
		String numberOfLines = userInput.nextLine();

		int numberOfFilesProduced = 0;
		if(totalNumberOfLines % Integer.parseInt(numberOfLines) == 0){
			numberOfFilesProduced = totalNumberOfLines / Integer.parseInt(numberOfLines);
		}else {
			numberOfFilesProduced = (totalNumberOfLines / Integer.parseInt(numberOfLines)) + 1;
		}

				System.out.println("The input file has " +totalNumberOfLines + " lines of text");
		System.out.println("Each file that is created should have a sequential number assigned to it.");
		System.out.println("For a " + totalNumberOfLines + " line input file " + "\"" + pathFromUser + "\"" + ", this produces " + numberOfFilesProduced + " output files.");
		System.out.println("**Generating Output**");

		int counter = 1;
		int totalLines = 0;

		try(Scanner reader = new Scanner(filePath)){
			while(reader.hasNextLine()){ //while loop through whole long doc

				for (int i = 0; reader.hasNextLine(); i++){
					try(PrintWriter writer = new PrintWriter(reformattedPath[0] + "-" + counter + "."+ reformattedPath[1])){
						System.out.println("Generating " + reformattedPath[0] + "-" + counter + "."+ reformattedPath[1]);
						for (int n = 0; n < Integer.parseInt(numberOfLines); n++){
							if(reader.hasNextLine()) {
								String line = reader.nextLine();
								writer.println(line);
								totalLines++;
							}
						} counter ++;

					} catch(IOException ex){
						System.out.println("File not found");
					}
				}
			}
		}catch(IOException e){
			System.out.println("File not found");
		}
	}
}
