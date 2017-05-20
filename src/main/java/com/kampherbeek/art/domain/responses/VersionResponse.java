package com.kampherbeek.art.domain.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class VersionResponse implements Response {

	private String statusText;
	private String version;

}
