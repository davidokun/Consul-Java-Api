package com.darksideofthedev.consuljavaapp.consul;

import com.darksideofthedev.consuljavaapp.util.DefaultPropertiesNames;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.kv.model.GetValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
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
        createKV(DefaultPropertiesNames.EMPLOYEE_ID.getName(), "1");
        createKV(DefaultPropertiesNames.EMPLOYEE_FIRST_NAME.getName(), "Jon");
        createKV(DefaultPropertiesNames.EMPLOYEE_LAST_NAME.getName(), "Doe");
        createKV(DefaultPropertiesNames.EMPLOYEE_PHONE_NUMBER.getName(), "555123");
        createKV(DefaultPropertiesNames.EMPLOYEE_ADDRESS.getName(), "Fake Street 1");
    }

    public void createKV(String key, String value) {
        client.setKVValue(consulPath + key, value);
    }

    public String getProperty(String key){
        return client.getKVValue(consulPath + key).getValue().getDecodedValue();
    }

    public Map<String, Object> getProperties() {

        Map<String, Object> map = new HashMap<>();
        Response<List<GetValue>> listResponse = client.getKVValues(consulPath);
        if (listResponse.getValue() != null){
            listResponse.getValue().forEach(v -> map.put(v.getKey().replace(consulPath, ""), v.getDecodedValue()));
        }

        return map;

    }

}
