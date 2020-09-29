package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
//       return (Accountable[]) accounts.toArray();
        Accountable[]  currentAccounts = new Accountable[accounts.size()]; //make empty array same size as list
        for( int i = 0; i < accounts.size(); i++){
            currentAccounts[i] = accounts.get(i);
        }
        return currentAccounts;

    }

    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);
    }

    public boolean isVip(){
        
        int totalCredits = 0;
        for(Accountable account : accounts){
            totalCredits = totalCredits +account.getBalance();
        }
        return totalCredits >= 25000;

    }


}
