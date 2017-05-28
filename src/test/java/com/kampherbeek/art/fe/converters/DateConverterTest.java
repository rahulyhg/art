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
    public void convertDateTime() throws Exception {
        DateDto result = converter.convertDate(input, gregorian);
        assertEquals(2017, result.getYear());
        assertEquals(5, result.getMonth());
        assertEquals(19, result.getDay());
        assertTrue(result.isGregorian());
        assertTrue(result.isValid());
    }

    @Test
    public void convertDateTimeInvalidInput() throws Exception {
        DateDto result = converter.convertDate(invalidInput, gregorian);
        assertFalse(result.isValid());
    }


}