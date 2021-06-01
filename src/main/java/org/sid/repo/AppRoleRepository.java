package org.sid.repo;


import org.sid.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
         AppRole findByRoleName(String roleName);
}

