package com.citymanager.Secretariat.enums;

public enum Folder {

    HEALTH("HEALTH"), 
    EDUCATION("EDUCATION"), 
    SPORTS("SPORTS"), 
    INFRASTRUCTURE("INFRASTRUCTURE");

    private final String value;

    private Folder(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
