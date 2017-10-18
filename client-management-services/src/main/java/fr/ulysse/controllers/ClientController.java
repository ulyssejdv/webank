package fr.ulysse.controllers;

import fr.ulysse.models.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by ulysse on 17/10/2017.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ArrayList<UserDto> database;

    /**
     * This controller is here just for seed the fake users database
     */
    public ClientController() {
        // This is my fake user database
        this.database = new ArrayList<UserDto>();
        for (int i=0 ; i<10; i++) {
            database.add(new UserDto(
                    (long) i,
                    "nom "+i,
                    "prenom "+ i
            ));
        }
    }

    /**
     * Get all users in the database
     * @return
     */
    @GetMapping
    public ArrayList<UserDto> list() {
        return this.database;
    }

    /**
     * Get the user corresponding to this id in PathVariable
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UserDto retrieve(@PathVariable Long id) {
        UserDto userDto = null;
        for (UserDto u: this.database) {
            if (u.getId() == id) {
                userDto = u;
            }
        }
        return userDto;
    }


    /**
     * Create a new user in the database
     * @param input
     * @return
     */
    @PostMapping
    public UserDto create(@RequestBody UserDto input) {
        this.database.add(input);
        return input;
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
        UserDto userDto = null;
        for (UserDto u: this.database) {
            if (u.getId() == id) {
                userDto = u;
            }
        }
        database.remove(userDto);
    }

}
