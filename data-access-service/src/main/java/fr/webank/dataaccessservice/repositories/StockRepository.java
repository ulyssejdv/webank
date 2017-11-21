package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<StockEntity, Long> {
    List<StockEntity> findAll();
}
