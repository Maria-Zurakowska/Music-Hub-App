package com.musichub.musichubapp.scheduler;
import com.musichub.musichubapp.config.AdminConfig;
import com.musichub.musichubapp.domain.Mail;
import com.musichub.musichubapp.repository.SearchHistoryRepository;
import com.musichub.musichubapp.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @Autowired
    private AdminConfig adminConfig;

    //@Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = searchHistoryRepository.count();
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + size + ((size ==1)? " item in your search history": " items in your search history"),
                "test@gmail.com"
        ));
    }

    private static final String SUBJECT = "Items in search history: Once a day email";
}
