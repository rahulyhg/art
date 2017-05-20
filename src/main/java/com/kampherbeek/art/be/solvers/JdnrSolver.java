package com.kampherbeek.art.be.solvers;


import com.kampherbeek.art.domain.dto.DateDto;
import com.kampherbeek.art.domain.dto.TimeDto;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import com.kampherbeek.art.util.TimeCalculations;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import swisseph.SweDate;

@Component
public class JdnrSolver {

    private final TimeCalculations calculations;

    @Autowired
    public JdnrSolver(@NonNull TimeCalculations calculations) {
        this.calculations = calculations;
    }

    public double calcJdnr (@NonNull DateDto dateDto, @NonNull TimeDto timeDto) {
        double ut = defineUtDecimalHour(timeDto);
        SweDate sweDate = new SweDate(dateDto.getYear(), dateDto.getMonth(), dateDto.getDay(), ut, dateDto.isGregorian());
        return sweDate.getJulDay();
    }

    private double defineUtDecimalHour(@NonNull TimeDto timeDto) {
        return calculations.decimalTimeFromHMS(timeDto.getHour(), timeDto.getMinute(), timeDto.getSecond());
    }

}
