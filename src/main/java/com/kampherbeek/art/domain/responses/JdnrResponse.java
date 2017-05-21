/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.domain.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JdnrResponse implements Response {

	private String statusText;
	private double jdnr;
	
}
