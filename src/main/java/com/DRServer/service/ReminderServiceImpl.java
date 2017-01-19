package com.DRServer.service;

import com.DRServer.domain.Reminder;
import com.DRServer.domain.User;
import com.DRServer.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.*;

import java.security.MessageDigest;
import java.util.List;

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
    public Reminder updateReminder(Long id, Reminder reminder) {
        reminder.setId(id);
        reminderRepository.save(reminder);
        return reminder;
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

    @Override
    public void setToDone(Long id) {
        Reminder reminder = reminderRepository.findOne(id);
        reminder.setDone(true);
        reminderRepository.save(reminder);
    }

    @Override
    public String getSHA256OfAllReminders(String token) {
        User user = userService.getUserByToken(token);
        List<Reminder> reminders = reminderRepository.findByUser(user);
        String stringToBeHashed = "";
        for(Reminder reminder : reminders){
            stringToBeHashed += reminder.getTitle() + reminder.getDays() + reminder.isDone() + reminder.getId();
        }
        try{
            byte[] bytesOfMessage = stringToBeHashed.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
        }catch (UnsupportedEncodingException e){
            System.out.println("Something went wrong!!!");
            return "none";
        }catch (NoSuchAlgorithmException ae){
            System.out.println("Something went wrong");
            return "none";
        }
        System.out.println();
    }
}
