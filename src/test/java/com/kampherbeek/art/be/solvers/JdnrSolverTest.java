/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.be.solvers;

import com.kampherbeek.art.TestConstants;
import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.util.TimeCalculations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JdnrSolverTest {

    @Mock
    private TimeCalculations timeCalcMock = mock(TimeCalculations.class);
    @Mock
    private DateDto dateDtoMock = mock(DateDto.class);
    @Mock
    private TimeDto timeDtoMock = mock(TimeDto.class);
    @InjectMocks
    private JdnrSolver solver;

    private int day = 20;
    private int month = 5;
    private int year = 2017;
    private int hour = 23;
    private int minute = 45;
    private int second = 0;
    private double time = 23.75;


    @Before
    public void setUp() throws Exception {
        when(timeCalcMock.decimalTimeFromHMS(anyInt(), anyInt(), anyInt())).thenReturn(time);
        when(dateDtoMock.getYear()).thenReturn(year);
        when(dateDtoMock.getMonth()).thenReturn(month);
        when(dateDtoMock.getDay()).thenReturn(day);
        when(dateDtoMock.isGregorian()).thenReturn(true);
        when(timeDtoMock.getHour()).thenReturn(hour);
        when(timeDtoMock.getMinute()).thenReturn(minute);
        when(timeDtoMock.getSecond()).thenReturn(second);

    }

    @Test
    public void calcJdnr() throws Exception {
        double expected = 2457894.4895833335;
        assertEquals(expected, solver.calcJdnr(dateDtoMock, timeDtoMock), TestConstants.FLOAT_MARGIN);
    }

}