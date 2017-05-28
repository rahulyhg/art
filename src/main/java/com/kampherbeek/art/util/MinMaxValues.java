/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.util;


import lombok.Getter;
import lombok.NonNull;

public enum MinMaxValues {

//    GEO_LAT_DEC_MIN(-89.999999999),
    GEO_LAT_DEC_MAX(+90.999999999),
//    GEO_LAT_DEGREES_MIN(-89),
//    GEO_LAT_DEGREES_MAX(+89),
//    GEO_LAT_MINUTES_MIN(0),
    GEO_LAT_MINUTES_MAX(59),
//    GEO_LAT_SECONDS_MIN(0),
//    GEO_LAT_SECONDS_MAX(59),
//    GEO_LONG_DEC_MIN(-89.999999999),
//    GEO_LONG_DEC_MAX(+90.999999999),
//    GEO_LONG_DEGREES_MIN(-89),
//    GEO_LONG_DEGREES_MAX(+89),
//    GEO_LONG_MINUTES_MIN(0),
//    GEO_LONG_MINUTES_MAX(59),
//    GEO_LONG_SECONDS_MIN(0),
//    GEO_LONG_SECONDS_MAX(59),
//    HOURS_DEC_MIN(0.0),
//    HOURS_DEC_MAX(23.999999999),
    HOURS_MIN(0),
    HOURS_MAX(23),
    MINUTES_MIN(0),
    MINUTES_MAX(59),
    SECONDS_MIN(0),
    SECONDS_MAX(59),
    YEARS_MIN(-13200),  // astronomical years
    YEARS_MAX(17191);


    @Getter
    private int valueInt;
    @Getter
    private double valueDbl;

    MinMaxValues(@NonNull Object value) {
        if (value instanceof Integer) {
            this.valueInt = (int) value;
        } else if (value instanceof  Double) {
            this.valueDbl = (double) value;
        }
    }

}
