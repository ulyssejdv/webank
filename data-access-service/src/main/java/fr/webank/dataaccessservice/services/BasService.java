package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.BasEntity;
import fr.webank.dataaccessservice.entities.CustomerEntity;
import fr.webank.dataaccessservice.repositories.BasRepository;
import fr.webank.dataaccessservice.repositories.CustomerRepository;
import fr.webank.webankmodels.BasDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ulysse on 28/11/2017.
 */
@Log
@Service
public class BasService implements BasServiceInterface {

    @Autowired
    BasRepository basRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<BasDto> getBasByCustomer(Long customerId) {

        List<BasDto> basDtoList = null;
        List<BasEntity> basEntities = null;

        CustomerEntity customerEntity = customerRepository.findOne(customerId);

        if (customerEntity != null) {
            basEntities = basRepository.findBasEntitiesByCustomer(customerEntity);
        }

        if (basEntities != null) {
            basDtoList = basEntities.stream().map(
                    b -> BasDto.builder()
                            .id(b.getId())
                            .createdAt(b.getCreatedAt().getTime())
                            .fileName(b.getFileUrl())
                            .build()
            ).collect(Collectors.toList());
        }

        return basDtoList;
    }

    @Override
    public Optional<BasDto> getBasById(Long id) {
        BasEntity basEntity = basRepository.findOne(id);
        return (basEntity != null) ?
                Optional.of(
                        BasDto.builder()
                                .id(basEntity.getId())
                                .createdAt(basEntity.getCreatedAt().getTime())
                                .fileName(basEntity.getFileUrl())
                                .build()
                )
                : Optional.empty();
    }
}
