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

    public DateDto convertDate(@NonNull final String input, boolean gregorian) {
        return convertIt(input, gregorian);

    }

    private DateDto convertIt(@NonNull final String input, boolean gregorian) {
        DateDto dto = new DateDto();
        final String separator = "-";
        // yyyy-mm-dd
        try {
            String[] splitted = input.split(separator);
            dto.setYear(Integer.parseInt(splitted[0]));
            dto.setMonth(Integer.parseInt(splitted[1]));
            dto.setDay(Integer.parseInt(splitted[2]));
            dto.setGregorian(gregorian);
            dto.setValid(validator.validate(dto));
        } catch (NumberFormatException e) {
            dto.setValid(false);
        }
        return dto;
    }
}
