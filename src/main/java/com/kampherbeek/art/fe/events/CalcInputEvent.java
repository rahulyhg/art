/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.events;

import com.kampherbeek.art.fe.panels.CalcResultPanel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.EventObject;

@EqualsAndHashCode(callSuper = true)
@Data
public class CalcInputEvent extends EventObject {

    private String dateText;
    private String timeText;
    private String latitudeText;
    private String longitudeText;
    private CalcResultPanel resultPanel;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CalcInputEvent(@NonNull Object source,
                          @NonNull String dateText, @NonNull String timeText,
                          @NonNull String latitudeText, @NonNull String longitudeText,
                          @NonNull CalcResultPanel resultPanel) {
        super(source);
        this.dateText = dateText;
        this.timeText = timeText;
        this.latitudeText = latitudeText;
        this.longitudeText = longitudeText;
        this.resultPanel = resultPanel;
    }
}
