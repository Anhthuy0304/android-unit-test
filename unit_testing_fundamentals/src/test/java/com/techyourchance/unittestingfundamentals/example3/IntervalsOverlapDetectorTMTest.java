package com.techyourchance.unittestingfundamentals.example3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntervalsOverlapDetectorTMTest {

    IntervalsOverlapDetector SUT;

    @Before
    public void setup() {
        SUT = new IntervalsOverlapDetector();
    }

    @Test
    public void isOverlapped_interval1OverlapsInterval2_returnTrue () {
       Interval interval1 = new Interval(-5,5);
       Interval interval2 = new Interval(-4,4);
       boolean result = SUT.isOverlap(interval1,interval2);
        Assert.assertTrue(result);
    }
    @Test
    public void isOverlapped_interval1OverlapsInterval2_returnFalse () {
        Interval interval1 = new Interval(-5,5);
        Interval interval2 = new Interval(6,10);
        boolean result = SUT.isOverlap(interval1,interval2);
        Assert.assertFalse(result);
  }

    @Test
    public void isOverlapped_interval1ContainsInterval2_returnTrue () {
        Interval interval1 = new Interval(-5,5);
        Interval interval2 = new Interval(4,6);
        boolean result = SUT.isOverlap(interval1,interval2);
        Assert.assertTrue(result);
    }
    @Test
    public void isOverlapped_interval2ContainsInterval1_returnTrue () {
        Interval interval1 = new Interval(4,6);
        Interval interval2 = new Interval(-5,5);
        boolean result = SUT.isOverlap(interval1,interval2);
        Assert.assertTrue(result);
    }

    @Test
    public void isOverlapped_interval1AreInInterval2_returnTrue () {
        Interval interval1 = new Interval(-5,5);
        Interval interval2 = new Interval(-10,6);
        boolean result = SUT.isOverlap(interval1,interval2);
        Assert.assertTrue(result);
    }
    @Test
    public void isOverlapped_interval2AreInInterval1_returnTrue () {
        Interval interval1 = new Interval(-10,6);
        Interval interval2 = new Interval(-5,5);
        boolean result = SUT.isOverlap(interval1,interval2);
        Assert.assertTrue(result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void isOverlapped_withReversedInterval1AndReversedInInterval2_returnFalse () {
            Interval interval1 = new Interval(1,0);
            Interval interval2 = new Interval(1,-2);
            boolean result = SUT.isOverlap(interval1,interval2);
            Assert.assertThat(result,is(false));
    }
    @Test(expected = IllegalArgumentException.class)
    public void isOverlapped_withReversedInterval1AndInterval2_returnFalse () {
            Interval interval1 = new Interval(1, -1);
            Interval interval2 = new Interval(-2, 0);
            boolean result = SUT.isOverlap(interval1, interval2);
            Assert.assertThat(result, is(false));
    }
    @Test(expected = IllegalArgumentException.class)
    public void isOverlapped_withInterval1AndReversedInInterval2_returnFalse () {
        Interval interval1 = new Interval(0,1);
        Interval interval2 = new Interval(0,-2);
        boolean result = SUT.isOverlap(interval1, interval2);
        Assert.assertThat(result, is(false));

    }
}