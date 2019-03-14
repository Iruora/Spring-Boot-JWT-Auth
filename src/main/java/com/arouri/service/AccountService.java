package com.arouri.service;

import com.arouri.dto.RegistrationForm;
import com.arouri.entities.AppRole;
import com.arouri.entities.AppUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidhal on 13/03/2019.
 */
@Service
@Transactional
public interface AccountService {
    AppUser saveUser(RegistrationForm data);
    AppRole saveRole(AppRole appRole);
    AppUser findUserByUsername(String username);
    void addRoleToUser(String username, String role);
}
