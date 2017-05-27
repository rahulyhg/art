/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.main;

import com.kampherbeek.art.fe.controllers.MainController;
import com.kampherbeek.art.fe.panels.MainNavPanel;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MainNavigationListener {

    private MainNavPanel navPanel;
    private MainController controller;


    public void navigationEventOccurred(@NonNull MainNavigationEvent event){
        navPanel = event.getNavPanel();
        controller = navPanel.getController();
        handleEvent(event.getSource(), event);

    };

    private void handleEvent(@NonNull Object source, @NonNull MainNavigationEvent event) {
        String action = event.getNavigationAction();
        System.out.println(action);
        if (action.equals("CALCULATORS")) {
            System.out.println("Match!");
//            mainFrame.setVisible(false);
            controller.showCalc();
        }
        if (action.equals("HOROSCOPES")) {
            System.out.println("Match horoscopes!");
//            mainFrame.setVisible(false);
            controller.showCharts();
        }
    }
}

