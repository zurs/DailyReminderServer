package com.DRServer.controller;

import com.DRServer.domain.Reminder;
import com.DRServer.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hampus on 2017-01-15.
 */
@RestController
public class ReminderController {

    ReminderService reminderService;

    @Autowired
    public ReminderController(ReminderService reminderService){
        this.reminderService = reminderService;
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

}
