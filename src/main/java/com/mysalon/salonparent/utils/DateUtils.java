package com.mysalon.salonparent.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static Logger logger = Logger.getLogger(DateUtils.class);

	public static String formatDate(Date srcDate, String format) {
		String formattedDate = "";
		try {
			formattedDate = new SimpleDateFormat(format).format(srcDate);
		} catch (Exception e) {
			logger.error("Exception occured while formatting " + srcDate + " to " + format + " " + e.getMessage());
		}
		return formattedDate;
	}

	public static Date addTenure(Date startDate, String tenure) {
		if (tenure.equalsIgnoreCase("yearly")) {
			return addYear(startDate, 1);
		} else if (tenure.equalsIgnoreCase("quaterly")) {
			return addMonth(startDate, 3);
		} else {
			return addMonth(startDate, 1);
		}
	}

	public static Date addYear(Date startDate, int noOfYears) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			c.add(Calendar.YEAR, noOfYears);
			return c.getTime();
		} catch (Exception e) {
			logger.error("Exception occured while adding noOfYears " + noOfYears + " to " + startDate + " "
					+ e.getMessage());
		}

		return startDate;
	}

	public static Date addMonth(Date startDate, int noOfmonths) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			c.add(Calendar.MONTH, noOfmonths);
			return c.getTime();
		} catch (Exception e) {
			logger.error("Exception occured while adding noOfmonths " + noOfmonths + " to " + startDate + " "
					+ e.getMessage());
		}

		return startDate;
	}
	
	public static Date addDays(Date startDate, int noOfDays) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			c.add(Calendar.DAY_OF_MONTH, noOfDays);
			return c.getTime();
		} catch (Exception e) {
			logger.error("Exception occured while adding noOfDays " + noOfDays + " to " + startDate + " "
					+ e.getMessage());
		}

		return startDate;
	}
}
