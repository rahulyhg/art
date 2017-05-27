/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.be.handlers;

import com.kampherbeek.art.TestConstants;
import com.kampherbeek.art.be.solvers.JdnrSolver;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JdnrHandlerTest {

    private final double jdnr = 12345.678;

    @Mock
    private JdnrSolver solverMock = mock(JdnrSolver.class);
    @Mock
    private JdnrRequest requestMock = mock(JdnrRequest.class);

    @InjectMocks
    private JdnrHandler handler;

    @Before
    public void setUp() throws Exception {
        when(solverMock.calcJdnr(anyObject(), anyObject())).thenReturn(jdnr);
    }

    @Test
    public void getJdnr() throws Exception {
        double result = handler.getJdnr(requestMock);
        assertEquals(jdnr, result, TestConstants.FLOAT_MARGIN);
    }

}