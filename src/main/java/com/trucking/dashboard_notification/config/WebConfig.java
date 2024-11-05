package com.trucking.dashboard_notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * Configuration class for setting up web-related configurations, including CORS settings.
 * Implements the WebMvcConfigurer interface to customize the MVC configuration.
 ***/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /***
     * Configures Cross-Origin Resource Sharing (CORS) settings for the application.
     * Allows frontend applications, like one running on localhost:3000, to access the backend API.
     *
     * @param registry the CorsRegistry to add mappings to
     ***/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applies CORS settings to all endpoints
                .allowedOrigins("http://localhost:3000") // Allows requests from the specified origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specifies allowed HTTP methods
                .allowedHeaders("*") // Permits all headers in the request
                .allowCredentials(true); // Allows cookies and credentials to be sent with requests
    }
}
