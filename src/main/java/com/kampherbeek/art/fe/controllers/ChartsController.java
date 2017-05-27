/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.controllers;


import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ChartsController {

    private JFrame frame;
    private JPanel panel;
    private final TextProvider textProvider;
    private JMenuBar menuBar;

    @Autowired
    public ChartsController(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
    }

    public void show() {
        constructFrame();
        constructMenu();
        layoutComponents();
    }

    private void constructFrame() {
        frame = new JFrame("Charts");
        frame.setSize(1000, 750);
        frame.setMinimumSize(new Dimension(800, 600));

    }

    private void constructMenu() {
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newChartItem = new JMenuItem("New Chart");
        JMenuItem openChartItem = new JMenuItem("Open Chart");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newChartItem);
        fileMenu.add(openChartItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
    }

    private void layoutComponents() {
        panel = new JPanel();
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

}


