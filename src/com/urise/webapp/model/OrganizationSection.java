package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    List<OrganizationDescription> list = new ArrayList<>();

    public List<OrganizationDescription> getList() {
        return list;
    }

    public void setList(List<OrganizationDescription> list) {
        this.list = list;
    }

    @Override
    void showInfo() {
        for (OrganizationDescription organizationDescription: list){
            System.out.println(organizationDescription);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
