package org.sid.repo;

import java.util.List;

import org.sid.entities.AppUser;
import org.sid.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentRepository extends JpaRepository<Document, Long>{

	List<Document> findByAppUser(AppUser appUser);
	Document findByIdAndAppUser(Long id,AppUser appUser);
}
