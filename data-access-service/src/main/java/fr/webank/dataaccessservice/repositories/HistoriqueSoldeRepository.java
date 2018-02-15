package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.HistoriqueSolde;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriqueSoldeRepository extends JpaRepository<HistoriqueSolde, Long> {

    List<HistoriqueSolde> findAll();

    List<HistoriqueSolde> findOrderByidClient(Long idClient);

    @Query(value = "select hs from HistoriqueSolde hs " +
            "where historiqueId = (select max(h.historiqueId) from HistoriqueSolde h where h.idClient = hs.idClient)",
            countQuery =  "select count(*) from HistoriqueSolde hs " +
            "where historiqueId = (select max(h.historiqueId) from HistoriqueSolde h where h.idClient = hs.idClient)"
            )
    Page<HistoriqueSolde> distinctUser(Pageable pageable);

    @Query(value = "select hs from HistoriqueSolde hs " +
            "where hs.idClient = ?1 order by hs.year desc, hs.month desc"
    )
    Page<HistoriqueSolde> GetHistory(Long idClient, Pageable pageable);

    @Query(value = "select hs from HistoriqueSolde hs " +
            "where hs.categorie = ?1 order by hs.idClient asc, hs.year asc, hs.month asc"
    )
    List<HistoriqueSolde> GetHistoryByCategorie(Integer categorie);
}
