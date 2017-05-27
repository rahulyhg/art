/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.validators;


import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.util.MinMaxValues;
import lombok.NonNull;
import org.springframework.stereotype.Component;

/**
 * Validator for TimeDto.
 */
@Component
public class TimeValidator implements Validator {

    /**
     * Performs the validation.<br/>
     *
     * @param obj the object to validate
     * @return true if obj is an instance of TimeDto, and hour is 0..23 and minute is 0..60 and second is 0..60.
     * Otherwise returns false.
     */
    @Override
    public boolean validate(@NonNull Object obj) {
        if (obj instanceof TimeDto) {
            return checkIt((TimeDto) obj);
        }
        return false;
    }

    private boolean checkIt(TimeDto dto) {
        return (dto.getHour() <= MinMaxValues.HOURS_MAX.getValueInt() &&
                        dto.getHour() >= MinMaxValues.HOURS_MIN.getValueInt() &&
                        dto.getMinute() <= MinMaxValues.MINUTES_MAX.getValueInt() &&
                        dto.getMinute() >= MinMaxValues.MINUTES_MIN.getValueInt() &&
                        dto.getSecond() <= MinMaxValues.SECONDS_MAX.getValueInt() &&
                        dto.getSecond() >= MinMaxValues.SECONDS_MIN.getValueInt());
    }

}

