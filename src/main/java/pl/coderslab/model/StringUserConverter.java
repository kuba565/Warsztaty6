package pl.coderslab.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.repository.UserRepository;

public class StringUserConverter implements Converter<String, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String name) {
        User user = userRepository.getUserByUsername(name);
        return user;
    }

}