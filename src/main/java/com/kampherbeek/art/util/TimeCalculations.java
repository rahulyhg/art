/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.util;


import org.springframework.stereotype.Component;

/**
 * Utility class to support time calculations.
 */
@Component
public class TimeCalculations {

    public double decimalTimeFromHMS(int hour, int minute, int second) {
        return hour + minute / (double)TimeConstants.MINUTES_PER_HOUR.getValue()
                + second / (double)TimeConstants.SECONDS_PER_HOUR.getValue();

    }

}
