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

    public void setContact(ContactType infoType, String information) {
        contactDetails.put(infoType, information);
    }

    public void setSection(SectionType infoType, AbstractSection information) {
        sections.put(infoType, information);
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
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fullName + "\n");
        for (Map.Entry<ContactType, String> pair : contactDetails.entrySet()) {
            stringBuilder.append(pair.getKey().getTitle() + ": " + pair.getValue() + "\n");
        }
        stringBuilder.append("\n");
        for (Map.Entry<SectionType, AbstractSection> pair : sections.entrySet()) {
            stringBuilder.append(pair.getKey().getTitle() + ":\n" );
            stringBuilder.append(pair.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Resume o) {
        //return Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid).compare(this, o);
        int i = fullName.compareTo(o.fullName);
        return i != 0 ? i : uuid.compareTo(o.uuid);
    }
}
