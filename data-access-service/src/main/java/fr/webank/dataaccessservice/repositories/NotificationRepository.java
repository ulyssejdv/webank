package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Notification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 */

@Repository
public class NotificationRepository implements INotificationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Notification> getCustomerNotifications(long idCustomer) {

        Query query = entityManager.createQuery("from Notification n " +
                "where n.transaction.accountFrom.customer.idCustomer = :idCustomer " +
                "or n.transaction.accountTo.customer.idCustomer = :idCustomer");

        query.setParameter("idCustomer",idCustomer);

        List<Notification> notificationArrayList = query.getResultList();

        return notificationArrayList;
    }

    @Transactional
    public Boolean markCustomerNotificationsAsRead(long idCustomer) {

        try {
            // can't use join in an HQL update query so get the unread customer notifications ids first
            Query query = entityManager.createQuery("select n.idNotification " +
                    "from Notification n " +
                    "where (n.transaction.accountFrom.customer.idCustomer = :idCustomer " +
                    "or n.transaction.accountTo.customer.idCustomer = :idCustomer) " +
                    "and n.read = false");

            query.setParameter("idCustomer",idCustomer);

            List<Long> unreadNotificationsList = query.getResultList();

            // then update the notifications from the list
            query = entityManager.createQuery("update Notification n " +
                    "set n.read = true " +
                    "where n.idNotification in (:notificationsIds)");

            query.setParameter("notificationsIds",unreadNotificationsList);

            query.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
