package com.urise.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Skype"),
    EMAIL("Электронная почта"),
    LINKEDIN("LinkedIn"),
    GITHUB("GitHub"),
    STACKOVERFLOW("Образование"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
