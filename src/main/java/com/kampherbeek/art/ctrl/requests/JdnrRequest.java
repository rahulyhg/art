package com.kampherbeek.art.ctrl.requests;

import com.kampherbeek.art.ctrl.dto.DateTimeVO;

import lombok.Getter;
import lombok.Setter;

public class JdnrRequest implements Request {

	@Getter
	@Setter
	private String action;
	@Getter
	@Setter	
	private DateTimeVO dateTimeVO;
	
}
