package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author Alex
 */

public interface NotificationRepository extends CrudRepository<Notification, Long> {
    // return
    List<Notification> findByCustomer(int idCustomer);
}