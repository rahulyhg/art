package com.kampherbeek.art.fe.main;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;


@Component
public class MainInfoPanelCreator {


    private ResourceBundle rb;
    JPanel infoPanel;

    public MainInfoPanelCreator() {
        Locale.setDefault(new Locale("en", "US"));  // TODO use config for Locale
        rb = ResourceBundle.getBundle("art_common");
    }

    public JPanel constructPanel() {
        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        JLabel textTitle = new JLabel(rb.getString("MAIN.MAKESELECTION"));
        JLabel textMain = new JLabel("......");
        infoPanel.add(textTitle, BorderLayout.NORTH);
        infoPanel.add(textMain, BorderLayout.CENTER);
        return infoPanel;
    }



}
