package com.arouri.dao;

import com.arouri.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nidhal on 13/03/2019.
 */
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    public AppRole findByRole(String role);
}
