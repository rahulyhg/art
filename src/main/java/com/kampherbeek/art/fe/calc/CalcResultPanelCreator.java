package com.kampherbeek.art.fe.calc;


import lombok.NonNull;
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
    private ResourceBundle rb;


    public CalcResultPanelCreator() {
        Locale.setDefault(new Locale("en", "US"));  // TODO use config for Locale
        rb = ResourceBundle.getBundle("art_common");
    }

    public JPanel constructPanel() {
        resultPanel = new JPanel();
        panelTitleLabel = new JLabel(rb.getString("CALC.RESULT"));
        resultLabel = new JLabel("....");
        layoutComponents();
        return resultPanel;
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
