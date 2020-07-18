package com.mysalon.salonparent.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;

/**
 * 
 * @author Sumeet.pathak
 *
 */
public abstract class BaseDTO {

	@Override
	public String toString() {
		StandardToStringStyle style = new StandardToStringStyle();
		style.setFieldSeparator(", ");
		style.setUseClassName(false);
		style.setUseIdentityHashCode(false);
		return new ReflectionToStringBuilder(this, style).toString();
	}
}
