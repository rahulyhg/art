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


@Component
public class MainInfoPanelCreator {

    private JPanel infoPanel;
    private JLabel textTitle;
    private JLabel textMain;
    private TextProvider textProvider;

    @Autowired
    public MainInfoPanelCreator(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
        defineComponents();
    }

    public JPanel constructPanel() {
        infoPanel = new JPanel();
        layoutComponents();
        return infoPanel;
    }


    private void defineComponents() {
        textTitle = new JLabel(textProvider.getText("MAIN.MAKESELECTION"));
        textMain = new JLabel("......");
    }

    private void layoutComponents() {
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(textTitle, BorderLayout.NORTH);
        infoPanel.add(textMain, BorderLayout.CENTER);
    }

}
