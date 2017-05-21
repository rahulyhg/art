/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.main;


import lombok.Getter;

import java.util.EventObject;

public class MainNavigationEvent extends EventObject{

    // TODO replace with enum
    @Getter
    private String navigationAction;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MainNavigationEvent(Object source) {
        super(source);
    }

    public MainNavigationEvent(Object source, String navigationAction) {
        super(source);
        this.navigationAction = navigationAction;
    }
}
