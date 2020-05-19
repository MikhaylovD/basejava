package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("uuid1", "Григорий Кислин");

        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContact(ContactType.SKYPE, "grigory.kislin");
        resume.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.setContact(ContactType.HOMEPAGE, "http://gkislin.ru/");

        resume.setSection(SectionType.OBJECTIVE, "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.setSection(SectionType.PERSONAL, "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        resume.setSection(SectionType.ACHIEVEMENT, "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников");
        resume.setSection(SectionType.ACHIEVEMENT, "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        resume.setSection(SectionType.ACHIEVEMENT, "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");

        resume.setSection(SectionType.QUALIFICATIONS, "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        resume.setSection(SectionType.QUALIFICATIONS, "Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        resume.setSection(SectionType.QUALIFICATIONS, "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");

        resume.setSection(SectionType.EXPERIENCE, "Alcatel", 9, 1997, 1, 2005, "Инженер по аппаратному и программному тестированию\n" +
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        resume.setSection(SectionType.EXPERIENCE, "Siemens AG", 1, 2005, 2, 2007, "Разработчик ПО\n" +
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        resume.setSection(SectionType.EXPERIENCE, "Java Online Projects", 10, 2013, 12, 2999, "\tАвтор проекта.\n" +
                "Создание, организация и проведение Java онлайн проектов и стажировок.");

        resume.setSection(SectionType.EDUCATION, "Заочная физико-техническая школа при МФТИ", 9, 1984, 6, 1987, "Закончил с отличием");
        resume.setSection(SectionType.EDUCATION, "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", 9, 1993, 7, 1996, "Аспирантура (программист С, С++)");

        resume.showResumeInfo();
    }
}
