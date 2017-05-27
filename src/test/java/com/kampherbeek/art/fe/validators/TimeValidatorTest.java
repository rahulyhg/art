/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.validators;

import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.domain.dto.TimeDto;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class TimeValidatorTest {

    private int hour = 18;
    private int minute = 5;
    private int second = 30;
    private int hourTooLow = -1;
    private int hourTooHigh = 24;
    private int minuteTooLow = -1;
    private int minuteTooHigh = 60;
    private int secondTooLow = -1;
    private int secondTooHigh = 60;

    private TimeDto dtoMock = mock(TimeDto.class);
    private DateDto wrongTypeMock = mock(DateDto.class);
    private TimeValidator validator;

    @Before
    public void setUp() throws Exception {
        when(dtoMock.getHour()).thenReturn(hour);
        when(dtoMock.getMinute()).thenReturn(minute);
        when(dtoMock.getSecond()).thenReturn(second);
        validator = new TimeValidator();
    }

    @Test
    public void validate() throws Exception {
        assertTrue(validator.validate(dtoMock));
    }

    @Test
    public void validateHourTooHigh() throws Exception {
        when(dtoMock.getHour()).thenReturn(hourTooHigh);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateHourTooLow() throws Exception {
        when(dtoMock.getHour()).thenReturn(hourTooLow);
        assertFalse(validator.validate(dtoMock));
    }


    @Test
    public void validateMinuteTooHigh() throws Exception {
        when(dtoMock.getMinute()).thenReturn(minuteTooHigh);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateMinuteTooLow() throws Exception {
        when(dtoMock.getMinute()).thenReturn(minuteTooLow);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateSecondTooHigh() throws Exception {
        when(dtoMock.getSecond()).thenReturn(secondTooHigh);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateSecondTooLow() throws Exception {
        when(dtoMock.getSecond()).thenReturn(secondTooLow);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateWrongType() throws Exception {
        assertFalse(validator.validate(wrongTypeMock));
    }



}
