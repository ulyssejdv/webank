package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.BankStatementEntity;
import fr.webank.dataaccessservice.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ulysse on 28/11/2017.
 */
public interface BankStatementRepository extends CrudRepository<BankStatementEntity, Long> {

    List<BankStatementEntity> findBankStatementEntitiesByCustomer(CustomerEntity customer);
}
