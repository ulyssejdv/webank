package controllers;

import org.springframework.web.bind.annotation.*;

/**
 * Created by ulysse on 16/10/2017.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    @GetMapping
    public void list() {

    }

    @GetMapping("/{id}")
    public void retrieve() {

    }

    @PostMapping
    public void create() {

    }

    @PutMapping("/{id}")
    public void update() {

    }

    @PatchMapping("/{id}")
    public void partialUpdate() {

    }

    @DeleteMapping("/{id}")
    public void detroy() {

    }
}
