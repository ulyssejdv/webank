package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 09/11/2017.
 */
public interface UserServiceInterface {

    List<UserDto> getAll();

    Optional<UserDto> getUserById(String id);

    UserDto create(UserDto userDto);

    void delete(String id);

    void update(String id, UserDto userDto);
}