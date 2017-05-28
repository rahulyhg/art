/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.converters;

import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.fe.validators.DateValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DateConverterTest {

    private String input = "2017-05-19";
    private String invalidInput = "x017-05-19";
    private String leadingZeroInput = "2000-01-01";
    private String noLeadingZeroInput = "2000-2-3";
    private boolean gregorian = true;


    @Mock
    private DateValidator validatorMock = mock(DateValidator.class);
    @InjectMocks
    private DateConverter converter;

    @Before
    public void setUp() throws Exception {
        when(validatorMock.validate(anyObject())).thenReturn(true);
    }

    @Test
    public void convertDate() throws Exception {
        DateDto result = converter.convertDate(input, gregorian);
        assertEquals(2017, result.getYear());
        assertEquals(5, result.getMonth());
        assertEquals(19, result.getDay());
        assertTrue(result.isGregorian());
        assertTrue(result.isValid());
    }

    @Test
    public void convertDateJulian() throws Exception {
        DateDto result = converter.convertDate(input, false);
        assertEquals(2017, result.getYear());
        assertEquals(5, result.getMonth());
        assertEquals(19, result.getDay());
        assertFalse(result.isGregorian());
        assertTrue(result.isValid());
    }

    @Test
    public void convertDateInvalidInput() throws Exception {
        DateDto result = converter.convertDate(invalidInput, gregorian);
        assertFalse(result.isValid());
    }

    @Test
    public void convertDateLeadingZero() throws Exception {
        DateDto result = converter.convertDate(leadingZeroInput, gregorian);
        assertEquals(2000, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(1, result.getDay());
        assertTrue(result.isGregorian());
        assertTrue(result.isValid());
    }

    @Test
    public void convertDateNoLeadingZero() throws Exception {
        DateDto result = converter.convertDate(noLeadingZeroInput, gregorian);
        assertEquals(2000, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(3, result.getDay());
        assertTrue(result.isGregorian());
        assertTrue(result.isValid());
    }

}