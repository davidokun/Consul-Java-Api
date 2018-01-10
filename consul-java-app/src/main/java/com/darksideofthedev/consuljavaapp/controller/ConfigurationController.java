package com.darksideofthedev.consuljavaapp.controller;

import com.darksideofthedev.consuljavaapp.model.AppConfiguration;
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
    private AppConfiguration appConfiguration;

    @Autowired
    private ConfigService configService;

    @GetMapping("config")
    public ResponseEntity<AppConfiguration> getConfiguration() {

        configService.updateBeanConsfiguration();
        return new ResponseEntity<>(appConfiguration, HttpStatus.OK);
    }
}
