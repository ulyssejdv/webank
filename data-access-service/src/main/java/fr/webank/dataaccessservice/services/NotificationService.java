package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Notification;
import fr.webank.dataaccessservice.repositories.INotificationRepository;
import fr.webank.webankmodels.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alex
 */

@Service
public class NotificationService {

    @Autowired
    private INotificationRepository notificationRepository;

    public List<NotificationDTO> getClientNotifications(long idCustomer) {

        // get customer notifications from the repository
        List<Notification> notificationList = notificationRepository.getCustomerNotifications(idCustomer);

        // create an empty list of notification
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        NotificationDTO notificationDTO;

        // browse the Notification list, build NotificationDTO objects and put them in a list
        for (Notification notification : notificationList) {
            notificationDTO = new NotificationDTO();

            // set transaction amount
            BigDecimal amount = new BigDecimal(notification.getTransaction().getTransactionAmount());
            if (amount != null) {
                notificationDTO.setAmount(amount);
            } else {
                amount = new BigDecimal(0);
            }

            // set transaction date
            Date transactionDate = notification.getTransaction().getTransactionDate();
            if (transactionDate != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                notificationDTO.setDate(sdf.format(notification.getTransaction().getTransactionDate()));
            } else {
                notificationDTO.setDate("Date inconnue");
            }

            // set transaction account id
            String accountNumber = notification.getTransaction().getAccountTo().getAccountNumber();
            if (accountNumber != null) {
                notificationDTO.setIdAccount(accountNumber);
            } else {
                notificationDTO.setIdAccount("Compte inconnu");
            }

            // set notification read or not read status
            notificationDTO.setRead(notification.isRead());

            // set transaction type
            String transactionType = notification.getTransaction().getTransactionType().getTransactionTypeName();
            if (transactionType != null) {
                notificationDTO.setTransactionType(transactionType);
            } else {
                notificationDTO.setTransactionType("Type inconnu");
            }

            // add the notification to the notifications list
            notificationDTOList.add(notificationDTO);
        }

        // return the NotificationDTO list created previously
        return notificationDTOList;
    }

}
