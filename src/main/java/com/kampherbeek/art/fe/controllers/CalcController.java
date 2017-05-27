/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.controllers;


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

    private JFrame calcFrame;
    private final TextProvider textProvider;
    @Getter
    private final CalcInputPanel inputPanel;
    @Getter
    private final CalcResultPanel resultPanel;

    @Autowired
    public CalcController(@NonNull CalcInputPanel inputPanel,
                          @NonNull CalcResultPanel resultPanel,
                          @NonNull TextProvider textProvider) {
        this.inputPanel = inputPanel;
        this.resultPanel = resultPanel;
        this.textProvider = textProvider;
        this.inputPanel.setController(this);
    }

    public void show() {
        constructFrame();

    }

    private void constructFrame() {
        calcFrame = new JFrame(textProvider.getText("CALC.TITLE"));
        layoutComponents();
        calcFrame.setSize(600,500);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);

    }

    private void layoutComponents() {
        calcFrame.setLayout(new BorderLayout());
        calcFrame.add(inputPanel, BorderLayout.WEST);
        calcFrame.add(resultPanel, BorderLayout.CENTER);
    }

}
