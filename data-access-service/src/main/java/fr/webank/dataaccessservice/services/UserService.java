package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.UserEntity;
import fr.webank.dataaccessservice.repositories.UserRepository;
import fr.webank.webankmodels.UserDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ulysse on 09/11/2017
 */
@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    DozerBeanMapper mapper = new DozerBeanMapper();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(
                        u -> mapper.map(u, UserDto.class)
                )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(String id) {
        UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
        return (userEntity != null) ?
                Optional.of(
                        mapper.map(userEntity, UserDto.class)
                )
                : Optional.empty();
    }

    @Override
    public UserDto create(UserDto userDto) {
        UserEntity userEntity = userRepository.save(mapper.map(userDto,UserEntity.class));
        return mapper.map(userEntity, UserDto.class);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id, UserDto userDto) {

    }
}
