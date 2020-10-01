package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Tests {

    private static MaxEnd3 sut = new MaxEnd3();
    int[] i;

    @Test
    public void makeArray_changes_to_all_first_when_first_bigger(){
        int[] result = sut.makeArray(i = new int[]{3,2,1});
        int[] expectedArray = new int[]{3,3,3};
        Assert.assertArrayEquals(expectedArray, result);
    }

    @Test
    public void makeArray_changes_to_all_last_when_last_bigger(){
        int[] result = sut.makeArray(i = new int[]{3, 4, 5});
        int[] expectedArray = new int[]{5, 5, 5};
        Assert.assertArrayEquals(expectedArray,result);
    }


}
