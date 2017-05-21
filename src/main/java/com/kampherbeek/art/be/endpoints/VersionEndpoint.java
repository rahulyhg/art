/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.be.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kampherbeek.art.be.handlers.VersionHandler;
import com.kampherbeek.art.domain.requests.GenericRequestNoPar;
import com.kampherbeek.art.domain.requests.Request;
import com.kampherbeek.art.domain.responses.Response;
import com.kampherbeek.art.domain.responses.VersionResponse;

@Component
public class VersionEndpoint {

	private final VersionHandler handler;
	
	@Autowired
	public VersionEndpoint(VersionHandler handler) {
		this.handler = handler;
	}
	
	public Response handleRequest(Request request) {
		VersionResponse response = new VersionResponse();
		if (request instanceof GenericRequestNoPar) {
			response.setVersion(handler.getVersion());
			response.setStatusText("OK");
		} else {
			response.setStatusText("ERROR");
		}
		return response;
	}
}
