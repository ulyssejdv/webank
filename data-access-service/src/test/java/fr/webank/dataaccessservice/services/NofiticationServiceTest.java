package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.controllers.NotificationController;
import fr.webank.dataaccessservice.entities.Account;
import fr.webank.dataaccessservice.entities.Notification;
import fr.webank.dataaccessservice.entities.Transaction;
import fr.webank.dataaccessservice.entities.TransactionType;
import fr.webank.dataaccessservice.repositories.INotificationRepository;
import fr.webank.webankmodels.NotificationDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * @author Alex
 */

@RunWith(MockitoJUnitRunner.class)
public class NofiticationServiceTest {

    @Mock
    private INotificationRepository notificationRepositoryMock;

    private List<Notification> notificationList;

    @InjectMocks
    private NotificationService notificationInjectMock;

    @Before
    public void setup() {
        notificationList = new ArrayList<>();
        Account accountTo = new Account();
        accountTo.setAccountNumber("ABCDEFGH12343");
        accountTo.setIdAccount((long)12343);

        Account accountFrom = new Account();
        accountFrom.setAccountNumber("AERZAZ");
        accountFrom.setIdAccount((long)99878);

        TransactionType transactionType = new TransactionType();
        transactionType.setIdTransactionType((long)12343);

        Transaction transaction1 = new Transaction();
        transaction1.setAccountFrom(accountFrom);
        transaction1.setAccountTo(accountTo);
        transaction1.setTransactionType(transactionType);

        transaction1.setTransactionAmount(1213);

        notificationList.add(new Notification((long)1,  transaction1, true));
        notificationList.add(new Notification((long)2,  transaction1, true));
    }

    @Test
    public void shouldRetrunListOfNotification() {

        when(notificationRepositoryMock.getCustomerNotifications(anyLong()))
                .thenReturn(notificationList);


        List<NotificationDTO> listNotif = notificationInjectMock.getClientNotifications(anyLong());


        boolean testOk = listNotif.size() == notificationList.size()
                && listNotif.get(0).getIdAccount() == notificationList.get(0).getTransaction().getAccountTo().getAccountNumber()
                && listNotif.get(0).getAmount().equals(new BigDecimal(notificationList.get(0).getTransaction().getTransactionAmount()))
                && listNotif.get(1).getIdAccount() == notificationList.get(1).getTransaction().getAccountTo().getAccountNumber()
                && listNotif.get(1).getAmount().equals(new BigDecimal(notificationList.get(1).getTransaction().getTransactionAmount()));

        Assert.assertTrue(testOk);
    }
}
