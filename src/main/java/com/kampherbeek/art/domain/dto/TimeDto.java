/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.domain.dto;


import lombok.Data;

@Data
public class TimeDto implements ValidatedDto{
    private int hour;
    private int minute;
    private int second;
    private boolean valid;
}
