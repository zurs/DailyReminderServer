package com.DRServer.controller;

import com.DRServer.domain.Reminder;
import com.DRServer.service.ReminderService;
import com.DRServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hampus on 2017-01-15.
 */
@RestController
public class ReminderController {

    ReminderService reminderService;
    UserService userService;

    @Autowired
    public ReminderController(ReminderService reminderService, UserService userService){
        this.reminderService = reminderService;
        this.userService = userService;
    }

    @RequestMapping(value = "/{token}", method = RequestMethod.POST)
    public Reminder addReminder(@PathVariable(value = "token") String token,
                                @RequestBody Reminder newReminder){
        return reminderService.addReminder(newReminder, token);
    }

    @RequestMapping(value = "/{token}/{id}", method = RequestMethod.GET)
    public Reminder getReminder(@PathVariable(value = "token") String token,
                                @PathVariable(value = "id") Long id){
        return reminderService.getReminder(id, token);
    }

    @RequestMapping(value = "/{token}/{id}", method = RequestMethod.PUT)
    public Reminder updateReminder(@PathVariable(value = "id") Long id,
                                @PathVariable(value = "token") String token,
                                @RequestBody Reminder reminder){
        if(userService.checkToken(token)) {
            return reminderService.updateReminder(id, reminder);
        }
        else{
            return new Reminder(0, 0, null, null);
        }
    }

    @RequestMapping(value = "/{token}/{id}/done", method = RequestMethod.PUT)
    public void setReminderToDone(@PathVariable(value = "id") Long id,
                                  @PathVariable(value = "token") String token){
        if(!userService.checkToken(token)){
            return;
        }
        reminderService.setToDone(id);
    }

}
