package com.kampherbeek.art.domain.validators;

import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.domain.dto.TimeDto;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class DateValidatorTest {

    private int day = 19;
    private int month = 5;
    private int year = 2017;
    private int yearBeforeRange = -14000;
    private int yearAfterRange = 18000;
    private boolean gregorian = true;
    private DateValidator validator;
    private DateDto dtoMock = mock(DateDto.class);
    private TimeDto wrongTypeMock = mock(TimeDto.class);

    @Before
    public void setUp() throws Exception {
        when(dtoMock.getYear()).thenReturn(year);
        when(dtoMock.getMonth()).thenReturn(month);
        when(dtoMock.getDay()).thenReturn(day);
        when(dtoMock.isGregorian()).thenReturn(gregorian);
        validator = new DateValidator();
    }

    @Test
    public void validate() throws Exception {
        assertTrue(validator.validate(dtoMock));
    }

    @Test
    public void validateYearBeforeRange() throws Exception {
        when(dtoMock.getYear()).thenReturn(yearBeforeRange);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateYearAfterRange() throws Exception {
        when(dtoMock.getYear()).thenReturn(yearAfterRange);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateInvalidDate() throws Exception {
        when(dtoMock.getMonth()).thenReturn(2);
        when(dtoMock.getDay()).thenReturn(30);
        assertFalse(validator.validate(dtoMock));
    }

    @Test
    public void validateWrongType() throws Exception {
        assertFalse(validator.validate(wrongTypeMock));
    }

}