/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.buildingblocks;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class InfoLabelTest {

    private InfoLabel infoLabel;
    private final String text = "MyText";
    int red = 57;
    int green = 57;
    int blue = 200;

    @Before
    public void setUp() throws Exception {
        infoLabel = new InfoLabel(text);
    }

    @Test
    public void getForeground() throws Exception {
        Color result = infoLabel.getForeground();
        assertEquals(blue, result.getBlue());
        assertEquals(green, result.getGreen());
        assertEquals(red, result.getRed());
    }


}