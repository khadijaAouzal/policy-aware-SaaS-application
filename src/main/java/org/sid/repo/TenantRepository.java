package org.sid.repo;

import java.util.Optional;

import org.sid.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
	
	Tenant findByUsername(String username);

}
