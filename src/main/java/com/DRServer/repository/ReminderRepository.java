package com.DRServer.repository;

import com.DRServer.domain.Reminder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hampus on 2017-01-15.
 */
public interface ReminderRepository extends CrudRepository<Reminder, Long> {



}
