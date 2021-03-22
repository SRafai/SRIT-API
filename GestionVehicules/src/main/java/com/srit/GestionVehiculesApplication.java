package com.srit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.srit.entities.AppUser;
import com.srit.entities.Role;
import com.srit.imetier.GestionVehiculeMetier;

@SpringBootApplication
//@RestController
public class GestionVehiculesApplication implements CommandLineRunner{

	@Autowired
	private GestionVehiculeMetier gvMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionVehiculesApplication.class, args);
	}
	
	/*@Bean
	public BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}*/

	@Override
	public void run(String... args) throws Exception {
	
		/*Role admin = gvMetier.addRole(new Role("admin"));
		gvMetier.addUser(new AppUser("Taha","Tajin","admin@gmail.com","1234",admin));*/
	}

//	@RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
//	public Article updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
//		return gvMetier.updateArticle(id, article);
//	}
}
