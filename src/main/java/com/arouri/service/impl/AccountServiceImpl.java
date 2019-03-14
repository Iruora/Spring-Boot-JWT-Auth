package com.arouri.service.impl;

import com.arouri.dao.AppRoleRepository;
import com.arouri.dao.AppUserRepository;
import com.arouri.dto.RegistrationForm;
import com.arouri.entities.AppRole;
import com.arouri.entities.AppUser;
import com.arouri.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Nidhal on 13/03/2019.
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AppUserRepository userRepository;
    @Autowired
    AppRoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    // =======================================
    @Override
    public AppUser saveUser(RegistrationForm data) {
        String username = data.getUsername();
        AppUser user = this.findUserByUsername(username);
        if (user != null) throw new RuntimeException("This user already exists");
        String password = data.getPassword();
        String confirmPassword = data.getConfirmPassword();

        if (! password.equals(confirmPassword))
            throw new RuntimeException("Confirm password exception");
        AppUser u = new AppUser();
        u.setUsername(username);
        u.setPassword(password);
        // -------------------------------
        u.setPassword(
                bCryptPasswordEncoder.encode(
                        u.getPassword()
                )
        );
        this.addRoleToUser(username, "USER");
        AppUser ur = userRepository.save(u);
        return ur;
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        return roleRepository.save(appRole);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findAppUserByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepository.findAppUserByUsername(username);
        AppRole role = roleRepository.findByRole(roleName);
        user.getRoles().add(role);
    }
//    @Bean
//    private BCryptPasswordEncoder getBCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
