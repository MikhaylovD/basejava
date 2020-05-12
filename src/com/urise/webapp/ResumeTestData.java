package com.urise.webapp;

import com.urise.webapp.model.Resume;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("uuid1", "Mikhailov Dmitriy");

        resume.setContactDetails("SKYPE", "111111");
        resume.setContactDetails("PHONE", "99999999");
        resume.setContactDetails("EMAIL", "11111@mail.ru");

        resume.setMainInformation("EDUCATION","University","01/01/2000","31/12/2000","learn java");
        resume.setMainInformation("ACHIEVEMENT","baseJava","01/01/2001","31/12/2001","write programmes");
        resume.setMainInformation("EXPERIENCE","baseJava","01/01/2002","31/12/2003","create web app");

        resume.getResumeInfo();
    }
}
