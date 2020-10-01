package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests {

    private static NonStart sut = new NonStart();

    @Test
    public void getPartialString_length_3plus_results_concat_minus_first(){
        String result = sut.getPartialString("Hello", "There");
        Assert.assertEquals("ellohere", result);
    }

    @Test
    public void getPartialString_for_string_length_zero_for_a(){
        String result = sut.getPartialString("", "There");
        Assert.assertEquals("here", result);
    }

    @Test
    public void getPartialString_for_string_b_length_zero(){
        String result = sut.getPartialString("There", "");
        Assert.assertEquals("here", result);
    }
}
