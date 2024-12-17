package com.techyourchance.unittestingfundamentals.exercise3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import com.techyourchance.unittestingfundamentals.example3.Interval;
public class IntervalsAdjacencyDetectorTest {
    IntervalsAdjacencyDetector SUT;

    @Before
    public void setup() throws Exception {
        SUT = new IntervalsAdjacencyDetector();
    }
    @Test
    public void isAdjacency_withInterval1AndInterval2_returnTrue () {
        Interval interval1 = new Interval(1,5);
        Interval interval2 = new Interval(5,10);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(true));
    }
    @Test
    public void isAdjacency_withInterval1AndInterval2_ValuesInInterval1IsGreaterThanOnesInInterval2_returnTrue () {
        Interval interval1 = new Interval(5,10);
        Interval interval2 = new Interval(1,5);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(true));
    }

    @Test
    public void isAdjacency_withInterval1AndInterval2_returnFalse () {
        Interval interval1 = new Interval(1,5);
        Interval interval2 = new Interval(6,10);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
    }
    @Test
    public void isAdjacency_withInterval1AndInterval2_ValuesInInterval1IsGreaterThanOnesInInterval2_returnFalse () {
        Interval interval1 = new Interval(6,10);
        Interval interval2 = new Interval(1,5);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
    }
    @Test
    public void isAdjacency_withInterval1IsOverlappedByInterval2_returnFalse () {
        Interval interval1 = new Interval(1,5);
        Interval interval2 = new Interval(1,10);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
    }
    @Test
    public void isAdjacency_withInterval1ContainsInterval2_returnFalse () {
        Interval interval1 = new Interval(1,10);
        Interval interval2 = new Interval(3,5);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
    }
    @Test
    public void isAdjacency_withInterval1ContainsInterval2_ValuesInInterval1IsGreaterThanOnesInInterval2_returnFalse () {
        Interval interval1 = new Interval(3,5);
        Interval interval2 = new Interval(1,10);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
    }
    @Test
    public void isAdjacency_withInterval1EqualsInterval2_returnTrue () {
        Interval interval1 = new Interval(-1,10);
        Interval interval2 = new Interval(-1,10);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(true));
    }
    @Test
    public void isAdjacency_withSameOnStartAndOnEndInInterval1AndInterval2_returnFalse () {
        Interval interval1 = new Interval(-1,-1);
        Interval interval2 = new Interval(0,2);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
    }
    @Test
    public void isAdjacency_withInterval1OnEndEqualsOnStartInterval2AndSameStartAndEndInInterval2_returnTrue () {
        Interval interval1 = new Interval(-3,-1);
        Interval interval2 = new Interval(-1,-1);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(true));
    }
    @Test
    public void isAdjacency_withInterval1OnEndIsGreaterThanOnStartInterval2AndSameStartAndEndInInterval2_returnFalse () {
        Interval interval1 = new Interval(-3,-1);
        Interval interval2 = new Interval(0,0);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
    }

    @Test
    public void isAdjacency_withReversedInterval1AndInterval2_returnFalse () {
        try {
            Interval interval1 = new Interval(1, -1);
            Interval interval2 = new Interval(-1, 0);
            boolean result = SUT.isAdjacent(interval1, interval2);
            Assert.assertThat(result, is(false));
        } catch (IllegalArgumentException e)  {
            Assert.assertTrue(e.getMessage().contains("invalid interval range"));
        }
    }
    @Test
    public void isAdjacency_withInterval1AndReversedInInterval2_returnFalse () {
        try {
        Interval interval1 = new Interval(0,1);
        Interval interval2 = new Interval(0,-2);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
        } catch (IllegalArgumentException e)  {
            Assert.assertTrue(e.getMessage().contains("invalid interval range"));
        }
    }

    @Test
    public void isAdjacency_withReversedInterval1AndReversedInInterval2_returnFalse () {
        try {
        Interval interval1 = new Interval(1,0);
        Interval interval2 = new Interval(0,-2);
        boolean result = SUT.isAdjacent(interval1,interval2);
        Assert.assertThat(result,is(false));
        } catch (IllegalArgumentException e)  {
            Assert.assertTrue(e.getMessage().contains("invalid interval range"));
        }
    }
}