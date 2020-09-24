package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks; //do this b/c there is no setter so we set it directly
        this.submitterName = submitterName;
    }

    public int getEarnedMarks(){
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks(){
        return possibleMarks;
    }

    public String getSubmitterName(){
        return submitterName;
    }

    public String getLetterGrade(){
        double percentage = (double)getEarnedMarks() / (double)getPossibleMarks() *100;
        int percentageInt = (int) percentage;
        String letterGrade;
        if(percentageInt >= 90){
            letterGrade = "A";
        }else if (percentageInt >=80){
            letterGrade = "B";
        }else if (percentageInt >=70){
            letterGrade = "C";
        }else if (percentageInt >= 60){
            letterGrade = "D";
        }else{
            letterGrade = "F";
        }

        return letterGrade;
    }


}
