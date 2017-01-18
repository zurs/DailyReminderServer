package com.DRServer.service;

import com.DRServer.domain.Reminder;
import org.springframework.stereotype.Service;

/**
 * Created by Hampus on 2017-01-15.
 */
@Service
public interface ReminderService {

    Reminder addReminder(Reminder reminder, String token);

    Reminder updateReminder(Long id, Reminder reminder);

    void deleteReminder(Long id);

    Reminder getReminder(Long id, String token);

    void setToDone(Long id);
}
