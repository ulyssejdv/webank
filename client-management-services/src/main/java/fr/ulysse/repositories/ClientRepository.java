package fr.ulysse.repositories;

import fr.ulysse.models.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ulysse on 19/10/2017.
 */
public interface ClientRepository extends CrudRepository<ClientEntity, Long>{
    List<ClientEntity> findAll();
}
