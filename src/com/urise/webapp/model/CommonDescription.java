package com.urise.webapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDescription {
    private String name;
    private Date startDate;
    private Date endDate;
    private String description;

    public CommonDescription(String name, Date startDate, Date endDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM");
        return  name + "\n" +
                dateFormat.format(startDate) + "-" + dateFormat.format(endDate) + " " + description + "\n";
    }
}
