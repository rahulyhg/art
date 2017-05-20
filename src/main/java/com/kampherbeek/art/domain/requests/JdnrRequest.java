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
