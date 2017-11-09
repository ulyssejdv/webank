package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.UserEntity;
import fr.webank.dataaccessservice.repositories.UserRepository;
import fr.webank.webankmodels.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ulysse on 09/11/2017.
 */
@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(
                        u -> UserDto.builder()
                                .id(String.valueOf(u.getId()))
                                .firstName(u.getFirstName())
                                .lastName(u.getLastName())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(String id) {
        UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
        return (userEntity != null) ?
                Optional.of(
                        UserDto.builder()
                                .id(String.valueOf(userEntity.getId()))
                                .firstName(userEntity.getFirstName())
                                .lastName(userEntity.getLastName())
                                .build()
                )
                : Optional.empty();
    }

    @Override
    public UserDto create(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        UserEntity userEntity1 = userRepository.save(userEntity);
        return UserDto.builder()
                .id(String.valueOf(userEntity1.getId()))
                .firstName(userEntity1.getFirstName())
                .lastName(userEntity1.getLastName())
                .build();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id, UserDto userDto) {

    }
}
