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
public class MainInfoPanel extends JPanel {

    private JLabel textTitle;
    private JLabel textMain;
    private final TextProvider textProvider;

    @Autowired
    public MainInfoPanel(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
        defineComponents();
        layoutComponents();
    }

    private void defineComponents() {
        textTitle = new JLabel(textProvider.getText("MAIN.MAKESELECTION"));
        textMain = new JLabel("......");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(textTitle, BorderLayout.NORTH);
        add(textMain, BorderLayout.CENTER);
    }

}

