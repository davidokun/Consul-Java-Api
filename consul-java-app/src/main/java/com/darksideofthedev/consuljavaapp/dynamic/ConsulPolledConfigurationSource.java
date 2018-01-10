package com.darksideofthedev.consuljavaapp.dynamic;

import com.darksideofthedev.consuljavaapp.consul.ConsulManager;
import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConsulPolledConfigurationSource implements PolledConfigurationSource {

    @Autowired
    private ConsulManager consulManager;

    @Override
    public PollResult poll(boolean b, Object o) throws Exception {

        Map<String, Object> properties = consulManager.getProperties();

        return PollResult.createFull(properties);
    }
}
