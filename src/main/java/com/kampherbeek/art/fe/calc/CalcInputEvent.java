package com.kampherbeek.art.fe.calc;

import java.util.EventObject;


public class CalcInputEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CalcInputEvent(Object source) {
        super(source);
    }
}
