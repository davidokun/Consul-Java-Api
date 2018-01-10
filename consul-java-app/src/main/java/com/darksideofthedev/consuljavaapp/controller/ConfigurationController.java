package com.darksideofthedev.consuljavaapp.controller;

import com.darksideofthedev.consuljavaapp.model.AppConsulConfiguration;
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
    private AppConsulConfiguration appConsulConfiguration;

    @GetMapping("config")
    public ResponseEntity<AppConsulConfiguration> getConfiguration() {
        return new ResponseEntity<>(appConsulConfiguration, HttpStatus.OK);
    }
}
