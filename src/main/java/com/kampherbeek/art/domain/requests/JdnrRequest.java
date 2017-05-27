/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.domain.requests;

import com.kampherbeek.art.domain.dto.DateDto;

import com.kampherbeek.art.domain.dto.TimeDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JdnrRequest implements Request {

	private boolean valid;
	private DateDto dateDto;
	private TimeDto timeDto;
	
}
