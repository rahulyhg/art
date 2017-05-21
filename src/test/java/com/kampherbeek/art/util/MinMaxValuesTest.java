/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinMaxValuesTest {


    @Test
    public void getValueInt() throws Exception {
        try {
            int result = MinMaxValues.GEO_LAT_MINUTES_MAX.getValueInt();
            assertTrue("No exception occurred.",true);
        } catch(Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

    @Test
    public void getValueDbl() throws Exception {
        try {
            double result = MinMaxValues.GEO_LAT_DEC_MAX.getValueDbl();
            assertTrue("No exception occurred.",true);
        } catch(Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }


}