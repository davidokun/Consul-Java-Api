package com.darksideofthedev.consuljavaapp.dynamic;

import com.netflix.config.AbstractPollingScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class PropertiesConfigurationScheduler extends AbstractPollingScheduler {

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    @Override
    protected void schedule(Runnable pollingRunnable) {
        executorService.scheduleAtFixedRate(pollingRunnable, 0, 10, TimeUnit.SECONDS);
    }

    @Override
    public void stop() {
        executorService.shutdown();
    }
}
