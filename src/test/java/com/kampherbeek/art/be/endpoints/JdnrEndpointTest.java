/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.be.endpoints;

import com.kampherbeek.art.TestConstants;
import com.kampherbeek.art.be.handlers.JdnrHandler;
import com.kampherbeek.art.domain.requests.GenericRequestNoPar;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import com.kampherbeek.art.domain.requests.Request;
import com.kampherbeek.art.domain.responses.JdnrResponse;
import com.kampherbeek.art.domain.responses.Response;
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
public class JdnrEndpointTest {

    @Mock
    private JdnrHandler handlerMock = mock(JdnrHandler.class);
    @Mock
    private JdnrRequest requestMock = mock(JdnrRequest.class);
    @Mock
    private GenericRequestNoPar wrongRequestMock = mock(GenericRequestNoPar.class);
    @InjectMocks
    private JdnrEndpoint endpoint;
    private final double jdnr = 12345.678;
    private final String STATUS_ERROR = "ERROR";

    @Before
    public void setUp() throws Exception {
        when(handlerMock.getJdnr(anyObject())).thenReturn(jdnr);
    }

    @Test
    public void handleRequest() throws Exception {
        JdnrResponse response = (JdnrResponse)endpoint.handleRequest(requestMock);
        assertEquals(jdnr, response.getJdnr(), TestConstants.FLOAT_MARGIN);
    }

    @Test
    public void handleWrongRequest() throws Exception {
        Response response = endpoint.handleRequest(wrongRequestMock);
        assertEquals(response.getStatusText(), STATUS_ERROR);
    }

}