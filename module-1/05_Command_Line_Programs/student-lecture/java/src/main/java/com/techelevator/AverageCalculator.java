package com.techelevator;

import java.util.Scanner;

public class AverageCalculator {

    public static void main(String[] args) {

        System.out.println("Welcome to the average calculator!");
        boolean finished = false;

        while (!finished) {

            System.out.print("Please enter some numbers for me to average: ");

            Scanner input = new Scanner(System.in);

            String numbers = input.nextLine();

            String[] splitNumbers = numbers.split(" ");

            int[] actualNumbers = new int[splitNumbers.length];

            for (int i = 0; i < splitNumbers.length; i++) {
                actualNumbers[i] = Integer.parseInt(splitNumbers[i]);
            }

            int total = 0;
            for (int i = 0; i < actualNumbers.length; i++) {
                total += actualNumbers[i];
            }
            int average = total / actualNumbers.length;
            System.out.println("The average is: " + average);

            System.out.print("Are you finished? (yes/no)?");
            String answer = input.nextLine();
            finished = answer.equals("yes");

        }
    }




}
