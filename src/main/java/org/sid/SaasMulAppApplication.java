package org.sid;


import java.util.ArrayList;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Document;
import org.sid.entities.Tenant;
import org.sid.repo.DocumentRepository;
import org.sid.repo.TenantRepository;
import org.sid.service.AccountService;
import org.sid.service.CurrentTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication

public class SaasMulAppApplication {
	 @Autowired
	  private CurrentTenant cu;
	
	public static void main(String[] args) {
		SpringApplication.run(SaasMulAppApplication.class, args);
	}
	
	 @Bean PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();
	  }
	 
	@Bean
	CommandLineRunner start(AccountService accountService, TenantRepository tenantRepository, DocumentRepository documentRepository){
	return args -> {
		  cu.currentTenant();

	Tenant tenant1 = tenantRepository.save(new Tenant(null, "1", "1"));	
	Tenant tenant2 = tenantRepository.save(new Tenant(null, "2", "2"));
	
	accountService.addNewRole(new AppRole(null,"USER"));
	accountService.addNewRole(new AppRole(null,"ADMIN"));
	
	AppUser appUser1 = accountService.addNewUser(new AppUser(null,"user1","1234",tenant1,new ArrayList<>()));
	AppUser appUser2 = accountService.addNewUser(new AppUser(null,"user2","1234",tenant1,new ArrayList<>()));
	AppUser appUser3 = accountService.addNewUser(new AppUser(null,"user3","1234",tenant2,new ArrayList<>()));
	AppUser appUser4 = accountService.addNewUser(new AppUser(null,"user4","1234",tenant2,new ArrayList<>()));
	
	accountService.addRoleToUser("user1","USER");
	accountService.addRoleToUser("user2","USER");
	accountService.addRoleToUser("user3","USER");
	accountService.addRoleToUser("user4","USER");
	
	documentRepository.save(new Document(null,"Doc 1",appUser1));
	documentRepository.save(new Document(null,"Doc 2",appUser1));
	documentRepository.save(new Document(null,"Doc 3",appUser1));
	documentRepository.save(new Document(null,"Doc 4",appUser1));
	documentRepository.save(new Document(null,"Doc 5",appUser1));
	documentRepository.save(new Document(null,"Doc 6",appUser1));
	documentRepository.save(new Document(null,"Doc 7",appUser1));
	documentRepository.save(new Document(null,"Doc 8",appUser3));
	documentRepository.save(new Document(null,"Doc 9",appUser3));
	documentRepository.save(new Document(null,"Doc 10",appUser3));
	documentRepository.save(new Document(null,"Doc 11",appUser3));
	documentRepository.save(new Document(null,"Doc 12",appUser3));
	
	
	};
	}
}
