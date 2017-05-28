/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.listeners;

import com.kampherbeek.art.fe.controllers.MainController;
import com.kampherbeek.art.fe.events.MainNavigationEvent;
import com.kampherbeek.art.fe.panels.MainNavPanel;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MainNavigationListener {

    private MainController controller;

    public void navigationEventOccurred(@NonNull MainNavigationEvent event){
        MainNavPanel navPanel = event.getNavPanel();
        controller = navPanel.getController();
        handleEvent(event);
    }

    private void handleEvent(@NonNull MainNavigationEvent event) {
        String action = event.getNavigationAction();
         if (action.equals("CALCULATORS")) {
            controller.showCalc();
        }
        if (action.equals("HOROSCOPES")) {
            controller.showCharts();
        }
    }
}

