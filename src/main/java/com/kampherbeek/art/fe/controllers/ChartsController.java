/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.controllers;


import com.kampherbeek.art.fe.constants.FrameConstants;
import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ChartsController {

    private JFrame frame;
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
        frame = new JFrame(textProvider.getText("CHARTS.TITLE_FRAME"));
        frame.setSize(FrameConstants.DEFAULT_WIDTH.getSize(), FrameConstants.DEFAULT_HEIGHT.getSize());
        frame.setMinimumSize(new Dimension(FrameConstants.DEFAULT_MINIMUM_WIDTH.getSize(),
                FrameConstants.DEFAULT_MINIMUM_HEIGHT.getSize()));

    }

    private void constructMenu() {
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu(textProvider.getText("MENU.FILE"));
        JMenuItem newChartItem = new JMenuItem(textProvider.getText("MENU.FILE.NEWCHART"));
        JMenuItem openChartItem = new JMenuItem(textProvider.getText("MENU.FILE.OPENCHART"));
        JMenuItem exitItem = new JMenuItem(textProvider.getText("MENU.FILE.EXIT"));
        fileMenu.add(newChartItem);
        fileMenu.add(openChartItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
    }

    private void layoutComponents() {
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

}


