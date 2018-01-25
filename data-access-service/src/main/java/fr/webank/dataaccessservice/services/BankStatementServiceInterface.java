package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.exceptions.ObjectNotExistsException;
import fr.webank.webankmodels.BankStatementDto;

import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 28/11/2017.
 */
public interface BankStatementServiceInterface {

    List<BankStatementDto> getBankStatementByCustomer(Long customer) throws ObjectNotExistsException;

    Optional<BankStatementDto> getBankStatementById(Long id);
}
