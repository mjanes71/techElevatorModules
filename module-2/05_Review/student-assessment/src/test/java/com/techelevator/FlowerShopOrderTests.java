package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FlowerShopOrderTests {

    @Test
    public void zip_of_10001_no_delivery_fee(){
        FlowerShopOrder sut = new FlowerShopOrder("Elegant", 10);
        BigDecimal result = sut.calculateDeliveryTotal(true, "10001");
        BigDecimal expectedResult = new BigDecimal("0.00");
        Assert.assertEquals(expectedResult,result);

    }

    @Test
    public void zip_of_40000_gives_1999_deliveryfee(){
        FlowerShopOrder sut = new FlowerShopOrder("Elegant", 10);
        BigDecimal result = sut.calculateDeliveryTotal(true, "40000");
        BigDecimal expectedResult = new BigDecimal("19.99");
        Assert.assertEquals(expectedResult,result);

    }

    @Test
    public void zip_of_30001_and_true_gives_1298_deliveryfee(){
        FlowerShopOrder sut = new FlowerShopOrder("Elegant", 10);
        BigDecimal result = sut.calculateDeliveryTotal(true, "30001");
        BigDecimal expectedResult = new BigDecimal("12.98");
        Assert.assertEquals(expectedResult,result);

    }

    @Test
    public void bouquet_of_1_rose_is_2298(){
        FlowerShopOrder sut = new FlowerShopOrder("Elegant", 1);
        BigDecimal expectedResult = new BigDecimal("22.98");
        Assert.assertEquals(expectedResult, sut.getSubtotal());
    }

    @Test
    public void bouquet_of_5_rose_is_3494(){
        FlowerShopOrder sut = new FlowerShopOrder("Elegant", 5);
        BigDecimal expectedResult = new BigDecimal("34.94");
        Assert.assertEquals(expectedResult, sut.getSubtotal());
    }
}
