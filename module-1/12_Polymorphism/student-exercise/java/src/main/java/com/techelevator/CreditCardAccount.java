package com.techelevator;

public class CreditCardAccount implements Accountable {

   private static final int DEFAULT_BALANCE = 0;

    private String accountHolder;
    private String accountNumber;
    private int debt;

   public CreditCardAccount(String accountHolder, String accountNumber){
       this.accountHolder = accountHolder;
       this.accountNumber = accountNumber;
       this.debt = DEFAULT_BALANCE;
   }

    public String getAccountHolder(){
        return accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public int getDebt(){
        return debt;
    }

    @Override
    public int getBalance() {
        return -debt; //returns debt as a negative value because debt on a CC = the balance
    }

    public int pay(int amountToPay){
       debt = getDebt() - amountToPay;
       return getDebt();
    }

    public int charge(int amountToCharge){
       debt = getDebt() + amountToCharge;
       return getDebt();
    }
}
