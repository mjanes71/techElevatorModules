package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		System.out.print("Enter the temperature you want to convert:");

		Scanner input = new Scanner(System.in);

		String temperature = input.nextLine();

		System.out.print("Is the temperature in Celsius or Fahrenheit (enter C or F)");

		String fahrenheitOrCelsius = input.nextLine();

		boolean itsFahrenheit = fahrenheitOrCelsius.contains("F");


		if (itsFahrenheit){
			int fahrenheitTemp = Integer.parseInt(temperature);
			double convertToCelsius = (fahrenheitTemp - 32) / 1.8;
			System.out.println(temperature + " degrees Fahrenheit is " + convertToCelsius + "degrees Celsius." );
		} else {
			int celsiusTemp = Integer.parseInt(temperature);
			double convertToFahrenheit = (celsiusTemp * 1.8 + 32);
			System.out.println(temperature + " degrees Celsius is " + convertToFahrenheit + "degrees Fahrenheit.");
		}




	}

}
