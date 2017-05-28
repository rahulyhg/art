/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.controllers;


import com.kampherbeek.art.be.endpoints.VersionEndpoint;
import com.kampherbeek.art.domain.requests.GenericRequestNoPar;
import com.kampherbeek.art.domain.requests.Request;
import com.kampherbeek.art.domain.responses.VersionResponse;
import com.kampherbeek.art.fe.constants.FrameConstants;
import com.kampherbeek.art.fe.panels.MainInfoPanel;
import com.kampherbeek.art.fe.panels.MainNavPanel;
import com.kampherbeek.art.util.TextConstants;
import com.kampherbeek.art.util.TextProvider;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainController {

    private final MainInfoPanel infoPanel;
    @Getter
    private final MainNavPanel navPanel;
    @Getter
    private final CalcController calcController;
    @Getter
    private final ChartsController chartsController;
    private final VersionEndpoint versionEndpoint;
    private final TextProvider textProvider;

    @Autowired
    public MainController(@NonNull MainInfoPanel infoPanel,
                          @NonNull MainNavPanel navPanel,
                          @NonNull CalcController calcController,
                          @NonNull ChartsController chartsController,
                          @NonNull VersionEndpoint versionEndpoint,
                          @NonNull TextProvider textProvider) {
        this.infoPanel = infoPanel;
        this.navPanel = navPanel;
        this.calcController = calcController;
        this.chartsController = chartsController;
        this.versionEndpoint = versionEndpoint;
        this.textProvider = textProvider;
        this.navPanel.setController(this);
    }

    public void show() {
        constructFrame();

    }

    public void showCalc() {
        calcController.show();
    }

    public void showCharts() {
        chartsController.show();
    }

    private void constructFrame() {
        JFrame mainFrame = new JFrame(createTitle());
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(navPanel, BorderLayout.WEST);
        mainFrame.add(infoPanel, BorderLayout.CENTER);
        mainFrame.setSize(FrameConstants.DEFAULT_WIDTH.getSize(), FrameConstants.DEFAULT_HEIGHT.getSize());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private String createTitle() {
        Request request = new GenericRequestNoPar();
        VersionResponse response = (VersionResponse)versionEndpoint.handleRequest(request);
        return textProvider.getText("GENERAL.TITLE")
                + TextConstants.SPACE.getText() + TextConstants.DIVISON.getText() + TextConstants.SPACE.getText()
                + response.getVersion();
    }

}
