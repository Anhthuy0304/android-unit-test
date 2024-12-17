package com.techyourchance.unittestingfundamentals.example1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositiveNumberValidatorTMTest {

    private PositiveNumberValidator SUT;
    @Before
    public void setUp() throws Exception {
        SUT = new PositiveNumberValidator();
    }

    @Test
    public void testPositiveReturnTrue() {
        boolean ret = SUT.isPositive(7);
        Assert.assertTrue(ret);
    }
}