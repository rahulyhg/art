/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.constants;

import lombok.Getter;

/**
 * Constants for GridBag Constraints.
 * Valuesa used are based on T-hsirt sizes.
 */
public enum GcConstants {
    M(1.0),
    S(0.1),
    XS(0.02);

    @Getter
    private double value;

    GcConstants(double value) {
        this.value = value;
    }
}
