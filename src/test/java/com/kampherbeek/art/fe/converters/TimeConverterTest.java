/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.converters;

import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.fe.validators.TimeValidator;
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
public class TimeConverterTest {

    private String input = "19:25:33";
    private String invalidInput = "x9:25:33";
    private String leadingZeroInput = "01:03:08";
    private String noLeadingZeroInput = "1:5:9";
    private String noSecondsInput = "12:10";

    @Mock
    private TimeValidator validatorMock = mock(TimeValidator.class);
    @InjectMocks
    private TimeConverter converter;

    @Before
    public void setUp() throws Exception {
        when(validatorMock.validate(anyObject())).thenReturn(true);
    }

    @Test
    public void convertTime() throws Exception {
        TimeDto result = converter.convertTime(input);
        assertEquals(19, result.getHour());
        assertEquals(25, result.getMinute());
        assertEquals(33, result.getSecond());
        assertTrue(result.isValid());
    }

    @Test
    public void convertTimeInvalidInput() throws Exception {
        TimeDto result = converter.convertTime(invalidInput);
        assertFalse(result.isValid());
    }

    @Test
    public void convertTimeLeadingZero() throws Exception {
        TimeDto result = converter.convertTime(leadingZeroInput);
        assertEquals(1, result.getHour());
        assertEquals(3, result.getMinute());
        assertEquals(8, result.getSecond());
        assertTrue(result.isValid());
    }

    @Test
    public void convertTimeNoLeadingZero() throws Exception {
        TimeDto result = converter.convertTime(noLeadingZeroInput);
        assertEquals(1, result.getHour());
        assertEquals(5, result.getMinute());
        assertEquals(9, result.getSecond());
        assertTrue(result.isValid());
    }

    @Test
    public void convertTimeNoSeconds() throws Exception {
        TimeDto result = converter.convertTime(noSecondsInput);
        assertEquals(12, result.getHour());
        assertEquals(10, result.getMinute());
        assertEquals(0, result.getSecond());
        assertTrue(result.isValid());
    }

}

