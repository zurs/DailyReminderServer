package com.DRServer.service;

import com.DRServer.domain.User;
import com.DRServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

/**
 * Created by Hampus on 2017-01-15.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkToken(String token) { // Check if the token exists, used when logging in
        boolean found = true;
        try{
            userRepository.findFirstByToken(token);
        }catch (DataAccessException e){
            found = false;
        }
        return found;
    }

    @Override
    public User getUserByToken(String token) {
        return userRepository.findFirstByToken(token);
    }

    @Override
    public User registerUser(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }
}
