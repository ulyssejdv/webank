package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.NotificationService;
import fr.webank.webankmodels.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alex
 */

@RestController
@RequestMapping(path = "/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping(path = "/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationDTO>> getClientNotifications(@PathVariable long customerId) {
        // get customer notifications
        List<NotificationDTO> notificationDTOList = notificationService.getClientNotifications(customerId);

        // return the notifications to the client
        return new ResponseEntity<List<NotificationDTO>>(notificationDTOList, HttpStatus.OK);
    }

    // TODO : à appeler dans le code webapp SEULEMENT QUAND TOUT S'EST BIEN PASSé
    // limite côté client en Ajax si la page a bien chargé (status 200 ou autre méthode)
    @RequestMapping(path = "/markasread/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<String> markCustomerNotificationsAsRead(@PathVariable long customerId) {
        String message = "wesh alors";

        // set customer notifications as read and get the response
        // bool = appelerMethode... ou bien exception et dans ce cas on balande un message d'erreur en réponse.
        Boolean ok = notificationService.markCustomerNotificationsAsRead(customerId);

        if (ok) {
            message = "VOILA BON, OK BABY";
        } else {
            message = "ca va pas...";
        }

        // TODO : 200 si ok, 400 si KO, + message dans les deux cas
        // TODO : creer une class "ResponseMessage" avec un message comme attribut ?! ou jsute une vieille string perrave
        // https://apigee.com/about/blog/technology/restful-api-design-what-about-errors

        // return the notifications to the client
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
