package com.init.app;



import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityEnablerConfiguration{

	// crear método para registrar el password encoder en la configuración de sprong security
	
	
	//@Bean 
//	public BCryptPasswordEncoder passwordEncoder() {
	//	return new BCryptPasswordEncoder();
//	}
	
	
//	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
	//	passwordEncoder encoder = passwordEncoder();
		
	//	UserBuilder users = User.withDefaultPasswordEncoder();
//	}
				
				
//	}
	
}
