/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.listeners;


import com.kampherbeek.art.be.endpoints.JdnrEndpoint;
import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import com.kampherbeek.art.domain.responses.JdnrResponse;
import com.kampherbeek.art.fe.converters.DateConverter;
import com.kampherbeek.art.fe.converters.TimeConverter;
import com.kampherbeek.art.fe.events.CalcInputEvent;
import com.kampherbeek.art.fe.panels.CalcResultPanel;
import com.kampherbeek.art.util.TextConstants;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CalcInputListener {

    private final DateConverter dateConverter;
    private final TimeConverter timeConverter;
    private final JdnrEndpoint jdnrEndpoint;

    @Autowired
    public CalcInputListener(@NonNull DateConverter dateConverter,
                             @NonNull TimeConverter timeConverter,
                             @NonNull JdnrEndpoint jdnrEndpoint) {
        this.dateConverter = dateConverter;
        this.timeConverter = timeConverter;
        this.jdnrEndpoint = jdnrEndpoint;
    }


    public void calcInputEventOccurred(@NonNull CalcInputEvent event) {
         handleEvent(event);
    }

    private void handleEvent(@NonNull CalcInputEvent event) {
        DateDto dateDto = dateConverter.convertDate(event.getDateText(), event.isGregorian());
        TimeDto timeDto = timeConverter.convertTime(event.getTimeText());
        StringBuilder result = new StringBuilder("Julian Day Number for ");
        result.append(event.getDateText());
        result.append(TextConstants.SPACE.getText());
        result.append(event.isGregorian()?"Gregorian":"Julian");
        result.append(event.getTimeText());
        result.append(TextConstants.COLON.getText());
        result.append(TextConstants.SPACE.getText());
        if (!dateDto.isValid()) {
            result.append("Error in date. ");
        }
        if (!timeDto.isValid()) {
            result.append("Error in time. ");
        }
        if (dateDto.isValid() && timeDto.isValid()) {
            JdnrRequest request = new JdnrRequest();
            request.setDateDto(dateDto);
            request.setTimeDto(timeDto);
            JdnrResponse response = (JdnrResponse) jdnrEndpoint.handleRequest(request);
            result.append(Double.toString(response.getJdnr()));
        }
        CalcResultPanel resultPanel = event.getResultPanel();
        resultPanel.appendText(result + TextConstants.NEW_LINE.getText());
    }
}
