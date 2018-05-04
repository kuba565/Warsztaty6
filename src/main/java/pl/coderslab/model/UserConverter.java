package pl.coderslab.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.repository.UserRepository;


public class UserConverter implements Converter<Long, User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(Long id) {
        User user = userRepository.getOne(id);
        return user;
    }


}