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
    private Map<SectionType, Section> mainInformation;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        this.contactDetails = new EnumMap<>(ContactType.class);
        this.mainInformation = new EnumMap<>(SectionType.class);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void showResumeInfo() {
        System.out.println(fullName + "\n");
        showContactsInfo();
        showSectionsInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) &&
                fullName.equals(resume.fullName) &&
                Objects.equals(contactDetails, resume.contactDetails) &&
                Objects.equals(mainInformation, resume.mainInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contactDetails, mainInformation);
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

    public void setInfo(ContactType infoType, String information) {
        contactDetails.put(infoType, information);
    }

    public void setInfo(SectionType infoType, String information) {
        if (infoType == SectionType.OBJECTIVE || infoType == SectionType.PERSONAL){
            StringSection stringSection = new StringSection();
            stringSection.setDescription(information);
            mainInformation.put(infoType, stringSection);
        }
        else{
            ListSection listSection = (ListSection)mainInformation.get(infoType);
            if (listSection == null){
                listSection = new ListSection();
            }
            listSection.getList().add(information);
            mainInformation.put(infoType, listSection);
        }
    }

    public void setInfo(SectionType sectionType, String name, int startDateMonth, int startDateYear, int endDateMonth, int endDateYear, String description) {
        OrganizationSection organizationSection = (OrganizationSection)mainInformation.get(sectionType);
        if (organizationSection == null){
            organizationSection = new OrganizationSection();
        }

        YearMonth startDate = YearMonth.of(startDateYear, startDateMonth);
        YearMonth endDate = YearMonth.of(endDateYear, endDateMonth);

        organizationSection.getList().add(new OrganizationDescription(name, startDate, endDate, description));
        mainInformation.put(sectionType, organizationSection);
    }

    public void showContactsInfo() {
        for (Map.Entry<ContactType, String> pair : contactDetails.entrySet()) {
            System.out.println(pair.getKey().getTitle() + ": " + pair.getValue());
        }
        System.out.println();
    }

    public void showSectionsInfo() {
        for (Map.Entry<SectionType, Section> pair : mainInformation.entrySet()) {
            System.out.println(pair.getKey().getTitle() + ":" );
            pair.getValue().showInfo();
        }
    }
}
