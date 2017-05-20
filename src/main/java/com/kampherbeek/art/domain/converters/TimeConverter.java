package com.kampherbeek.art.domain.converters;

import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.domain.validators.TimeValidator;
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
        // hh:mm:ss
        try {
            String hourText = input.substring(0,2);
            String minuteText = input.substring(3,5);
            String secondText = input.substring(6);
            dto.setHour(Integer.parseInt(hourText));
            dto.setMinute(Integer.parseInt(minuteText));
            dto.setSecond(Integer.parseInt(secondText));
            dto.setValid(validator.validate(dto));
        } catch (NumberFormatException e) {
            dto.setValid(false);
        }
        return dto;
    }
}
