package com.techelevator;

import java.math.BigDecimal;

public class FlowerShopOrder {

    // properties
    private String bouquetType;
    private int numberOfRoses;
    private BigDecimal subtotal;

//constructor
    public FlowerShopOrder(String bouquetType, int numberOfRoses){
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
        String roses = Integer.toString(numberOfRoses);
        subtotal = new BigDecimal("19.99").add((new BigDecimal("2.99").multiply(new BigDecimal(roses))));
    }

//getters
    public String getBouquetType(){
        return bouquetType;
    }

    public int getNumberOfRoses(){
        return numberOfRoses;
    }

    public BigDecimal getSubtotal(){
        return subtotal;
    }

    //calculate delivery total

    public BigDecimal calculateDeliveryTotal(boolean sameDayDelivery, String zipCode){
       int zipNumber = Integer.parseInt(zipCode);
       BigDecimal deliveryTotal = new BigDecimal("0.00");
        if (zipNumber > 39999 || (zipNumber >= 10000 && zipNumber <= 19999) ){
            if(zipNumber > 39999){
                deliveryTotal = deliveryTotal.add(new BigDecimal("19.99"));
            }else {
                deliveryTotal = deliveryTotal;
            }

        } else if(sameDayDelivery){
            if(zipNumber > 29999){
                deliveryTotal = deliveryTotal.add(new BigDecimal("12.98"));
            }else{
                deliveryTotal = deliveryTotal.add(new BigDecimal("9.98"));
            }

        }else {
            if(zipNumber > 29999){
                deliveryTotal = deliveryTotal.add(new BigDecimal("6.99"));
            }else {
                deliveryTotal = deliveryTotal.add(new BigDecimal("3.99"));
            }

        }
        return deliveryTotal;

    }

    @Override
    public String toString() {
        return "ORDER - " + getBouquetType() + " - " + getNumberOfRoses() + " Roses " +  "- " + getSubtotal();
    }
}
