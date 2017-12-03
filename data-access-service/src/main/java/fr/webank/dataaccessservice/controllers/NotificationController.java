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

    @RequestMapping(path = "/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationDTO>> getClientNotifications(@PathVariable long clientId) {

        List<NotificationDTO> notificationDTOList = notificationService.getClientNotifications(1);

        // return the notifications to the client
        return new ResponseEntity<List<NotificationDTO>>(notificationDTOList, HttpStatus.OK);
    }

}
