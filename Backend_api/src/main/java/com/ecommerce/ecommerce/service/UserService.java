package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByNameAndPassword() throws UsernameNotFoundException {
        User user = userRepository.findUser();
        if(user == null){
            throw new UsernameNotFoundException("Invalid id and password");
        }
        return user;
    }
}
