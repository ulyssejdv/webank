package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.BasService;
import fr.webank.webankmodels.BasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 28/11/2017.
 */
@RestController
@RequestMapping(path = "/bas")
public class BasController {
    @Autowired
    BasService basService;


    @GetMapping("/{basId}")
    public ResponseEntity<BasDto> getBasById(@PathVariable Long basId) {
        final Optional<BasDto> dtoOpt = basService.getBasById(basId);
        return (dtoOpt.isPresent()) ?
                new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getAllBasForCustomer(@PathVariable Long customerId) {

        final List<BasDto> basDtoList = basService.getBasByCustomer(customerId);

        if (!basDtoList.isEmpty()) {
            return new ResponseEntity<>(basDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
