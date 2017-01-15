package com.DRServer.service;

import com.DRServer.domain.Reminder;
import com.DRServer.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Hampus on 2017-01-15.
 */
@Component
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    ReminderRepository reminderRepository;
    @Autowired
    UserService userService;

    @Override
    public Reminder addReminder(Reminder reminder, String token) {
        reminder.setUser(userService.getUserByToken(token)); // Gets the user with the token, so the reminder is connected to a user
        return reminderRepository.save(reminder);
    }

    @Override
    public Reminder updateReminder(Reminder reminder) {
        return null;
    }

    @Override
    public void deleteReminder(Long id) {
        reminderRepository.delete(id);
    }

    @Override
    public Reminder getReminder(Long id, String token) {
        if(userService.checkToken(token)){
            return reminderRepository.findOne(id);
        }
        else{
            return null;
        }
    }
}
