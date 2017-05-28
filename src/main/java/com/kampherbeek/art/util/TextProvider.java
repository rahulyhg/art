/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.util;


import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Component
public class TextProvider {

    private final ResourceBundle rb;

    // TODO read locale from config
    public TextProvider() {
        Locale.setDefault(new Locale("en", "US"));
        rb = ResourceBundle.getBundle("art_common");
    }

    public String getText(@NonNull String key) {
        String EMPTY_STRING = "";
        try {
            return rb.getString(key);
        } catch(MissingResourceException mre) {
            return EMPTY_STRING;
        }
    }


}
