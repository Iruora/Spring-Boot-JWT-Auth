package com.arouri.controllers;

import com.arouri.dto.RegistrationForm;
import com.arouri.entities.AppUser;
import com.arouri.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nidhal on 13/03/2019.
 */
@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    // ==================================
    @PostMapping("/users")
    public AppUser signUp(@RequestBody RegistrationForm data) {
        return accountService.saveUser(data);
    }
}
