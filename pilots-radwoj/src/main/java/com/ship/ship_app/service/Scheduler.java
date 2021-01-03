package com.ship.ship_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class Scheduler {
    private ShipManager shipManager;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    @Autowired
    public Scheduler(ShipManager shipManager) {
        this.shipManager = shipManager;
    }

    @Scheduled(cron = "0 * * ? * *")
    public void test() {
        try {
            shipManager.updateAllChanges();
            System.out.println("=========================");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
