package com.kampherbeek.art.util;


import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class TextProvider {

    private ResourceBundle rb;

    // TODO read locale from config
    public TextProvider() {
        Locale.setDefault(new Locale("en", "US"));  // TODO use config for Locale
        rb = ResourceBundle.getBundle("art_common");
    }

    public String getText(@NonNull String key) {
        return rb.getString(key);
    }



}
