package com.mysalon.salonparent.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysalon.salonparent.UserProfileService;
import com.mysalon.salonparent.dto.BaseJsonDTO;
import com.mysalon.salonparent.entity.UserProfileData;
import com.mysalon.salonparent.properties.PropertyReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sumeet.pathak
 *
 */
@Controller
public class UserProfileController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private PropertyReader propertyReader;

	@Autowired
	private UserProfileService userProfileService;


	@RequestMapping(value = "/insertUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseJsonDTO> insertUser(@RequestBody JsonObject userProfileDataJson) {

		userProfileService.insertUser(userProfileDataJson);
		BaseJsonDTO dto = new BaseJsonDTO();
		dto.addAnyProperty("status", "OK");
		//dto.addAnyProperty("springProperty", springProperty);
		//dto.addAnyProperty("dbProperty", dbConnection);
		
		return new ResponseEntity<BaseJsonDTO>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseJsonDTO> insertUser(@RequestParam String uid) {

		UserProfileData userProfileData=userProfileService.getUser(uid);
		BaseJsonDTO dto = new BaseJsonDTO();
		dto.addAnyProperty("user", new Gson().toJson(userProfileData));
		//dto.addAnyProperty("springProperty", springProperty);
		//dto.addAnyProperty("dbProperty", dbConnection);

		return new ResponseEntity<BaseJsonDTO>(dto, HttpStatus.OK);
	}

}
