/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.constants;

import lombok.Getter;

public enum PanelConstants {
    MEDIUM_BORDER_WIDTH(5),
    LARGE_BORDER_WIDTH(12);

    @Getter
    private int size;

    PanelConstants(int size) {
        this.size = size;
    }
}
