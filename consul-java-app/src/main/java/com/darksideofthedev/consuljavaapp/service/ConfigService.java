package com.darksideofthedev.consuljavaapp.service;

import com.darksideofthedev.consuljavaapp.model.Employee;
import com.darksideofthedev.consuljavaapp.util.DefaultPropertiesNames;
import com.netflix.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ConfigService implements Runnable {

    @Autowired
    private Employee employee;

    private DynamicIntProperty id;
    private DynamicStringProperty firstName;
    private DynamicStringProperty lastName;
    private DynamicLongProperty phoneNumber;
    private DynamicStringProperty address;

    @PostConstruct
    public void init() {

        id = DynamicPropertyFactory.getInstance()
                .getIntProperty(DefaultPropertiesNames.EMPLOYEE_ID.getName(), 11, this);

        firstName = DynamicPropertyFactory.getInstance()
                .getStringProperty(DefaultPropertiesNames.EMPLOYEE_FIRST_NAME.getName(), "John", this);

        lastName = DynamicPropertyFactory.getInstance()
                .getStringProperty(DefaultPropertiesNames.EMPLOYEE_LAST_NAME.getName(), "Doe", this);

        phoneNumber = DynamicPropertyFactory.getInstance()
                .getLongProperty(DefaultPropertiesNames.EMPLOYEE_PHONE_NUMBER.getName(), 555123, this);

        address = DynamicPropertyFactory.getInstance()
                .getStringProperty(DefaultPropertiesNames.EMPLOYEE_ADDRESS.getName(), "Fake Street 1", this);
    }

    private void updateBeanConfiguration() {
        employee.setId(id.get());
        employee.setFirstName(firstName.get());
        employee.setLastName(lastName.get());
        employee.setPhoneNumber(phoneNumber.get());
        employee.setAddress(address.get());
    }

    @Override
    public void run() {
        updateBeanConfiguration();
    }
}
