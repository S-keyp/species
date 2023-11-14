package com.example.species.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {

    @Scheduled(cron = "${cron.value}")
	public void cron(){
        System.out.println("Cronnnnn");
	}
}
