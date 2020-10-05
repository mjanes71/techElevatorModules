package com.techelevator;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Year;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		int counter = 0;
		Scanner fileToSearch = new Scanner(System.in);
		System.out.println("What is the file that should be searched?");
		Path file = Paths.get(fileToSearch.nextLine());

		Scanner wordToSearch = new Scanner(System.in);
		System.out.println("What is the search word you are looking for?");
		String word = wordToSearch.nextLine();
		System.out.println("Should the search be case sensitive? (Y/N)");
		String caseSensitive = wordToSearch.nextLine();

		try(Scanner readPassage = new Scanner(file)){
			while (readPassage.hasNextLine()){
				String line = readPassage.nextLine();
				counter++;
				if(caseSensitive.equals("N")){
					line = line.toLowerCase();
					word = word.toLowerCase();
				}
				if(line.contains(word)){
					System.out.println(counter + ") " + line);
				}
			}
		}catch (IOException e){
			System.out.println("Can't find the file");
		}
	}
}
