/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.controllers;


import com.kampherbeek.art.fe.panelcreators.MainInfoPanelCreator;
import com.kampherbeek.art.fe.panelcreators.MainNavPanelCreator;
import com.kampherbeek.art.fe.main.MainNavigationEvent;
import com.kampherbeek.art.fe.main.MainNavigationListener;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainController {

    private JFrame mainFrame;
    private JPanel navPanel;
    private JPanel infoPanel;

    private final MainInfoPanelCreator infoPanelCreator;
    private final MainNavPanelCreator navPanelCreator;
    private final CalcController calcController;
    private final ChartsController chartsController;
    @Autowired
    public MainController(@NonNull MainInfoPanelCreator infoPanelCreator,
                          @NonNull MainNavPanelCreator navPanelCreator,
                          @NonNull CalcController calcController,
                          @NonNull ChartsController chartsController) {
        this.infoPanelCreator = infoPanelCreator;
        this.navPanelCreator = navPanelCreator;
        this.calcController = calcController;
        this.chartsController = chartsController;
    }

    public void show() {
        constructFrame();

    }


    // TODO retrieve text from backend
    private void constructFrame() {
        if (navPanel == null)  {
            navPanel = navPanelCreator.constructPanel(new MainNavigationListener(){
                public void navigationEventOccurred(MainNavigationEvent event) {
                    handleEvent(event.getNavigationAction());

                }
            });
        }
        if (infoPanel == null) {
            infoPanel = infoPanelCreator.constructPanel();
        }
        mainFrame = new JFrame("Art - just trying the first version");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(navPanel, BorderLayout.WEST);
        mainFrame.add(infoPanel, BorderLayout.CENTER);
        mainFrame.setSize(600,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }


    private void handleEvent(String action) {
        System.out.println(action);
        if (action.equals("CALCULATORS")) {
            System.out.println("Match!");
//            mainFrame.setVisible(false);
            calcController.show();
        }
        if (action.equals("HOROSCOPES")) {
            System.out.println("Match horoscopes!");
//            mainFrame.setVisible(false);
            chartsController.show();
        }
    }

}
