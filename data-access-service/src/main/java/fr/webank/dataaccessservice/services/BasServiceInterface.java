package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.BasDto;

import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 28/11/2017.
 */
public interface BasServiceInterface {

    List<BasDto> getBasByCustomer(Long customer);

    Optional<BasDto> getBasById(Long id);
}
