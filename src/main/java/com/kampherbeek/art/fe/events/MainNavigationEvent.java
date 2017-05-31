/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.events;


import com.kampherbeek.art.fe.controllers.MainController;
import lombok.Getter;
import lombok.NonNull;

import java.util.EventObject;

public class MainNavigationEvent extends EventObject{

    // TODO replace with enum
    @Getter
    private String navigationAction;
    @Getter
    private MainController controller;


    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MainNavigationEvent(Object source) {
        super(source);
    }

    public MainNavigationEvent(@NonNull Object source, @NonNull String navigationAction,
                               @NonNull MainController controller) {
        super(source);
        this.navigationAction = navigationAction;
        this.controller = controller;
    }
}
