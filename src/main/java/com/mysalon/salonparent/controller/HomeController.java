package com.mysalon.salonparent.controller;

import com.mysalon.salonparent.dto.BaseJsonDTO;
import com.mysalon.salonparent.properties.PropertyReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sumeet.pathak
 *
 */
@Controller
public class HomeController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private PropertyReader propertyReader;

	@Value("${test.property}")
	private String springProperty;

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseJsonDTO> healthCheck() {
		
		logger.info("Doing health check, logger OK.");
		String propertiesCheck = this.propertyReader.getProperty("test.property");
		//String dbConnection = this.propertyReader.getProperty("test.db.property");
		
		BaseJsonDTO dto = new BaseJsonDTO();
		dto.addAnyProperty("status", "OK");
		dto.addAnyProperty("customProperty", propertiesCheck);
		dto.addAnyProperty("springProperty", springProperty);
		//dto.addAnyProperty("dbProperty", dbConnection);
		
		return new ResponseEntity<BaseJsonDTO>(dto, HttpStatus.OK);
	}
}
