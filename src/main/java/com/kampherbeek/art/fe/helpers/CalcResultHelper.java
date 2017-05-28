/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.helpers;


import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.fe.events.CalcInputEvent;
import com.kampherbeek.art.util.TextConstants;
import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalcResultHelper {

    private final TextProvider textProvider;

    @Autowired
    public CalcResultHelper(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
    }

    public String constructJdnrResult(@NonNull CalcInputEvent event,
                                      @NonNull DateDto dateDto, @NonNull TimeDto timeDto, double jdnr) {
        String firstKey = "CALC.JDNR.RESULT";
        return constructDateTimeResultText(firstKey, event, dateDto, timeDto, jdnr);
    }

    private String constructDateTimeResultText(@NonNull String firstKey, @NonNull CalcInputEvent event,
                                      @NonNull DateDto dateDto, @NonNull TimeDto timeDto, double value) {

        StringBuilder result = new StringBuilder(textProvider.getText(firstKey));
        result.append(TextConstants.SPACE.getText());
        String key = "GENERAL.CALENDAR.GREGORIAN";
        String GREGORIAN = textProvider.getText(key);
        key = "GENERAL.CALENDAR.JULIAN";
        String JULIAN = textProvider.getText(key);
        result.append(event.getDateText());
        result.append(TextConstants.SPACE.getText());

        result.append(event.isGregorian()?GREGORIAN:JULIAN);
        result.append(TextConstants.SPACE.getText());
        result.append(event.getTimeText());
        result.append(TextConstants.COLON.getText());
        result.append(TextConstants.SPACE.getText());
        if (!dateDto.isValid()) {
            key = "ERROR.DATE";
            result.append(textProvider.getText(key)).append(TextConstants.SPACE.getText());
        }
        if (!timeDto.isValid()) {
            key = "ERROR.TIME";
            result.append(textProvider.getText(key)).append(TextConstants.SPACE.getText());
        }
        if (dateDto.isValid() && timeDto.isValid()) {
            result.append(Double.toString(value));
        }
        return result.toString();
    }

}
