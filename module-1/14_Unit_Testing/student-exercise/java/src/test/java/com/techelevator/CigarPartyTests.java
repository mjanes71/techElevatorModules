package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests {


private static CigarParty sut = new CigarParty();

    @Test
  public void cigar_party_is_less_than_40_returns_false()

    {
        Boolean result = sut.haveParty(39, true); //act
        Assert.assertFalse(false); // assert
    }

    @Test
    public void cigar_party_over_60_weekday_false(){
        Boolean result = sut.haveParty(61,false);
        Assert.assertFalse(result);
    }

    @Test
    public void cigar_party_over_60_weekend_true(){
        Boolean result = sut.haveParty(61, true);
        Assert.assertTrue(result);
    }

    @Test
    public void cigar_party_in_range_weeday_true(){
        boolean result = sut.haveParty(50,false);
        Assert.assertTrue(result);
    }










}
