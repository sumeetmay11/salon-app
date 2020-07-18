package com.mysalon.salonparent.commons.config;

import com.mysalon.salonparent.impl.PropertyLoaderImpl;
import com.mysalon.salonparent.properties.PropertyLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sumeet.pathak
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.mysalon.salonparent.repository")
public class CommonConfig implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Autowired
    public Environment ENV;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}
/*
	@Bean("restClient")
	public RestClient getRestClient() {
		return new RestClient(5000, 30000);
	}*/

/*	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp1.in");
		mailSender.setPort(25);
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.timeout", 10000);
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

	@Bean
	public VelocityEngine velocityEngine() throws Exception {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.setProperty("input.encoding", "UTF-8");
		velocityEngine.setProperty("output.encoding", "UTF-8");
		velocityEngine.init();
		return velocityEngine;
	}*/
	
	@Bean
	public PropertyLoader getPropertyLoader() {
		String propertyFolder = "properties/" + this.ENV.getProperty("environment");
		List<String> propertiesFile = new ArrayList<>();
		propertiesFile.add(propertyFolder + "/application.properties");
		propertiesFile.add(propertyFolder + "/database.properties");
		propertiesFile.add(propertyFolder + "/interface.properties");
		PropertyLoader propertyLoader = new PropertyLoaderImpl(propertiesFile);
		return propertyLoader;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName, Class<T> type) {
		if (!applicationContext.containsBean(beanName)) {
			return null;
		}
		return (T) applicationContext.getBean(beanName);
	}

	public static <T> T getBean(Class<T> type) {

		if (applicationContext == null) {
			throw new ApplicationContextException("Application context is null");
		}

		return applicationContext.getBean(type);
	}
}
