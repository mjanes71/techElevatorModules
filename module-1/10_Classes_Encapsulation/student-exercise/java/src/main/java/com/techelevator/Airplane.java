package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

   public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
       this.planeNumber = planeNumber;
       this.totalFirstClassSeats = totalFirstClassSeats;
       this.totalCoachSeats = totalCoachSeats;
   }

    public String getPlaneNumber(){
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableFirstClassSeats(){
       int availableFirstClassSeats = getTotalFirstClassSeats() - getBookedFirstClassSeats();
       return availableFirstClassSeats;
    }

    public int getAvailableCoachSeats(){
       int availableCoachSeats = getTotalCoachSeats() - getBookedCoachSeats();
       return availableCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
       boolean result = true;

       if(forFirstClass){
           boolean canBook = totalFirstClassSeats >= totalNumberOfSeats + bookedFirstClassSeats;
           if(canBook){
               this.bookedFirstClassSeats = getBookedFirstClassSeats() + totalNumberOfSeats;
           }else{
               result = false;
           }
       }else{
           boolean canBook = totalCoachSeats >= totalNumberOfSeats + bookedCoachSeats;
           if(canBook){
               this.bookedCoachSeats = getBookedCoachSeats() + totalNumberOfSeats;
               return result;
           }else{
               result = false;
           }
       }
       return result;


    }


}
