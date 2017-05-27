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

    private final double MINUTES_PER_HOUR = 60.0;
    private final double SECONDS_PER_HOUR = 3600.0;

    public double decimalTimeFromHMS(int hour, int minute, int second) {
        return hour + minute / MINUTES_PER_HOUR + second / SECONDS_PER_HOUR;
    }

}
