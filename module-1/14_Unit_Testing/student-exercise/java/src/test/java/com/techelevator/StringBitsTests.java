package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests {
    private static StringBits sut = new StringBits();

    @Test
    public void getBits_returns_every_other(){
        String result = sut.getBits("Hello");
        Assert.assertEquals("Hlo", result);
    }

    @Test
    public void getBits_length_1_returns_1(){
        String result = sut.getBits("H");
        Assert.assertEquals("H", result);
    }

    @Test
    public void getBits_length_2_returns_1(){
        String result = sut.getBits("He");
        Assert.assertEquals("H", result);
    }

    @Test
    public void getBits_emptyString_returns_emptyString(){
        String result = sut.getBits("");
        Assert.assertEquals("", result);
    }

}
