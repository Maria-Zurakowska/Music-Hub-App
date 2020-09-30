package com.musichub.musichubapp.scheduler;

import com.musichub.musichubapp.config.AdminConfig;
import com.musichub.musichubapp.domain.Mail;
import com.musichub.musichubapp.repository.SearchHistoryRepository;
import com.musichub.musichubapp.service.SimpleEmailService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EmailSchedulerTest {

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Mock
    private SimpleEmailService simpleEmailServiceMock;
    @Mock
    private SearchHistoryRepository searchHistoryRepositoryMock;
    @Mock
    private AdminConfig adminConfigMock;

    @InjectMocks
    private EmailScheduler emailScheduler;



    @Test
    public void testSendInformationEmail() {

        // Given

        Mail mail = new Mail("kasia.budzyn@o2.pl", "Order#654", "Please, cancel the order", "anna.was@gmail.com");

        when(searchHistoryRepositoryMock.count()).thenReturn(0L);
        when(adminConfigMock.getAdminMail()).thenReturn("maria.zurakowska@gmail.com");

        // When
        emailScheduler.sendInformationEmail();

        // Then

        verify(simpleEmailServiceMock).send(any());
    }
}
