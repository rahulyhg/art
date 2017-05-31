/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.buildingblocks;

import lombok.NonNull;

import javax.swing.*;
import java.awt.*;

/**
 * Defines a label for info-text.
 */
public class InfoLabel extends JLabel {

    public InfoLabel(@NonNull String text) {
        super(text);
        constructLookAndFeel();
    }

    private void constructLookAndFeel() {
        this.setForeground(createColor());
    }

    @SuppressWarnings("MagicNumber")
    private Color createColor() {
        int red = 57;
        int green = 57;
        int blue = 200;
        return new Color(red, green, blue);
    }
}
