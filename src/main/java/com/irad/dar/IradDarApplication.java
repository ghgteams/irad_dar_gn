package com.irad.dar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EntityScan({"com.irad.dar"})
@EnableSwagger2
public class IradDarApplication {

	public static void main(String[] args) {
		SpringApplication.run(IradDarApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.irad.dar"))
				.build();
		
	}
	
	//RestTemplate Bean
		@Bean
		   public RestTemplate getRestTemplate() {
		      return new RestTemplate();
		   }
		
		
//		//Cors
//		@Bean
//		public WebMvcConfigurer corsConfigurer() {
//			return new WebMvcConfigurer() {
//				@Override
//				public void addCorsMappings(CorsRegistry registry) {
//					registry.addMapping("/**").allowedOrigins("http://10.163.30.214:8089/irad_dar");
//				}
//			};
//		}
//
//		
//
//	//Cors Orgin Purpose
//		@Bean
//	    CorsConfigurationSource corsConfigurationSource() {
//	        UrlBasedCorsConfigurationSource source = new
//	                UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//	        return source;
//	    }
//		
//		
//		//Cors Filter Problem purpose
//	    @Bean
//	    public CorsFilter corsFilter() {
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowCredentials(true);
//	        config.addAllowedOriginPattern("*");
//	        config.addAllowedHeader("*");
//	        config.addAllowedMethod("OPTIONS");
//	        config.addAllowedMethod("GET");
//	        config.addAllowedMethod("POST");
//	        config.addAllowedMethod("PUT");
//	        config.addAllowedMethod("DELETE");
//	        source.registerCorsConfiguration("/**", config);
//	        return new CorsFilter(source);
//	    }
}
