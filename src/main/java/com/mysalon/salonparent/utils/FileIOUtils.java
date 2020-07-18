package com.mysalon.salonparent.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.net.URL;

public class FileIOUtils {


	private static Logger logger = Logger.getLogger(FileIOUtils.class);

	public static String readFileFromFileSystem(String filepath) {
		try {
			File file = new File(filepath);
			return FileUtils.readFileToString(file);
		} catch (Exception e) {
			logger.error("Exception occured while readFileFromFileSystem, message :" + e.getMessage());
		}

		return null;
	}

	public static String readFileFromClasspath(String filepath) {
		try {
			ClassLoader classLoader = FileIOUtils.class.getClassLoader();
			URL resource = classLoader.getResource(filepath);
			File file = new File(resource.getFile());
			return FileUtils.readFileToString(file);
		} catch (Exception e) {
			logger.error("Exception occured while readFileFromClasspath, message :" + e.getMessage());
		}

		return null;
	}
}
