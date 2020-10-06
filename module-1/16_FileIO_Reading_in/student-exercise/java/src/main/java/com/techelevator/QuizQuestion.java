package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion {

    private String question;
    private List<String> answerChoices = new ArrayList<>();
    private int correctAnswer;


    public QuizQuestion(String[] line){
        for (int i = 0; i < line.length; i++) {
            if (i == 0) {
                question = line[i];
            } else if (line[i].contains("*")) {
                correctAnswer = i;
                answerChoices.add(line[i].replace("*", ""));

            } else {
                answerChoices.add(line[i]);
            }
        }

    }
    public String getQuestion(){
        return question;

    }

    public List<String> getAnswerChoices(){
        return answerChoices;
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }



}
