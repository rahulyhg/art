/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.controllers;


import com.kampherbeek.art.fe.frames.MainFrame;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @Getter
    private final CalcController calcController;
    @Getter
    private final ChartsController chartsController;
    private final MainFrame mainFrame;

    @Autowired
    public MainController(@NonNull CalcController calcController,
                          @NonNull ChartsController chartsController,
                          @NonNull MainFrame mainFrame) {
        this.calcController = calcController;
        this.chartsController = chartsController;
        this.mainFrame = mainFrame;
        mainFrame.setController(this);
    }

    public void show() {
        mainFrame.setVisible(true);
    }

    public void showCalc() {
        calcController.show();
    }

    public void showCharts() {
        chartsController.show();
    }

}
