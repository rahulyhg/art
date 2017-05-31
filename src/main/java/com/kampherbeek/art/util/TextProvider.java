/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.util;


import com.kampherbeek.art.config.Settings;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Component
public class TextProvider {

    private final ResourceBundle rb;
    private final Settings settings;
    private final String bundle = "art_common";

    @Autowired
    public TextProvider(@NonNull Settings settings) {
        this.settings = settings;
        Locale.setDefault(createLocale());
        rb = ResourceBundle.getBundle(bundle);
    }

    public String getText(@NonNull String key) {
        try {
            return rb.getString(key);
        } catch(MissingResourceException mre) {
            return TextConstants.EMPTY_STRING.getText();
        }
    }

    private Locale createLocale() {
        return new Locale(settings.getLocaleLang(), settings.getLocaleCountry());
    }


}
