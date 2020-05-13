package com.urise.webapp;

import com.urise.webapp.model.Resume;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("uuid1", "Mikhailov Dmitriy");

        resume.setContactDetails("SKYPE", "111111");
        resume.setContactDetails("PHONE", "99999999");
        resume.setContactDetails("EMAIL", "11111@mail.ru");

        resume.setMainInformation("EDUCATION", "University", 1, 2000, 12, 2000, "learn java");
        resume.setMainInformation("ACHIEVEMENT", "baseJava", 1, 2001, 12, 2001, "write programmes");
        resume.setMainInformation("EXPERIENCE", "baseJava", 1, 2002, 12, 2002, "create web app");

        resume.getResumeInfo();
    }
}
