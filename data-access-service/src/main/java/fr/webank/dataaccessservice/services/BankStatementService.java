package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.BankStatementEntity;
import fr.webank.dataaccessservice.entities.CustomerEntity;
import fr.webank.dataaccessservice.exceptions.ObjectNotExistsException;
import fr.webank.dataaccessservice.repositories.BankStatementRepository;
import fr.webank.dataaccessservice.repositories.CustomerRepository;
import fr.webank.webankmodels.BankStatementDto;
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
public class BankStatementService implements BankStatementServiceInterface {



    @Autowired
    BankStatementRepository bankStatementRepository;



    @Autowired
    CustomerRepository customerRepository;



    @Override
    public List<BankStatementDto> getBankStatementByCustomer(Long customerId) throws ObjectNotExistsException {

        CustomerEntity customerEntity = customerRepository.findOne(customerId);

        if (customerEntity == null) {
            throw new ObjectNotExistsException("customer entity not found");
        }

        List<BankStatementEntity> bankStatementEntities = bankStatementRepository
                .findBankStatementEntitiesByCustomer(customerEntity);

        List<BankStatementDto> bankStatementDtoList = bankStatementEntities
                .stream()
                .map(
                        b -> BankStatementDto
                                .builder()
                                .id(b.getId())
                                .createdAt(b.getCreatedAt().getTime())
                                .fileName(b.getFileUrl())
                                .build()
                ).collect(Collectors.toList());

        return bankStatementDtoList;
    }



    @Override
    public Optional<BankStatementDto> getBankStatementById(Long id) {

        BankStatementEntity bankStatementEntity = bankStatementRepository.findOne(id);

        Optional<BankStatementDto> optional = Optional.empty();

        if (bankStatementEntity != null) {
            optional = Optional.of(
                    BankStatementDto
                            .builder()
                            .id(bankStatementEntity.getId())
                            .createdAt(bankStatementEntity.getCreatedAt().getTime())
                            .fileName(bankStatementEntity.getFileUrl())
                            .build()
            );
        }

        return optional;
    }
}
