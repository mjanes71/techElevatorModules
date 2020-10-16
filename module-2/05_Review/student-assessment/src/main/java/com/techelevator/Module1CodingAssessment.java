package com.techelevator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testing FlowerShopOrder
		FlowerShopOrder order1 = new FlowerShopOrder("Basic", 7);
		FlowerShopOrder order2 = new FlowerShopOrder("Elegant", 15);

		System.out.println(order1.getBouquetType() + ", " + order1.getNumberOfRoses());
		System.out.println(order2.getBouquetType() + ", " + order2.getNumberOfRoses());
		System.out.println(order1.getSubtotal());

		//testing toString method
		System.out.println(order1.toString());

		//read in the file

//		Path order = Paths.get("FlowerInput.csv");
//		try(Scanner input = new Scanner(order)){
//			for (int i = 0; input.hasNextLine(); i++) {
//				String line = input.nextLine();
//
//			}
//		}catch (IOException e){
//			System.out.println("File not found. Try again.");
//		}


	}

}
