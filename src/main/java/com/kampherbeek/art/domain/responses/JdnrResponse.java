package com.kampherbeek.art.domain.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JdnrResponse implements Response {

	private String statusText;
	private double jdnr;
	
}
