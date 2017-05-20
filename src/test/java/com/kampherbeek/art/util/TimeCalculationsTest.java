package com.kampherbeek.art.util;

import com.kampherbeek.art.TestConstants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeCalculationsTest {


    private final int hour = 11;
    private final int minute = 22;
    private final int second = 33;

    private TimeCalculations timeCalc;


    @Before
    public void setUp() throws Exception {
        timeCalc = new TimeCalculations();
    }

    @Test
    public void decimalTimeFromHMS() throws Exception {
        double expected = 11.37583333333333333;
        assertEquals(expected, timeCalc.decimalTimeFromHMS(hour, minute, second), TestConstants.FLOAT_MARGIN);


    }

}