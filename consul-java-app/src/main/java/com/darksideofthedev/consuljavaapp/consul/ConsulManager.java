package com.darksideofthedev.consuljavaapp.consul;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConsulManager {

    @Value("${consul.host}")
    private String consulHost;

    @Value("${consul.port}")
    private int consulPort;

    @Value("${consul.path}")
    private String consulPath;

    private ConsulClient client;

    @PostConstruct
    private void init() {
        client = new ConsulClient(consulHost, consulPort);
    }

    public void createKV(String key, String value) {
        client.setKVValue(consulPath + key, value);
    }

    public String getProperty(String key){
        return client.getKVValue(consulPath + key).getValue().getDecodedValue();
    }

    public Map<String, Object> getProperties() {

        Map<String, Object> map = new HashMap<>();
        client.getKVValues(consulPath).getValue().forEach(v -> map.put(v.getKey().replace(consulPath, ""), v.getDecodedValue()));

        return map;

    }

}
