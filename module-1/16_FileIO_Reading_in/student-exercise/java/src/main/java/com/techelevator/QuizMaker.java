package com.techelevator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Where is the quiz file?");
		String file = userInput.nextLine();
		int counter = 1;
		int numberOfQuestions = 0;
		int numberCorrect = 0;


		Path quizInput = Paths.get(file); //find file
		List<QuizQuestion> quiz = new ArrayList<QuizQuestion>(); //make list to hold quiz questions

		try(Scanner readQuiz = new Scanner(quizInput)){ //scanner to read file
			while(readQuiz.hasNextLine()){ //while scanner can read another line in the file
				String line = readQuiz.nextLine(); //grab the line and store it in line
				String [] newLine = line.split("\\|"); //make an array with that line, break on pipe
				QuizQuestion newQuestion = new QuizQuestion(newLine); //make new question with constructor
				System.out.println(newQuestion.getQuestion()); // print the question
				for(String s : newQuestion.getAnswerChoices() ){ // iterate through the list of choices
					System.out.println(counter + ". " + s); //print each choice with a number in front
					counter ++; //add one to the counter for each choice
				}
				System.out.println("Your answer: ");
				String userAnswer = userInput.nextLine();
				numberOfQuestions++;

				if(Integer.parseInt(userAnswer) == newQuestion.getCorrectAnswer()){
					System.out.println("Correct!");
					numberCorrect++;
				}else{
					System.out.println("Incorrect");
				}
				counter = 1;


			}
			System.out.println("You got " + numberCorrect + " answers(s) correct out of the total " + numberOfQuestions + "asked.");

		}catch(IOException e){
			System.out.println("File not found");
		}



	}

}
