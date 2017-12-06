package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Notification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        //Query query = entityManager.createQuery("select c from Conversation c where c.customer.id = :idCustomer");
        //query.setParameter("idCustomer",idCustomer);

        Query query = entityManager.createQuery("select n " +
                "from Notification n " +
                "where n.transaction.accountFrom.customer.idCustomer = :idCustomer " +
                "or n.transaction.accountTo.customer.idCustomer = :idCustomer");
        query.setParameter("idCustomer",idCustomer);

        List<Notification> notificationArrayList = query.getResultList();

        /*for (Notification n : notificationArrayList) {
            System.out.println("amount : " + n.getTransaction().getTransactionAmount());
        }*/

        /*List<Notification> notificationArrayList = new ArrayList<Notification>();
        Notification n = new Notification();
        notificationArrayList.add(n);*/

        return notificationArrayList;
    }

}
