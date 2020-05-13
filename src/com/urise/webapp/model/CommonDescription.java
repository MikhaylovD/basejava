package com.urise.webapp.model;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class CommonDescription {
    private String name;
    private YearMonth startDate;
    private YearMonth endDate;
    private String description;

    public CommonDescription(String name, YearMonth startDate, YearMonth endDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        return name + "\n" +
                formatter.format(startDate) + " - " + formatter.format(endDate) + " " + description + "\n";
    }
}
