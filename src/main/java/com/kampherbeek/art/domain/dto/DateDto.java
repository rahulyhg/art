package com.kampherbeek.art.domain.dto;

import lombok.Data;

@Data
public class DateDto implements ValidatedDto {

	private int year;
	private int month;
	private int day;
	private boolean gregorian;
    private boolean valid;


}
