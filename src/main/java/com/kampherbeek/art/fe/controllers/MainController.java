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
import com.kampherbeek.art.fe.panels.MainInfoPanel;
import com.kampherbeek.art.fe.panels.MainNavPanel;
import com.kampherbeek.art.fe.panels.MainNavPanelCreator;
import com.kampherbeek.art.fe.main.MainNavigationEvent;
import com.kampherbeek.art.fe.main.MainNavigationListener;
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

    private JFrame mainFrame;
    private final MainInfoPanel infoPanel;
    @Getter
    private final MainNavPanel navPanel;


//    private final MainInfoPanelCreator infoPanelCreator;
//    private final MainNavPanelCreator navPanelCreator;
    @Getter
    private final CalcController calcController;
    @Getter
    private final ChartsController chartsController;
    private final VersionEndpoint versionEndpoint;
    private final TextProvider textProvider;

    private final String KEY_TITLE = "GENERAL.TITLE";

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

    // TODO retrieve text from backend
    private void constructFrame() {
//        if (navPanel == null)  {
//            navPanel = navPanelCreator.constructPanel(new MainNavigationListener(){
//                public void navigationEventOccurred(MainNavigationEvent event) {
//                    handleEvent(event.getNavigationAction());
//
//                }
//            });
//        }
//        if (infoPanel == null) {
//            infoPanel = infoPanelCreator.constructPanel();
//        }
        mainFrame = new JFrame(createTitle());
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(navPanel, BorderLayout.WEST);
        mainFrame.add(infoPanel, BorderLayout.CENTER);
        mainFrame.setSize(600,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }


//    private void handleEvent(String action) {
//        System.out.println(action);
//        if (action.equals("CALCULATORS")) {
//            System.out.println("Match!");
////            mainFrame.setVisible(false);
//            calcController.show();
//        }
//        if (action.equals("HOROSCOPES")) {
//            System.out.println("Match horoscopes!");
////            mainFrame.setVisible(false);
//            chartsController.show();
//        }
//    }

    private String createTitle() {
        Request request = new GenericRequestNoPar();
        VersionResponse response = (VersionResponse)versionEndpoint.handleRequest(request);
        return textProvider.getText(KEY_TITLE)
                + TextConstants.SPACE.getText() + TextConstants.DIVISON.getText() + TextConstants.SPACE.getText()
                + response.getVersion();
    }

}
