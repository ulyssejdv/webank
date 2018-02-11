package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ayda Najjar.
 */
@Repository
// implement the crud of stocks (create, read, update, delete)
public interface StockRepository extends JpaRepository<Stock, Long> {
    //SpringFramework generate the query "select * from stock" and return results
    // return the list of stocks from DB
    Page<Stock> findAll(Pageable pageable);

    @Query(value = "select s from Stock s " +
            "where s.stockId like %?1% " +
            "or s.stockDescription like %?1%",
       countQuery =  "select count(*) from Stock s " +
               "where s.stockId like %?1% " +
               "or s.stockDescription like %?1%")
    Page<Stock> FindByIdOrDescription(String search, Pageable pageable);
}
