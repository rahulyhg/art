/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.controllers;


import com.kampherbeek.art.fe.calc.CalcInputEvent;
import com.kampherbeek.art.fe.calc.CalcInputListener;
import com.kampherbeek.art.fe.panelcreators.CalcInputPanelCreator;
import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;


@Component
public class CalcController {

    private JFrame calcFrame;
    private JPanel inputPanel;
    private JPanel resultPanel;


    private final TextProvider textProvider;
    private final CalcInputPanelCreator inputPanelCreator;
    @Autowired
    public CalcController(@NonNull CalcInputPanelCreator inputPanelCreator, @NonNull TextProvider textProvider) {
        this.inputPanelCreator = inputPanelCreator;
        this.textProvider = textProvider;
    }

    public void show() {
        constructFrame();

    }


    // TODO retrieve text from backend
    private void constructFrame() {
        if (inputPanel == null)  {
            inputPanel = inputPanelCreator.constructPanel(new CalcInputListener() {
                public void calcInputEventOccurred(CalcInputEvent event) {

                }
            });
        }

        calcFrame = new JFrame(textProvider.getText("CALC.TITLE"));
        layoutComponents();
        calcFrame.setSize(600,500);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);

    }


    private void layoutComponents() {
        calcFrame.setLayout(new BorderLayout());
        calcFrame.add(inputPanel, BorderLayout.WEST);
//        mainFrame.add(infoPanel, BorderLayout.CENTER);
    }

}

