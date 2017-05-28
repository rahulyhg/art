/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.converters;

import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.fe.validators.TimeValidator;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeConverter {

    private final TimeValidator validator;

    @Autowired
    public TimeConverter(@NonNull TimeValidator validator) {
        this.validator = validator;
    }

    public TimeDto convertTime(String input) {
        return convertIt(input);
    }


    private TimeDto convertIt(String input) {
        TimeDto dto = new TimeDto();
        final String separator = ":";
        // hh:mm:ss
        try {
            String[] splitted = input.split(separator);
            dto.setHour(Integer.parseInt(splitted[0]));
            dto.setMinute(Integer.parseInt(splitted[1]));
            if (splitted.length > 2) {              // input for seconds available
                dto.setSecond(Integer.parseInt(splitted[2]));
            } else {
                dto.setSecond(0);
            }
            dto.setValid(validator.validate(dto));
        } catch (NumberFormatException e) {
            dto.setValid(false);
        }
        return dto;
    }
}
