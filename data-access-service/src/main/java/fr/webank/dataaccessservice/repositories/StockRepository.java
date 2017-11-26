package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// implement the crud of stocks (create, read, update, delete)
public interface StockRepository extends CrudRepository<Stock, Long> {
    // return the list of stocks from DB
    List<Stock> findAll();
}
