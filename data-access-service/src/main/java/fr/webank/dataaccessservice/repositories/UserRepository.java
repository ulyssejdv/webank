package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ulysse on 09/11/2017.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
}
