package com.trucking.dashboard_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * Main application class for the Dashboard Notification Service.
 * Serves as the entry point for the Spring Boot application.
 ***/
@SpringBootApplication
public class DashboardNotificationApplication {

	/***
	 * The main method that bootstraps the Spring Boot application.
	 *
	 * @param args command-line arguments (if any)
	 ***/
	public static void main(String[] args) {
		SpringApplication.run(DashboardNotificationApplication.class, args);
	}
}
