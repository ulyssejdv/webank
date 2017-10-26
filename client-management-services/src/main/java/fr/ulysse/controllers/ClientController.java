package fr.ulysse.controllers;

import fr.ulysse.models.ClientDto;
import fr.ulysse.models.ClientEntity;
import fr.ulysse.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ulysse on 17/10/2017.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * This controller is here just for seed the fake users database
     */
    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Get all users in the database
     * @return
     */
    @GetMapping
    public List<ClientEntity> list() {
        return this.clientRepository.findAll();
    }

    /**
     * Get the user corresponding to this id in PathVariable
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ClientEntity retrieve(@PathVariable Long id) {
        return this.clientRepository.findOne(id);
    }


    /**
     * Create a new user in the database
     * @param input
     * @return
     */
    @PostMapping
    public ClientEntity create(@RequestBody ClientEntity input) {
        return this.clientRepository.save(input);
    }

    /**
     *
     */
    @PutMapping("/{id}")
    public void update(@PathVariable Long id) {
        // TODO : update this user
    }

    @PatchMapping("/{id}")
    public void partialUpdate(@PathVariable Long id) {
        // TODO : update the specified fields of this user
    }

    @DeleteMapping("/{id}")
    public void detroy(@PathVariable Long id) {
        this.clientRepository.delete(id);
    }

}
