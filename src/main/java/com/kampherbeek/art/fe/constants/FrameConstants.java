/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.constants;

import lombok.Getter;

/**
 * Constants for frames, sizes etc.
 */
public enum FrameConstants {

    DEFAULT_WIDTH(1200),
    DEFAULT_HEIGHT(900),
    DEFAULT_MINIMUM_WIDTH(800),
    DEFAULT_MINIMUM_HEIGHT(600);

    @Getter
    private int size;

    FrameConstants(int size) {
        this.size = size;
    }

}
