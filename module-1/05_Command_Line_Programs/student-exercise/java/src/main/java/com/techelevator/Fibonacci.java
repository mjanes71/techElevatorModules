package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Fibonacci sequence program!");

		System.out.print("Please enter a Fibonacci number: ");
		String userEntered = input.nextLine();
		int fibNumber = Integer.parseInt(userEntered);

		int numPrev = 0;
		int numNext = 1;

		for (int i = numPrev; numPrev < fibNumber; i = numNext){
			System.out.print(numPrev + ", ");
			int sumOfPrev = numPrev + numNext;
			numPrev = numNext;
			numNext = sumOfPrev;

		}




		}




		}




