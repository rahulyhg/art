/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.panelcreators;


import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class CalcResultPanelCreator {

    private JPanel resultPanel;
    private JLabel panelTitleLabel;
    private JLabel resultLabel;
    private final TextProvider textProvider;


    @Autowired
    public CalcResultPanelCreator(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
        defineComponents();
    }

    public JPanel constructPanel() {
        resultPanel = new JPanel();
        layoutComponents();
        return resultPanel;
    }


    private void defineComponents() {
        panelTitleLabel = new JLabel(textProvider.getText("CALC.RESULT"));
        resultLabel = new JLabel("....");
    }


    public void layoutComponents() {
        resultPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 5, 0, 0);
        resultPanel.add(panelTitleLabel, gc);

        // next row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 5);
        resultPanel.add(resultLabel, gc);

    }

}
