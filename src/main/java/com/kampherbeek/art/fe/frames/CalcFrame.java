/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.frames;


import com.kampherbeek.art.fe.constants.FrameConstants;
import com.kampherbeek.art.fe.controllers.CalcController;
import com.kampherbeek.art.fe.panels.CalcInputPanel;
import com.kampherbeek.art.fe.panels.CalcResultPanel;
import com.kampherbeek.art.util.TextProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CalcFrame extends JFrame {

    private final TextProvider textProvider;
    @Getter @NonNull
    private final CalcInputPanel inputPanel;
    @Getter @NonNull
    private final CalcResultPanel resultPanel;
    private CalcController controller;

    @Autowired
    public CalcFrame(@NonNull TextProvider textProvider,
                     @NonNull CalcInputPanel inputPanel,
                     @NonNull CalcResultPanel resultPanel) {
        this.textProvider = textProvider;
        this.inputPanel = inputPanel;
        this.resultPanel = resultPanel;
        constructFrame();
    }

    public void setController(@NonNull CalcController controller) {
        this.controller = controller;
        inputPanel.setController(controller);
    }

    private void constructFrame() {
        this.setTitle(textProvider.getText("CALC.TITLE"));
        layoutComponents();
        setSize(FrameConstants.DEFAULT_WIDTH.getSize(), FrameConstants.DEFAULT_HEIGHT.getSize());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.WEST);
        add(resultPanel, BorderLayout.CENTER);
    }


}
