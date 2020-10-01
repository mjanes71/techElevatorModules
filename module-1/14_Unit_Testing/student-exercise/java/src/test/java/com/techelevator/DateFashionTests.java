package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTests {

    private static DateFashion sut = new DateFashion();

    @Test
    public void any_person_is_2_results_no() {
        int result = sut.getATable(2, 8);
        Assert.assertEquals(0, result);
    }

    @Test
    public void greater_than_8_results_yes(){
        int result = sut.getATable(9, 3);
        Assert.assertEquals(2, result);

    }

    @Test
    public void no_8_and_no_2_results_maybe(){
        int result = sut.getATable(3,4);
        Assert.assertEquals(1, result);
    }

//    @Test
//    public void null_returns_null(){
//        int result = sut.getATable();
//    }

    }


