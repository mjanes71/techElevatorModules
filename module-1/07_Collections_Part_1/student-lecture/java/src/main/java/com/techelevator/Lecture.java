package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	//1. returnsAnArray(5) -> {1, 2, 3, 4, 5}
	public int[] returnsAnArray(int number) {
		int[] result = new int[number];
		for (int i = 0; i < number; i++){
			result[i] = i + 1;
		}
		return result;
	}

	//2. returnsAList(5) -> [1, 2, 3, 4, 5]
	public List<Integer> returnsAList(int number) {
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < number; i++){
			result.add(i+1);
		}
		return result;
	}

	//3. returnThirdName(["Frodo","Sam","Merry","Pippin"]) -> "Merry"
	public String returnThirdName(List<String> names) {
		return names.get(2);

	}

	//4. insertAfterFirst(["Luke","Leia"], "Han") -> ["Luke", "Han", "Leia"]
	public List<String> insertAfterFirst(List<String> names, String name) {
		List<String> result = new ArrayList<>(names); //makes the new list a copy of the list names
		result.add(1, name); // we are changing the copy, not the input list- which reduces side effects
		return result; //.add returns a boolean, not the list
	}

	//5. onlyOneAnswer(["yes", "no", "maybe"]) -> false
	//   onlyOneAnswer(["no"]) -> true
	public boolean onlyOneAnswer(List<String> answers) {
		boolean oneAnswer = answers.size() == 1;
		return oneAnswer;
	}

	//6. removeLastNumber([1.5, 2.2, 0.9]) -> [1.5, 2.2]
	public List<Double> removeLastNumber(List<Double> numbers) {
		numbers.remove(numbers.size()-1);
		return numbers; //we did change the passed in list, so creating a copy would have been best practice here
	}

	//7. hasACow(["duck","cow","chicken"]) -> true
	//   hasACow(["turkey", "rooster"]) -> false
	public boolean hasACow(List<String> farmAnimals) {
		boolean result = farmAnimals.contains("cow");
		return result;
	}

	//8. yourPlaceInLine(["customer","customer","you","customer"]) -> 3
	public int yourPlaceInLine(List<String> allCustomers) {
		int you = allCustomers.indexOf("you");
		return you + 1; // have to add  one because indexOf returns the index, not the literal "place"
	}

	//9. trimArray({"a","b","c","d"}) -> {"b","c"}
	public String[] trimArray(String[] input) {
		List<String> copy = new ArrayList<>(Arrays.asList(input)); //last piece makes an array of the list, rest makes a new list that you can actually use
		copy.remove(0);
		copy.remove(copy.size()-1);
		String[] result = copy.toArray(new String[0]); // turns list back to array
		return result;
	}

	//10. descendingOrder([3, 4, 2, 9, 4, 8]) -> [9, 8, 4, 4, 3, 2]
	public List<Integer> descendingOrder(List<Integer> numbers) {
		List<Integer> result = new ArrayList<>(numbers);
		Collections.sort(result);
		Collections.reverse(result);
		return result;

	}

	//11. countTrues([false,true,true,false,true]) -> 3
	public int countTrues(List<Boolean> answers) {
		return -1;
	}

	//12. incrementAll([100, 17, 33]) -> [101, 18, 34]
	public List<Integer> incrementAll(List<Integer> numbers) {
		return null;
	}

	//13. echo(["Tech","Elevator"]) -> ["Tech","Tech","Elevator","Elevator"]
	public List<String> echo(List<String> words) {
		return null;
	}

}
