package com.mysalon.salonparent.commons.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.mysalon")
@PropertySource(value = { "classpath:properties/${environment}/application.properties",
		"classpath:properties/${environment}/interface.properties","classpath:log4j.properties",
						"classpath:properties/${environment}/database.properties" })
public class SalonBuilderConfiguration {

}