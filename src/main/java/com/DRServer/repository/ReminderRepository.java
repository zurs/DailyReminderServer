package com.DRServer.repository;

import com.DRServer.domain.Reminder;
import com.DRServer.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Hampus on 2017-01-15.
 */
public interface ReminderRepository extends CrudRepository<Reminder, Long> {

    List<Reminder> findByUser(User user);

}
