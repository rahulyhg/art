/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.panels;

import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CalcResultPanel extends JPanel {

    private final TextProvider textProvider;
    private JLabel panelTitleLabel;
    private JTextArea resultTextArea;

    @Autowired
    public CalcResultPanel(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
        defineComponents();
        setLayout(new BorderLayout());
        add(panelTitleLabel, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
    }

    public void appendText(String text) {
        resultTextArea.append(text);
    }

    private void defineComponents() {
        panelTitleLabel = new JLabel(textProvider.getText("CALC.RESULT"));
        resultTextArea = new JTextArea();
    }

}
