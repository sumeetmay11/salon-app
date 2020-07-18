package com.mysalon.salonparent.properties;

import java.util.List;

/**
 * Properties to rest of the world are exposed by this simple interface that
 * returns property for a key
 * 
 * @author mishrasha
 *
 */
public interface PropertyReader {
	
	public String getProperty(String key);
	
	public String getNonNullProperty(String key);

	public Integer getPropertyAsInt(String key);

	public Long getPropertyAsLong(String key);

	public Double getPropertyAsDouble(String key);

	public Boolean getPropertyAsBoolean(String key);

	public Byte getPropertyAsByte(String key);

	public String[] getPropertyAsStringArray(String key);

	Boolean[] getPropertyAsBooleanArray(String key);

	Integer[] getPropertyAsIntArray(String key);

	public String getProperty(String key, String defaultValue);

	public List<String> getPropertyAsList(String key);
}
