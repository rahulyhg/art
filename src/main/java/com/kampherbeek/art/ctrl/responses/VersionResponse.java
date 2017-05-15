package com.kampherbeek.art.ctrl.responses;

import lombok.Getter;
import lombok.Setter;

public class VersionResponse implements Response {

	@Getter
	@Setter
	private String statusTxt;
//	@Getter
//	@Setter
	private String version;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
