package com.DRServer.repository;

import com.DRServer.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hampus on 2017-01-15.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    User findFirstByToken(String token);

}
