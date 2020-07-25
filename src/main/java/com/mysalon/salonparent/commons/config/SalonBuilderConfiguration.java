package com.mysalon.salonparent.commons.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.mysalon")
@PropertySource(value = {"classpath:application.properties","classpath:properties/${env}/application.properties",
		"classpath:properties/${env}/interface.properties","classpath:log4j.properties",
						"classpath:properties/${env}/database.properties" })
public class SalonBuilderConfiguration {

}