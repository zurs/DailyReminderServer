package com.DRServer.service;

import com.DRServer.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Hampus on 2017-01-15.
 */
@Service
public interface UserService {

    boolean checkToken(String token);

    User getUserByToken(String token);

    User registerUser(User newUser);


}
