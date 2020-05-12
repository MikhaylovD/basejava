package com.urise.webapp.model;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    // Unique identifier
    private final String uuid;
    private String fullName;
    private ContactDetails contactDetails;
    private MainInformation mainInformation;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        this.contactDetails = new ContactDetails();
        this.mainInformation = new MainInformation();
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void getResumeInfo() {
        System.out.println(fullName + "\n" );
        contactDetails.getInfo();
        mainInformation.getInfo();
    }

    public void setContactDetails(String infoType, String information) {
        contactDetails.setInfo(infoType, information);
    }

    public void setMainInformation(String infoType, String name,String startDate, String endDate, String description) {
        mainInformation.setInfo(infoType, name, startDate, endDate, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) &&
                fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
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

    private class ContactDetails {
        Map<ContactType, String> map= new HashMap<>();
        public void setInfo(String infoType, String information) {
            ContactType contactType= ContactType.valueOf(infoType);
            map.put(contactType, information);
        }

        public void getInfo() {
            for(Map.Entry<ContactType, String> pair: map.entrySet()){
                System.out.println(pair.getKey().getTitle() + ": " + pair.getValue());
            }
            System.out.println();
        }
    }

    private class MainInformation {
        Map<SectionType, SectionInfo> map = new HashMap<>();

        public void setInfo(String sectionTypeInfo, String name,String startDate, String endDate, String description) {
            SectionType sectionType = SectionType.valueOf(sectionTypeInfo);
            SectionInfo sectionInfo = map.get(sectionType);
            if (sectionInfo == null){
                sectionInfo = new SectionInfo();
            }
            sectionInfo.setValue(name,startDate, endDate, description);
            map.put(sectionType, sectionInfo);
        }

        public void getInfo() {
            for(Map.Entry<SectionType, SectionInfo> pair: map.entrySet()){
                System.out.println(pair.getKey().getTitle() + ":");
                for(CommonDescription info: pair.getValue().getList()){
                    System.out.println(info);
                }
            }
        }
    }

    private class SectionInfo{
        private List<CommonDescription> list = new ArrayList<>();

        public void setValue(String name,String startDateString, String endDateString, String description) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date startDate = null;
            Date endDate = null;
            try {
                startDate = format.parse(startDateString);
                endDate = format.parse(endDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            CommonDescription commonDescription = new CommonDescription(name, startDate, endDate, description);
            list.add(commonDescription);
        }

        public List<CommonDescription> getList() {
            return list;
        }
    }
}
