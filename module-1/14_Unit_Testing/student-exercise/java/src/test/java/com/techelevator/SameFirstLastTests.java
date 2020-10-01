package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests {
    private static SameFirstLast sut = new SameFirstLast();
    int[] i = new int[0];

    @Test
    public void isItTheSame_length_0_returns_false(){
        boolean result = sut.isItTheSame(i);
        Assert.assertFalse(result);

    }

    @Test
    public void isItTheSame_length_1_returns_true(){
        boolean result = sut.isItTheSame(i = new int[]{1});
        Assert.assertTrue(result);
    }

    @Test
    public void isItTheSame_firstLast_not_same_returns_false(){
        boolean result = sut.isItTheSame(i = new int[]{1,2,3});
        Assert.assertFalse(result);
    }

    @Test
    public void isItTheSame_firstLast_same_returns_true(){
        boolean result = sut.isItTheSame(i = new int[]{1,2,1});
        Assert.assertTrue(result);
    }
}
