package com.example.adopciones;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;


@SpringBootApplication
public class AdopcionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopcionesApplication.class, args);
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "unmsm234",
				"api_key", "872387794637319",
				"api_secret", "xF-9FwzZamaUbqtmWNbBcweiJoU",
				"secure", true));
		
	}
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(false);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		//corsConfiguration.setAllowedOrigins(Arrays.asList("http://192.168.110.36:8080/emp-solidarias-front"));
		
		//corsConfiguration.setAllowedOrigins(Arrays.asList("https://empresas-solidarias-dev.herokuapp.com/"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
