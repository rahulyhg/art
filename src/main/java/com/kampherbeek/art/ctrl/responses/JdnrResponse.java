package com.kampherbeek.art.ctrl.responses;

import lombok.Getter;
import lombok.Setter;

public class JdnrResponse implements Response {

	@Getter
	@Setter
	private String statusTxt;
	@Getter
	@Setter
	private double jdnr;
	
}
