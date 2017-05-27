/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.calc;


import com.kampherbeek.art.be.endpoints.JdnrEndpoint;
import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import com.kampherbeek.art.domain.responses.JdnrResponse;
import com.kampherbeek.art.fe.converters.DateConverter;
import com.kampherbeek.art.fe.converters.TimeConverter;
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


    public void calcInputEventOccurred(CalcInputEvent event) {
         handleEvent(event.getSource(), event);
    };

    private void handleEvent(Object action, CalcInputEvent event) {
        DateDto dateDto = dateConverter.convertDate(event.getDateText(), true);
        TimeDto timeDto = timeConverter.convertTime(event.getTimeText());
        if (!dateDto.isValid()) {
            System.out.println("Error in date");
        }
        if (!timeDto.isValid()) {
            System.out.println("Error in time");
        }
        if (dateDto.isValid() && timeDto.isValid()) {
            JdnrRequest request = new JdnrRequest();
            request.setDateDto(dateDto);
            request.setTimeDto(timeDto);
            JdnrResponse response = (JdnrResponse) jdnrEndpoint.handleRequest(request);
            System.out.println("JDNR: " + response.getJdnr());
            CalcResultPanel resultPanel = event.getResultPanel();
            resultPanel.appendText(Double.toString(response.getJdnr()) + TextConstants.NEW_LINE.getText());
        }
    }
}
