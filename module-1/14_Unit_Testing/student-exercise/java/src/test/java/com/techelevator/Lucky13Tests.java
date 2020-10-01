package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Tests {

    private static Lucky13 sut = new Lucky13();
    int[] i;

    @Test
    public void array_with_ones_returns_false(){

        boolean result = sut.getLucky(i=new int[]{1,0,0});
        Assert.assertFalse(result);
    }

    @Test
    public void array_with_three_returns_false(){
        boolean result = sut.getLucky(i=new int[]{3,0,0});
        Assert.assertFalse(result);
    }

    @Test
    public void array_with_no_3_or_1_returns_true(){
        boolean result = sut.getLucky(i= new int[]{0,2,4});
        Assert.assertTrue(result);
    }


}
