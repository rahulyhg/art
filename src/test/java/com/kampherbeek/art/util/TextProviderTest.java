/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.util;

import com.kampherbeek.art.config.Settings;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class TextProviderTest {

    private TextProvider textProvider;
    private Settings settingsMock = mock(Settings.class);
    private final String COUNTRY="US";
    private final String LANG="en";

    @Before
    public void setUp() throws Exception {
        when(settingsMock.getLocaleCountry()).thenReturn(COUNTRY);
        when(settingsMock.getLocaleLang()).thenReturn(LANG);
        textProvider = new TextProvider(settingsMock);
    }

    @Test
    public void getText() throws Exception {
        String key = "GENERAL.TITLE";
        String result = textProvider.getText(key);
        assertTrue(result != null && result.length() > 0);
    }

    @Test
    public void getTextWrongKey() throws Exception {
        String key = "X";
        String expected = "";
        String result = textProvider.getText(key);
        assertEquals(expected, result);
    }

}