package com.darksideofthedev.consuljavaapp.service;

import com.darksideofthedev.consuljavaapp.model.AppConfiguration;
import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ConfigService implements Runnable {

    @Autowired
    private AppConfiguration appConfiguration;

    private DynamicIntProperty ttl;

    @PostConstruct
    public void init() {

        ttl = DynamicPropertyFactory.getInstance().getIntProperty("couchbase.ttl", 11, this);
    }

    public void updateBeanConfiguration() {
        appConfiguration.setTimeToLive(ttl.get());
    }

    @Override
    public void run() {
        updateBeanConfiguration();
    }
}
