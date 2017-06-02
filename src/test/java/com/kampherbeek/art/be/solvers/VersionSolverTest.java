/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.be.solvers;

import com.kampherbeek.art.config.Settings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class VersionSolverTest {

    @Mock
    private Settings settingsMock = mock(Settings.class);
    @InjectMocks
    private VersionSolver solver;
    private final String VERSION = "1.2.3";


    @Before
    public void setUp() throws Exception {
        when(settingsMock.getVersion()).thenReturn(VERSION);
    }

    @Test
    public void getVersion() throws Exception {
        assertEquals(VERSION, solver.getVersion());
    }

}