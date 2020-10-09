package com.techelevator;

import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public void writeFizzBuzzTo300(){
		try(PrintWriter fizzWriter = new PrintWriter("FizzBuzz.txt")) {
			for(int i = 1; i <=300;i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					fizzWriter.println("FizzBuzz");
				}else if(i % 3 == 0 || Integer.toString(i).contains("3")){
					fizzWriter.println("Fizz");
				}else if(i % 5 == 0 || Integer.toString(i).contains("5")){
					fizzWriter.println("Buzz");
				}else {
					fizzWriter.println(i);
				}
			}
		} catch(IOException exception){
			System.out.println("File not found");
		}
		System.out.println("FizzBuzz.txt has been created.");
	}
	public static void main(String[] args) {
		FizzWriter testRun = new FizzWriter();
		testRun.writeFizzBuzzTo300();
	}
}
