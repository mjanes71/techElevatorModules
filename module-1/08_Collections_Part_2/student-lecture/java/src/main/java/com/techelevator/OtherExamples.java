package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OtherExamples {
    public static void  main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(10);
        numbers.add(4096);
        numbers.add(10);
        System.out.println(numbers);
// Prints every value, in the order it was entered into the list
        Set<Integer> moreNumbers = new HashSet<>();
        moreNumbers.add(12);
        moreNumbers.add(10);
        moreNumbers.add(4096);
        moreNumbers.add(10);
        System.out.println(moreNumbers);
// Prints each value only once (not duplicates) and not in the same order they are entered (stored in a hash)
//If I care about the order, I should use LinkedHashSet instead of HashSet
//If I care about sorting items to a "natural order" (alphabetical, or lowest to highest) use TreeSet


    }
}
