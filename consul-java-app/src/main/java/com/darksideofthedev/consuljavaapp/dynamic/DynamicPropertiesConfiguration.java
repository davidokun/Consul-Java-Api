package com.darksideofthedev.consuljavaapp.dynamic;

import com.netflix.config.AbstractPollingScheduler;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.PolledConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DynamicPropertiesConfiguration {

    @Autowired
    private PolledConfigurationSource source;
    @Autowired
    private AbstractPollingScheduler scheduler;

    @PostConstruct
    public void init(){
        DynamicConfiguration configuration = new DynamicConfiguration(source, scheduler);
        ConfigurationManager.install(configuration);
    }

}
