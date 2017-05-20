package com.kampherbeek.art.domain.dto;


import lombok.Data;

@Data
public class TimeDto implements ValidatedDto{
    private int hour;
    private int minute;
    private int second;
    private boolean valid;
}
