package fr.webank.dataaccessservice.controllers;


import fr.webank.dataaccessservice.services.NotificationService;
import fr.webank.webankmodels.NotificationDTO;
import fr.webank.webankmodels.StockPriceDto;

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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Alex
 */

@RunWith(MockitoJUnitRunner.class)
public class NotificationControllerTest {

    @Mock
    private NotificationService notificationServiceMock;

    private List<NotificationDTO> notificationDTOList;

    @InjectMocks
    private NotificationController notificationControllerInjectMock;

    @Before
    public void setup() {
        notificationDTOList = new ArrayList<>();

        notificationDTOList.add(new NotificationDTO("AY0001", new BigDecimal(100), "26/09/2017", "Retrait", true));
        notificationDTOList.add(new NotificationDTO("AY0002", new BigDecimal(110), "26/09/2017", "Retrait", true));
        notificationDTOList.add(new NotificationDTO("AY0003", new BigDecimal(10000), "26/09/2017", "Retrait", true));
        notificationDTOList.add(new NotificationDTO("AY0004", new BigDecimal(-100), "26/09/2017", "Retrait", true));
    }

    @Test
    public void shouldRetrunListOfNotification() {

        when(notificationServiceMock.getClientNotifications(anyLong()))
                .thenReturn(notificationDTOList);


        ResponseEntity<List<NotificationDTO>> response = notificationControllerInjectMock.getClientNotifications(anyLong());

        List<NotificationDTO> body = (List<NotificationDTO>)response.getBody();

        boolean testOk = response.getStatusCode() == HttpStatus.OK
                && body.size() == notificationDTOList.size();

        Assert.assertTrue(testOk);
    }
    
    @Test
    public void shouldReturnNotificationNotFound() {
        when(notificationServiceMock.getClientNotifications(anyLong()))
                .thenReturn(null);

        ResponseEntity<List<NotificationDTO>> response = notificationControllerInjectMock.getClientNotifications(anyLong());

        boolean testOk = response.getStatusCode() == HttpStatus.NOT_FOUND;

        Assert.assertTrue(testOk);
    }

}
