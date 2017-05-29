/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.controllers;


import com.kampherbeek.art.fe.constants.FrameConstants;
import com.kampherbeek.art.fe.frames.CalcFrame;
import com.kampherbeek.art.fe.panels.CalcInputPanel;
import com.kampherbeek.art.fe.panels.CalcResultPanel;
import com.kampherbeek.art.util.TextProvider;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;


@Component
public class CalcController {

    private final CalcFrame calcFrame;

    @Autowired
    public CalcController(@NonNull CalcFrame calcFrame,
                          @NonNull TextProvider textProvider) {
        this.calcFrame = calcFrame;
        calcFrame.setController(this);
    }

    public void show() {
        calcFrame.setVisible(true);
    }

    public void addResult(@NonNull String result) {
        calcFrame.getResultPanel().appendText(result);
    }


}
