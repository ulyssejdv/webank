package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Notification;

import java.util.List;

/**
 * @author Alex
 */

public interface INotificationRepository {
    List<Notification> getCustomerNotifications(long idCustomer);
    Boolean markCustomerNotificationsAsRead(long idCustomer);
}
