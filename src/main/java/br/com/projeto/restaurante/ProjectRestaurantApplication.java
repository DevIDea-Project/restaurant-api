package br.com.projeto.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableSpringDataWebSupport
@EnableCaching
public class ProjectRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectRestaurantApplication.class, args);
	}

}
