package com.arouri.dao;

import com.arouri.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nidhal on 13/03/2019.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findAppUserByUsername(String username);
}
