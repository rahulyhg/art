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
    public void convertDateTimeInvalidInput() throws Exception {
        TimeDto result = converter.convertTime(invalidInput);
        assertFalse(result.isValid());
    }


}

