/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.util;


import lombok.Getter;

public enum TimeConstants {

    MINUTES_PER_HOUR(60),
    SECONDS_PER_HOUR(3600);

    @Getter
    private int value;

    TimeConstants(int value) {
        this.value = value;
    }

}
