package com.techelevator;


import java.util.*;

public class Lecture {

    //1. removeDuplicates([1,2,1,1,2,1,2]) -> [1,2] or [2,1]
    public List<Integer> removeDuplicates(List<Integer> input) {
        Set<Integer> noDuplicates = new HashSet<>(input);//creates new set and inserts values from input
        return new ArrayList<>(noDuplicates); //creates and returns a new List with the values from noDuplicates
    }

    //2. musicalGroupNames() -> {2="duo",3="trio",4="quartet"}
    public Map<Integer,String> musicalGroupNames() {
        Map<Integer, String> musicalGroups = new HashMap<>();
        musicalGroups.put(2, "duo");
        musicalGroups.put(3, "trio");
        musicalGroups.put(4, "quartet");

        return musicalGroups;
    }

    //3. coinValues() -> {"penny"=1,"nickel"=5,"dime"=10,"quarter"=25}
    public Map<String,Integer> coinValues() {
        Map<String,Integer> result = new HashMap<>();
        result.put("penny", 1);
        result.put("nickel", 5);
        result.put("dime" , 10);
        result.put("quarter" , 25);

        return result;
    }

    //4. describeGroup(3, "violin") -> "violin trio"
    //   describeGroup(0, "trumpet") -> "trumpet group"
    public String describeGroup(int count, String instrument) {
        Map<Integer,String> groups = musicalGroupNames(); //creates a Map called group by calling the method from #2
        String groupName = groups.get(count); //creates variable groupName that gets the group name value when passed an int
        String result = "";
        if(groupName != null) { // if the groupname exists in our Map
            result = instrument + " " + groups.get(count); //result is instrument passed, plus a space, plus the value in the map that corresponds to count passed in
        }else{
            result = instrument + " group"; //if groupname doesn't exist in the map, just return instrument, plus space, plus the word group
        }
        return result;

    }

    //5. totalCents({"nickel","quarter","penny","penny"}) -> 32
    public int totalCents(String[] coins) {
        Map<String,Integer> values = coinValues();
        int total = 0;
        for(String s: coins){ // iterate through the array "coins" being passed in
            int theCoinValue = values.get(s); //get the value of the coin from the values Map we created using a previous method
            total = total + theCoinValue; // add the value found in the map to the total
        }
        return total;


    }

    //6. validCoin("dime") -> "valid"
    //   validCoin("token") -> "invalid"
    public String validCoin(String coin) {
        Map<String,Integer> monies = coinValues();
        boolean valid = monies.containsKey(coin);
        String result;

        if(valid){
            result = "valid";
        } else {
            result = "invalid";
        }
        return result;
    }

    //7. stateNames({"Ohio"="Columbus","Kentucky"="Frankfort","Indiana"="Indianapolis"})
    //             -> ["Ohio","Kentucky","Indianapolis"]
    public List<String> stateNames(Map<String,String> capitals) {
        List<String> states = new ArrayList<>(capitals.keySet());
        return states; //.keySet just returns a list of the keys from the map (not the attached values)

    }

    //8. availableColors({"red"=true,"blue"=false,"green"=true,"yellow"=true,"gray"=false})
    //                  -> ["red","green","yellow"]
    public List<String> availableColors(Map<String,Boolean> availability) {
        List<String> result = new ArrayList<>();

        for(Map.Entry<String,Boolean> entry : availability.entrySet()){
            if(entry.getValue() == true){
                result.add(entry.getKey());
            }

        }
        return result;
    }

    //9. addBonus({"Player 1"=5000,"Player 2"=2500,"Player 3"=4500}, 500)
    //         -> {"Player 1"=5500,"Player 2"=3000,"Player 3"=5000}
    public void addBonus(Map<String,Integer> scores, int bonus) {
        for(Map.Entry<String,Integer> playerScore : scores.entrySet()){
            int newScore = playerScore.getValue() + bonus;
            playerScore.setValue(newScore);
        }

    }

}
