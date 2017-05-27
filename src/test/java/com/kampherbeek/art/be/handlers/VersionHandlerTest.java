/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.be.handlers;

import com.kampherbeek.art.be.solvers.VersionSolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VersionHandlerTest {

    private final String version = "1.2.3";

    @Mock
    private VersionSolver solverMock = mock(VersionSolver.class);
//    @InjectMocks
    private VersionHandler handler;


    @Before
    public void setUp() throws Exception {
        when(solverMock.getVersion()).thenReturn(version);
        handler = new VersionHandler(solverMock);
    }

    @Test
    public void getVersion() throws Exception {
        String result = handler.getVersion();
        assertEquals(version, result);

    }


}
