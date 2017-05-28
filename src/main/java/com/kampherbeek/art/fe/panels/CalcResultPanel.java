/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.panels;

import com.kampherbeek.art.fe.constants.PanelConstants;
import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

@Component
public class CalcResultPanel extends JPanel {

    private final TextProvider textProvider;
    private JTextArea resultTextArea;

    @Autowired
    public CalcResultPanel(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
        defineComponents();
        defineBorders();
        setLayout(new BorderLayout());
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
    }

    public void appendText(String text) {
        resultTextArea.append(text);
    }

    private void defineComponents() {

        resultTextArea = new JTextArea();
    }

    private void defineBorders() {
        String key = "CALC.TITLE.RESULTPANEL";
        Border innerBorder = BorderFactory.createTitledBorder(textProvider.getText(key));
        int size = PanelConstants.MEDIUM_BORDER_WIDTH.getSize();
        Border outerBorder = BorderFactory.createEmptyBorder(size, size, size, size);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

}
