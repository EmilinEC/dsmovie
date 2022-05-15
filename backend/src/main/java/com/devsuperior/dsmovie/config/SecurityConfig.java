package com.devsuperior.dsmovie.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration 
@EnableWebSecurity 
public  class  SecurityConfig  import  WebSecurityConfigurerAdapter {

	@ Ambiente privado autowired 
	env ;  

	@ Override 
	protected  void  configure ( HttpSecurity  http ) lança  Exception {
		 if ( Arrays . asList ( env . getActiveProfiles ()) contém ( "test" )) {
			 http . cabeçalhos (). frameOptions (). desabilitar ();
		}
		
		http . cora (). e (). csrf (). desabilitar ();
		http . SessionManagement (). sessionCreationPolicy ( SessionCreationPolicy . STATELESS );
		http . autorizeRequests (). qualquerRequest (). permitirTodos ();
	}

	@Bean 
	CorsConfigurationSource  corsConfigurationSource () {
		 configuração CorsConfiguration  = new CorsConfiguration (). applyPermitDefaultValues ();
		configuração . setAllowedMethods ( Arrays . asList ( "POST" , "GET" , "PUT" , "DELETE" , "OPTIONS" ));
		final UrlBasedCorsConfigurationSource fonte = new UrlBasedCorsConfigurationSource ();
		fonte .    registerCorsConfiguration ( "/**" , configuração );
		fonte de retorno  ;
	}
}
