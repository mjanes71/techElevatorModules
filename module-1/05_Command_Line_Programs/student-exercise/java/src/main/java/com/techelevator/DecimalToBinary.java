package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter in a series of decimal values (separated by spaces): ");
		String userValues = input.nextLine();
		String[] userValuesSplit = userValues.split(" ");
		int[] decimalValues = new int[userValuesSplit.length];

		for(int i = 0; i < userValuesSplit.length; i++){
			decimalValues[i] = Integer.parseInt(userValuesSplit[i]);
			System.out.println(decimalValues[i] + " is " + Integer.toBinaryString(decimalValues[i]));
		}




	}

}
