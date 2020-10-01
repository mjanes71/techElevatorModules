package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTests {

    private static WordCount sut = new WordCount();
    String[] s = new String[0];
    Map<String, Integer> m = new HashMap<>();

    @Test
    public void getCount_emptyArray_returns_emptyMap(){
        m = sut.getCount(s);
        Map<String,Integer> expectedMap = new HashMap<>();
        Assert.assertEquals(expectedMap,m);
    }

    @Test
    public void getCount_each_appears_once_all_values_1(){
        m = sut.getCount(s = new String[]{"Ba", "Black", "Sheep"});
        Map<String,Integer> expectedMap = new HashMap<>();
        expectedMap.put("Ba", 1);
        expectedMap.put("Black", 1);
        expectedMap.put("Sheep", 1);
        Assert.assertEquals(expectedMap, m);
    }

    @Test
    public void getCoutn_each_appears_twice_all_values_2(){
        m = sut.getCount(s = new String[]{"Ba", "Ba", "Black", "Black"});
        Map<String,Integer> expectedMap = new HashMap<>();
        expectedMap.put("Ba", 2);
        expectedMap.put("Black", 2);
        Assert.assertEquals(expectedMap, m);
    }

    @Test
    public void getCount_same_word_appears_4_times(){
        m = sut.getCount(s = new String[]{"Ba", "Ba", "Ba"});
        Map<String,Integer> expectedMap = new HashMap<>();
        expectedMap.put("Ba", 3);
        Assert.assertEquals(expectedMap,m);
    }

}
