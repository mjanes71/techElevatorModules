package com.techelevator;

public class Lecture {

	//1. Return any String
	public String returnsAString() {
		return "a string";//don't have to declare this string but could never reference it again
	}

	//2. getInputLength("abc") -> 3
	public int getInputLength(String input) {
		return input.length();//have to put put the paren after the method
	}

	//3. getFirst3Letters("abcdef") -> "abc"
	public String getFirst3Letters(String input) {
		return input.substring(0,3);
	}//first param is index you want to start at, second param is index you want to stop at
	//second param is NOT inclusive, but first param is (so 0,3 includes 0,1,2 but not 3)

	//4. getLast3Letters("abcdef") -> "def"
	public String getLast3Letters(String input) {
		return input.substring(input.length()-3, input.length());
	} //second param is optional, if left off, will just include all till end
	// use .length when length of string being passed in is unknown

	//5. removeFirstLetter("abcdef") -> "bcdef"
	public String removeFirstLetter(String input) {
		return input.substring(1);
	}

	//6. locationOfFirstCat("I have a catalog of cats.") -> 9
	public int locationOfFirstCat(String stringWithCat) {
		return stringWithCat.indexOf("cat");
	}

	//7. locationOfLastCat("I have a catalog of cats.") -> 20
	public int locationOfLastCat(String stringWithCat) {
		return stringWithCat.lastIndexOf("cat");
	}

	//8. getFifthCharacter("abcdef") -> 'e'
	public char getFifthCharacter(String input) {
		return input.charAt(4);
	}

	//9. isCareful("I don't think Voldemort is real.") -> "No"
	//   isCareful("Beware of He Who Must Not Be Named.") -> "Yes"
	public String isCareful(String statement) {
		boolean notCareful = statement.contains("Voldemort");
		if(notCareful){
			return "No";
		}else {
			return "Yes";
		}


	}

	//10. roundOnBothEnds("Ohio") -> true
	//    roundOnBothEnds("Oklahoma") -> false
	public boolean roundOnBothEnds(String name) {
		boolean startsWithO = name.toLowerCase().startsWith("o"); // this is how to run multiple methods at the same time
		boolean endsWithO = name.toLowerCase().endsWith("o");
		boolean allRound = startsWithO && endsWithO;
		return allRound;



	}

	//11. sayItLouder("Look out!") -> "LOOK OUT!"
	public String sayItLouder(String phrase) {
		return phrase.toUpperCase();
	}

	//12. princeToFrog("The prince sat by the pond.") -> "The frog sat by the pond. "
	public String princeToFrog(String story) {
		return story.replace("prince","frog");
	}

	//13. isDarthVader("Anakin", "Skywalker") -> true
	public boolean isDarthVader(String firstName, String lastName) {
		return firstName.equals("Anakin") && lastName.equals("Skywalker");
		//can also use .equalsIgnoreCase
	}


}
