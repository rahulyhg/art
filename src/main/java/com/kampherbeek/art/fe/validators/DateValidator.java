/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.validators;

import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.util.MinMaxValues;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import swisseph.SweDate;

@Component
public class DateValidator implements Validator{

    @Override
    public boolean validate(@NonNull Object obj) {
        return obj instanceof DateDto && checkIt((DateDto) obj);
    }

    private boolean checkIt(@NonNull DateDto dto) {
        return checkMinMax(dto) && checkExisting(dto);
    }

    private boolean checkMinMax(@NonNull DateDto dto) {
        return dto.getYear() >= MinMaxValues.YEARS_MIN.getValueInt()
                && dto.getYear() <= MinMaxValues.YEARS_MAX.getValueInt();
    }

    private boolean checkExisting(@NonNull DateDto dto) {
        double ut = 0.0;
        SweDate sweDate1 = new SweDate(dto.getYear(), dto.getMonth(), dto.getDay(), ut, dto.isGregorian());
        double jdnr = sweDate1.getJulDay();
        SweDate sweDate2 = new SweDate(jdnr);
        return (sweDate1.getYear() == sweDate2.getYear() &&
                sweDate1.getMonth() == sweDate2.getMonth() &&
                sweDate1.getDay() == sweDate2.getDay());
    }


}

