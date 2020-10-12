package com.techelevator.readfiles;

public class WordCounter {



    public int countWordsInLine(String line){ //ran tests on this method first before adding a while loop
        line = line.trim(); //trims leading and trailing spaces
        if (line.length() == 0){
            return 0;
        }else {
            String[] words = line.split(" +"); // this means "split on one or more spaces
            return words.length;
        }
    }

}
