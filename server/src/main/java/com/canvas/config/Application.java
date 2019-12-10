package com.canvas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.canvas.config.model.FileStorageProperties;
import com.canvas.config.services.StorageService;

import java.util.Collections;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//
//	 // Fix the CORS errors
//	 @Bean
//	 public FilterRegistrationBean simpleCorsFilter() {  
//		 UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
//		 CorsConfiguration config = new CorsConfiguration();  
//		 config.setAllowCredentials(true); 
//		 // *** URL below needs to match the Vue client URL and port ***
//		 config.setAllowedOrigins(Collections.singletonList("http://localhost:8080")); 
//		 config.setAllowedMethods(Collections.singletonList("*"));  
//		 config.setAllowedHeaders(Collections.singletonList("*"));  
//		 source.registerCorsConfiguration("/**", config);  
//		 FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
//		 bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
//		 return bean;  
//	 }
	 
	  @Bean
	  CommandLineRunner init(StorageService storageService) {
	    return (args) -> {
	      storageService.deleteAll();
	      storageService.init();
	    };
	  }
	
}