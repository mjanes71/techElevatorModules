package com.techelevator;

public class BankAccount {

    private static final int DEFAULT_BALANCE = 0;

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolderName, String accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = DEFAULT_BALANCE;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public int getBalance(){
        return balance;
    }

    public int deposit(int amountToDeposit){
        balance = amountToDeposit + getBalance();
        return getBalance();
    }

    public int withdraw(int amountToWithdraw){
        balance = getBalance() - amountToWithdraw;
        return getBalance();
    }
}
