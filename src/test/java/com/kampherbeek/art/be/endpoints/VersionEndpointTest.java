/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.be.endpoints;

import com.kampherbeek.art.be.handlers.VersionHandler;
import com.kampherbeek.art.domain.requests.GenericRequestNoPar;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import com.kampherbeek.art.domain.responses.Response;
import com.kampherbeek.art.domain.responses.VersionResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VersionEndpointTest {

    @Mock
    private VersionHandler handlerMock = mock(VersionHandler.class);
    @Mock
    private GenericRequestNoPar requestMock = mock(GenericRequestNoPar.class);
    @Mock
    private JdnrRequest wrongRequestMock = mock(JdnrRequest.class);

    @InjectMocks
    private VersionEndpoint endpoint;

    private final String VERSION = "1.2.3";
    private final String STATUS_ERROR = "ERROR";

    @Before
    public void setUp() throws Exception {
        when(handlerMock.getVersion()).thenReturn(VERSION);
    }

    @Test
    public void handleRequest() throws Exception {
        VersionResponse response = (VersionResponse)endpoint.handleRequest(requestMock);
        assertEquals(VERSION, response.getVersion());
    }

    @Test
    public void handleWrongRequest() throws Exception {
        Response response = endpoint.handleRequest(wrongRequestMock);
        assertEquals(response.getStatusText(), STATUS_ERROR);
    }

}
