package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTests {

    private static FrontTimes sut = new FrontTimes();

    @Test
    public void generateString_for_string_of_3plus_returns_3char(){
        String result = sut.generateString("Chocolate", 4);
        Assert.assertEquals("ChoChoChoCho", result);
    }

    @Test
    public void generateString_for_string_of_2plus_returns_2char(){
        String result = sut.generateString("Ka", 3);
        Assert.assertEquals("KaKaKa", result);
    }

    @Test
    public void generateString_for_string_of_1_returns_1char(){
        String result = sut.generateString("E",2);
        Assert.assertEquals("EE", result);
    }


}
