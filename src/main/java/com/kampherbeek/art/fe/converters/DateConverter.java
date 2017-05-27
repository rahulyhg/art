/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.converters;


import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.fe.validators.DateValidator;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateConverter {

    private final DateValidator validator;

    @Autowired
    public DateConverter(@NonNull DateValidator validator) {
        this.validator = validator;
    }

    public DateDto convertDate(String input, boolean gregorian) {
        return convertIt(input, gregorian);

    }

    private DateDto convertIt(final String input, boolean gregorian) {
        DateDto dto = new DateDto();
        // yyyy-mm-dd
        try {
            String yearText = input.substring(0,4);
            String monthText = input.substring(5,7);
            String dayText = input.substring(8,10);
            dto.setYear(Integer.parseInt(yearText));
            dto.setMonth(Integer.parseInt(monthText));
            dto.setDay(Integer.parseInt(dayText));
            dto.setGregorian(gregorian);
            dto.setValid(validator.validate(dto));
        } catch (NumberFormatException e) {
            dto.setValid(false);
        }
        return dto;
    }
}
