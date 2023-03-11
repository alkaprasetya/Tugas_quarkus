package id.kawahedukasi.service;

import io.quarkus.scheduler.Scheduled;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;


@ApplicationScoped
public class ScheduleService {
    @Inject

    MailService mailService;

    Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    @Scheduled(every = "1h")

    public void generatetimeItem(){
        logger.info("JadwalItem_{}", LocalDateTime.now());
    }

    @Scheduled(cron = "* 2 1 ? * * *")

    public void ScheduleemailItem() throws IOException {
        mailService.sendExcelToEmail("alkaprasetya17@gmail.com");
        logger.info("Email nya mantap");
    }



}
