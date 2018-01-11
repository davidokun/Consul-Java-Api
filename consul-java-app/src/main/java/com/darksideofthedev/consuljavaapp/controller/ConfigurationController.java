package com.darksideofthedev.consuljavaapp.controller;

import com.darksideofthedev.consuljavaapp.model.Employee;
import com.darksideofthedev.consuljavaapp.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class ConfigurationController {

    @Autowired
    private Employee employee;

    @Autowired
    private ConfigService configService;

    @GetMapping("employee")
    public ResponseEntity<Employee> getConfiguration() {

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
