//package com.healthcare.fitness.config;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfiguration
//{
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	public void configureGlobal(@Lazy AuthenticationManagerBuilder auth) 
//			throws Exception
//	{
//	auth.inMemoryAuthentication().withUser("coach_admin").password(passwordEncoder
//			.encode("poiuytr")).authorities("ROLE_ADMIN");
//
//	}
//	
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated());
//		
//		http.sessionManagement((session) -> session
//	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	        );
//
//		
//	return http.build();
//	}
//  
//	
//}
//
//
//
//
