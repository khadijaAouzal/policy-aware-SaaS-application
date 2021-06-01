package org.sid.web;

import java.util.ArrayList;
import java.util.List; import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.sid.repo.AppUserRepository;
import org.sid.repo.TenantRepository;
import org.sid.service.AccountService;
import org.sid.entities.AppUser;
import org.sid.entities.Tenant;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;
  
  @RestController
  @RequestMapping(value = "/{id_tenant}" ) 

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  
  public class UserRestService {
  
	  @Autowired 
	  private AppUserRepository userRepository;
	  @Autowired 
	  private TenantRepository tenantRepository;
	  @Autowired
	  AccountService accountService;
  
		/*
		 * @RequestMapping(value = "/users", method = RequestMethod.GET ) public
		 * List<AppUser> getUsers(@PathVariable Long id_tenant){ return
		 * userRepository.findByTenant(tenantRepository.findById(id_tenant)); }
		 */
  
  
	
	/*
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.GET) public
	 * Optional<AppUser> getUser(@PathVariable Long id_tenant,@PathVariable Long
	 * id){ return userRepository.findByIdAndTenantId(id, id_tenant); }
	 */
	  
	  @RequestMapping(value = "/users", method = RequestMethod.POST) 
	  public AppUser saveUser(HttpServletRequest request,@PathVariable String id_tenant)
	  {
	   
		  AppUser appUser = new AppUser(null, request.getParameter("username"),  request.getParameter("password"), tenantRepository.findByUsername(id_tenant), new ArrayList<>());
		  
		  appUser = accountService.addNewUser(appUser); 
		  
			  accountService.addRoleToUser(appUser.getUsername(), "USER");
			  return appUser;
	  }
	   
	/*
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE) public
	 * boolean deleteUser(@PathVariable Long id){ userRepository.deleteById(id);
	 * return true; }
	 * 
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT) public
	 * AppUser editeUser(@PathVariable Long id , @RequestBody AppUser c){
	 * c.setId(id); return userRepository.save(c); }
	 */
 }
 
