package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests {

    private static Less20 sut = new Less20();

    @Test
    public void multiple_of_20_returns_false(){
        boolean result = sut.isLessThanMultipleOf20(40);
        Assert.assertFalse(result);
    }

    @Test
    public void multiple_1_less_than_20_returns_true(){
        boolean result = sut.isLessThanMultipleOf20(39);
        Assert.assertTrue(result);
    }

    @Test
    public void multiple_2_less_than_20_returns_true(){
        boolean result = sut.isLessThanMultipleOf20(38);
        Assert.assertTrue(result);
    }

    @Test
    public void multiple_3_less_than_20_returns_false(){
        boolean result = sut.isLessThanMultipleOf20(37);
        Assert.assertFalse(result);
    }


}
