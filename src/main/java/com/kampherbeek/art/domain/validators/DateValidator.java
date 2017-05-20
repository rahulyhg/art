package com.kampherbeek.art.domain.validators;

import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.util.MinMaxValues;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import swisseph.SweDate;

@Component
public class DateValidator implements Validator{

    @Override
    public boolean validate(@NonNull Object obj) {
        if (obj instanceof DateDto) {
            return checkIt((DateDto)obj);
        }
        return false;
    }

    private boolean checkIt(@NonNull DateDto dto) {
        return checkMinMax(dto) && checkExisting(dto);
    }

    private boolean checkMinMax(DateDto dto) {
        return dto.getYear() >= MinMaxValues.YEARS_MIN.getValueInt()
                && dto.getYear() <= MinMaxValues.YEARS_MAX.getValueInt();
    }

    private boolean checkExisting(DateDto dto) {
        double ut = 0.0;
        SweDate sweDate1 = new SweDate(dto.getYear(), dto.getMonth(), dto.getDay(), ut, dto.isGregorian());
        double jdnr = sweDate1.getJulDay();
        SweDate sweDate2 = new SweDate(jdnr);
        return (sweDate1.getYear() == sweDate2.getYear() &&
                sweDate1.getMonth() == sweDate2.getMonth() &&
                sweDate1.getDay() == sweDate2.getDay());
    }


}

