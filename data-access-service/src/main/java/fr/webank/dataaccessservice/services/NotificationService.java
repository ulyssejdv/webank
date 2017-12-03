package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Notification;
import fr.webank.webankmodels.NotificationDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alex
 */

@Service
public class NotificationService {

    public List<NotificationDTO> getClientNotifications(long idClient) {

        List<NotificationDTO> notificationDTOList = new ArrayList<NotificationDTO>();

        NotificationDTO notif1 = new NotificationDTO();
        notif1.setAmount(new BigDecimal(150.50));
        notif1.setDate("01/01/2017 13:09");
        notif1.setIdAccount("FR 1983783");
        notif1.setRead(false);
        notif1.setTransactionType("virement");

        NotificationDTO notif2 = new NotificationDTO();
        notif2.setAmount(new BigDecimal(14.58));
        notif2.setDate("02/02/2017 21:30");
        notif2.setIdAccount("FR 000001");
        notif2.setRead(true);
        notif2.setTransactionType("remise de cheques");

        notificationDTOList.add(notif1);
        notificationDTOList.add(notif2);

        return notificationDTOList;
    }

}
