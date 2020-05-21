package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

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

        StringSection stringSection = new StringSection();
        stringSection.setDescription("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.setSection(SectionType.OBJECTIVE, stringSection);

        StringSection stringSection2 = new StringSection();
        stringSection2.setDescription("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.setSection(SectionType.PERSONAL, stringSection2);

        ListSection listSection = new ListSection();
        listSection.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников");
        listSection.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        listSection.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        resume.setSection(SectionType.ACHIEVEMENT, listSection);

        ListSection listSection2 = new ListSection();
        listSection2.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        listSection2.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        listSection2.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        resume.setSection(SectionType.QUALIFICATIONS, listSection2);

        OrganizationSection organizationSection = new OrganizationSection();
        Position position = new Position("Alcatel", YearMonth.of(1997, 9), YearMonth.of(2005, 1), "Инженер по аппаратному и программному тестированию\n" +
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        Position position2 = new Position("Siemens AG", YearMonth.of(2005, 1), YearMonth.of(2007, 2), "Разработчик ПО\n" +
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        Position position3 = new Position("Java Online Projects", YearMonth.of(2013, 10), YearMonth.of(2999, 12), "\tАвтор проекта.\n" +
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        organizationSection.add(position);
        organizationSection.add(position2);
        organizationSection.add(position3);
        resume.setSection(SectionType.EXPERIENCE, organizationSection);

        OrganizationSection organizationSection2 = new OrganizationSection();
        Position position4 = new Position("Заочная физико-техническая школа при МФТИ", YearMonth.of(1984, 9), YearMonth.of(1987, 6), "Закончил с отличием");
        Position position5 = new Position("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", YearMonth.of(1993, 9), YearMonth.of(1996, 7), "Закончил с отличием");
        organizationSection2.add(position4);
        organizationSection2.add(position5);
        resume.setSection(SectionType.EDUCATION, organizationSection2);

        System.out.println(resume);
    }
}
