package com.mysalon.salonparent.impl;

import com.mysalon.salonparent.properties.PropertyLoader;
import com.mysalon.salonparent.utils.FileIOUtils;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 
 * @author sumeet.pathak
 *
 */
public class PropertyLoaderImpl implements PropertyLoader {

	private Logger logger = Logger.getLogger(getClass());

	protected Properties properties = new Properties();
	
	public PropertyLoaderImpl(String propertiesFile) {
		this(Arrays.asList(new String[] {propertiesFile}));
	}


	public PropertyLoaderImpl(List<String> propertiesFile) {
		logger.info("Property manager getting initializing. Property files - " + propertiesFile);
		
		for (String propertyFileName : propertiesFile) {
			loadProperties(propertyFileName);
		}
	}


	@Override
	public String getProperty(String key) {
		return properties != null ? properties.getProperty(key) : null;
	}

	private void loadProperties(String propertyFileName) {
        try {
        	String filecontent = FileIOUtils.readFileFromClasspath(propertyFileName);
        	Properties propertiesTemp = new Properties();
            propertiesTemp.load(new ByteArrayInputStream(filecontent.getBytes()));
            properties.putAll(propertiesTemp);
        } catch (FileNotFoundException e) {
            logger.error("Property file could not be found : ", e);
        } catch (IOException e) {
        	logger.error("Error in reading property file : ", e);
		} catch (Exception e) {
        	logger.error("Unknown Error in reading property file : ", e);
		}
	}

}
