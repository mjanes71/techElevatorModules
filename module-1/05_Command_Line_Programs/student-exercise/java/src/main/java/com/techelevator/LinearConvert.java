package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		System.out.println("Well hello there! Welcome to the length converter!");

		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a numerical length for us to convert: ");
		String lengthFromUser = input.nextLine();
		int lengthToConvert = Integer.parseInt(lengthFromUser);

		System.out.print("Thanks for that! Was that a length in (M)eters or (F)eet?: ");
		String metersOrFeet = input.nextLine();

		boolean isMeters = metersOrFeet.contains("M");

		if(isMeters){
			double metersForYou = lengthToConvert * 3.2808399;
			System.out.println("Great! " + lengthFromUser + " meters is equal to " + metersForYou + " feet!");
		}else {
			double feetForYou = lengthToConvert * 0.3048;
			System.out.println("Great! " + lengthFromUser + " feet is equal to " + feetForYou + " meters!");
		}

	}

}
