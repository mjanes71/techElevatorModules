package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/

		int numberOfExercises = 26;
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/

		double half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name = "TechElevator";

		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";

		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;

		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Megan";
		System.out.println(myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfMouseButtons = 2;
		System.out.println(numberOfMouseButtons);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int percentBatteryLeft = 46;
		System.out.println(percentBatteryLeft + "%");

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121-27;
		System.out.println(difference);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double addTwoNumbers = 12.3 + 32.1;
		System.out.println(addTwoNumbers);

		/*
		12. Create a String that holds your full name.
		*/
		String myFullName = "Megan Rachel Janes";
		System.out.println(myFullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greeting = "Hello, " + myFullName;
		System.out.println(greeting);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		myFullName = myFullName + " Esquire";
		System.out.println(myFullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		myFullName += " Esquire";
		System.out.println(myFullName);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String movieTitle = "Saw " + 2;
		System.out.println(movieTitle);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		movieTitle += 0;
		System.out.println(movieTitle);

		/*
		18. What is 4.4 divided by 2.2?
		*/
		double remainder = 4.4/2.2;
		System.out.println(remainder);

		/*
		19. What is 5.4 divided by 2?
		*/
		double nextRemainder = 5.4/2;
		System.out.println(nextRemainder);

		/*
		20. What is 5 divided by 2?
		*/
		double anotherRemainder = 5/2;
		System.out.println(anotherRemainder);

		/*
		21. What is 5.0 divided by 2?
		*/
		double yetAnotherRemainder = 5.0/2;
		System.out.println(yetAnotherRemainder);


		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println(66.6/100);
		System.out.println(0.1 + 0.2);

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println(5%2);

		/*
		24. What is 1,000,000,000 * 3?
		*/
		long bigNumber = 1_000_000_000L * 3;
		System.out.println(bigNumber);

		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercises = false;


		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;

		int totalMoneyInCents = 50;
		int costOfPencilInCents = 7;
		int numOfPencilsCanBePurchased = totalMoneyInCents / costOfPencilInCents;
		System.out.println(numOfPencilsCanBePurchased);

		int totalNumOfCards = 94;
		int cardsPerBox = 8;
		int boxesFullOfCards = totalNumOfCards / cardsPerBox;
		int leftOverCards = totalNumOfCards % cardsPerBox;
		System.out.println(boxesFullOfCards);
		System.out.println(leftOverCards);

		int bakedCroissants = 17;
		int numOfGuests = 7;
		int numOfCroissantsPerGuest = bakedCroissants / numOfGuests;
		System.out.println(numOfCroissantsPerGuest);

		double squareFeetPerRoom = 168.0;
		double squareFeetPerHourBill = squareFeetPerRoom / 2.15;
		double squareFeetPerHourJill = squareFeetPerRoom / 1.90;
		double squareFeetPerHourTeam = squareFeetPerHourBill + squareFeetPerHourJill;
		int numOfRoomsToPaint = 5;
		double hoursToCompleteJob = numOfRoomsToPaint * squareFeetPerRoom / squareFeetPerHourTeam;
		numOfRoomsToPaint = 623;
		int hoursPerDay = 8;
		double daysToCompleteBigJob = (numOfRoomsToPaint * squareFeetPerRoom / squareFeetPerHourTeam) /hoursPerDay;
		System.out.println(hoursToCompleteJob);
		System.out.println(daysToCompleteBigJob);

		String firstName = "Megan ";
		String middleInitial = "R.";
		String lastName = "Janes, ";
		String fullName = lastName + firstName + middleInitial;
		System.out.println(fullName);

		double milesFromNewYorkToChicago = 800.0;
		double milesTraveledSoFar = 537.0;
		double percentTripCompleted = milesTraveledSoFar / milesFromNewYorkToChicago * 100.0;
		System.out.println((int)percentTripCompleted);
		
	}

}
