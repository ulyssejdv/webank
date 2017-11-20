package fr.webank.dataaccessservice.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.webank.dataaccessservice.services.CustomerService;
import fr.webank.webankmodels.CustomerDto;


@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
        // TODO
        final Optional<CustomerDto> dtoOpt = customerService.getUserById(id);
        return (dtoOpt.isPresent()) ?
                new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * If page and size request parameters are filled, return a page. Otherwise, return a list of all elements.
     *
     * @param page      Page index, starts with 0
     * @param size      Page size
     * @return          Can return a TODO @link org.springframework.data.domain.Page OR a {@link List} of DTO
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        // Pagination
        if (page != null && size != null) {
            // TODO
        }

        // TODO
        final List<CustomerDto> customerDtoList = Collections.emptyList();
        return (!customerDtoList.isEmpty()) ?
                new ResponseEntity<>(customerDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customer) {
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CustomerDto customer) {
        // TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        // TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
