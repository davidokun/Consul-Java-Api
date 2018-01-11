package com.darksideofthedev.consuljavaapp.util;

public enum DefaultPropertiesNames {

    EMPLOYEE_ID             ("employee.id"),
    EMPLOYEE_FIRST_NAME     ("employee.firstName"),
    EMPLOYEE_LAST_NAME      ("employee.LastName"),
    EMPLOYEE_PHONE_NUMBER   ("employee.phoneNumber"),
    EMPLOYEE_ADDRESS        ("employee.address");

    private String name;

    DefaultPropertiesNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
