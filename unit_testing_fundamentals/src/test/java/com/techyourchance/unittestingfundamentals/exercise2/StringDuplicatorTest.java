package com.techyourchance.unittestingfundamentals.exercise2;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringDuplicatorTest {
        StringDuplicator SUT;

        @Before
        public void setup() throws Exception {
            SUT = new StringDuplicator();
        }
        @Test
        public void isDuplicated_duplicateSingleCharacter_returnCorrect() {
            String value = SUT.duplicate("a");
            assertThat(value, is("aa"));
        }
        @Test
        public void isDuplicated_duplicateText_returnCorrect(){
            String value = SUT.duplicate("Thuy");
            assertThat(value,is("ThuyThuy"));
        }
        @Test
        public void isDuplicated_duplicateEmptyString_returnCorrect(){
            String value = SUT.duplicate("");
            assertThat(value, is(""));
        }
    @Test
    public void isDuplicated_duplicateNull_returnCorrect(){
        String value = SUT.duplicate(null);
        Assert.assertNull(value);
    }
    }
