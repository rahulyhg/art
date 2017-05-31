/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * General settings as defined in application.properties
 */
@Component
@PropertySource("classpath:application.properties")
public class Settings {

    @Getter
    @Value("${localeLang}")
    private String localeLang;

    @Getter
    @Value("${localeCountry}")
    private String localeCountry;

    @Getter
    @Value("${version}")
    private String version;

}
