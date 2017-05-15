package com.kampherbeek.art.ctrl.dto;

import lombok.Getter;
import lombok.Setter;

public class DateTimeVO {

	@Getter
	@Setter
	private int year;
	@Getter
	@Setter
	private int month;
	@Getter
	@Setter
	private int day;
	@Getter
	@Setter
	private int hour;
	@Getter
	@Setter
	private int minute;
	@Getter
	@Setter
	private int second;
	@Getter
	@Setter
	private boolean gregorian;
	
}
