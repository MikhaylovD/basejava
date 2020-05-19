package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    // Unique identifier
    private final String uuid;
    private String fullName;
    private Map<ContactType, String>  contactDetails;
    private Map<SectionType, AbstractSection> sections;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        this.contactDetails = new EnumMap<>(ContactType.class);
        this.sections = new EnumMap<>(SectionType.class);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void showResumeInfo() {
        System.out.println(fullName + "\n");
        for (Map.Entry<ContactType, String> pair : contactDetails.entrySet()) {
            System.out.println(pair.getKey().getTitle() + ": " + pair.getValue());
        }
        System.out.println();
        for (Map.Entry<SectionType, AbstractSection> pair : sections.entrySet()) {
            System.out.println(pair.getKey().getTitle() + ":" );
            System.out.println(pair.getValue());
        }
    }

    public void setContact(ContactType infoType, String information) {
        contactDetails.put(infoType, information);
    }

    public void setSection(SectionType infoType, String information) {
        if (infoType == SectionType.OBJECTIVE || infoType == SectionType.PERSONAL){
            StringSection stringSection = new StringSection();
            stringSection.setDescription(information);
            sections.put(infoType, stringSection);
        }
        else{
            ListSection listSection = (ListSection)sections.get(infoType);
            if (listSection == null){
                listSection = new ListSection();
            }
            listSection.getList().add(information);
            sections.put(infoType, listSection);
        }
    }

    public void setSection(SectionType sectionType, String name, int startDateMonth, int startDateYear, int endDateMonth, int endDateYear, String description) {
        OrganizationSection organizationSection = (OrganizationSection)sections.get(sectionType);
        if (organizationSection == null){
            organizationSection = new OrganizationSection();
        }

        YearMonth startDate = YearMonth.of(startDateYear, startDateMonth);
        YearMonth endDate = YearMonth.of(endDateYear, endDateMonth);

        organizationSection.getList().add(new Position(name, startDate, endDate, description));
        sections.put(sectionType, organizationSection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) &&
                fullName.equals(resume.fullName) &&
                Objects.equals(contactDetails, resume.contactDetails) &&
                Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contactDetails, sections);
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    @Override
    public int compareTo(Resume o) {
        //return Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid).compare(this, o);
        int i = fullName.compareTo(o.fullName);
        return i != 0 ? i : uuid.compareTo(o.uuid);
    }
}
