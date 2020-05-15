package com.urise.webapp.model;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class OrganizationDescription {
    private String name;
    private YearMonth startDate;
    private YearMonth endDate;
    private String description;

    public OrganizationDescription(String name, YearMonth startDate, YearMonth endDate, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationDescription that = (OrganizationDescription) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate, endDate, description);
    }
}
