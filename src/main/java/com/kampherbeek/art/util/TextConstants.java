/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.util;

import lombok.Getter;
import lombok.NonNull;

/**
 * Constants to be used for constructing texts.
 * Mainly to be used to avoid magic strings.
 */
public enum TextConstants {

    COLON(":"),
    DIVISON("-"),
    EMPTY_STRING(""),
    NEW_LINE("\n"),
    SPACE(" ");

    @Getter
    private String text;

    TextConstants(@NonNull String content) {
        this.text = content;
    }
}
