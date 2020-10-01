package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTests {

    private static AnimalGroupName sut = new AnimalGroupName();

    @Test
    public void getHerd_null_returns_unknown(){
        String result = sut.getHerd(null);
        Assert.assertEquals("unknown", result);
    }

    @Test
    public void getHerd_unknown_returns_unknown(){
        String result = sut.getHerd("Hyena");
        Assert.assertEquals("unknown", result);
    }

    @Test
    public void getHerd_known_returns_known(){
        String result = sut.getHerd("Lion");
        Assert.assertEquals("Pride", result);
    }

    @Test
    public void getHerd_uppercase_known_returns_known(){
        String result = sut.getHerd("LION");
        Assert.assertEquals("Pride", result);
    }




}
