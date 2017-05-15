package com.kampherbeek.art.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kampherbeek.art.be.VersionHandler;
import com.kampherbeek.art.ctrl.requests.GenericRequestNoPar;
import com.kampherbeek.art.ctrl.requests.Request;
import com.kampherbeek.art.ctrl.responses.Response;
import com.kampherbeek.art.ctrl.responses.VersionResponse;

@Component
public class VersionController {

	private VersionHandler handler;
	
	@Autowired
	public VersionController(VersionHandler handler) {
		this.handler = handler;
	}
	
	public Response handleRequest(Request request) {
		VersionResponse response = new VersionResponse();
		if (request instanceof GenericRequestNoPar) {
			response.setVersion(handler.getVersion());
			response.setStatusTxt("OK");
		} else {
			response.setStatusTxt("ERROR");
		}
		return response;
	}
}
