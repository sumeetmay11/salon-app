package com.mysalon.salonparent.impl;

import com.mysalon.salonparent.properties.PropertyLoader;
import com.mysalon.salonparent.properties.PropertyReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * A decorator around simple proprty manager that serves parsed data out ouf string
 * properties
 * @author mishrasha
 *
 */

@Component
public class PropertyReaderImpl implements PropertyReader {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PropertyLoader propertyLoader;

	@Override
	public String getProperty(String key) {
		return this.propertyLoader.getProperty(key);
	}

    @Override
    public Integer getPropertyAsInt(String key) {
        Integer retValue;
        try {
            retValue = Integer.parseInt(this.propertyLoader.getProperty(key));
        } catch (NumberFormatException nfExp) {
        	logger.error("integer property not found - " + key);
            return 0;
        }
        return retValue;
    }

    @Override
    public Long getPropertyAsLong(String key) {
        Long retValue;
        try {
            retValue = Long.parseLong(this.propertyLoader.getProperty(key));
        } catch (NumberFormatException nfExp) {
            return 0L;
        }
        return retValue;
    }


    @Override
    public Double getPropertyAsDouble(String key) {
        Double retValue;
        try {
			String property = this.propertyLoader.getProperty(key);
			if(property==null){
				return 0D;
			}
            retValue = Double.parseDouble(property);
        } catch (NumberFormatException nfExp) {
        	logger.error("double property not found - " + key);
            return 0D;
        }
        return retValue;
    }

    @Override
    public Boolean getPropertyAsBoolean(String key) {
    	String objProperty = this.propertyLoader.getProperty(key);
    	if(objProperty!=null)
    		return new Boolean(objProperty);
    	else
    		return false;
    }

    @Override
    public Byte getPropertyAsByte(String key) {
        Byte retValue;
        try {
            retValue = Byte.parseByte(this.propertyLoader.getProperty(key));
        } catch (NumberFormatException nfExp) {
        	logger.error("double property not found - " + key);
            return null;
        }
        return retValue;
    }

	@Override
	public String[] getPropertyAsStringArray(String key) {
		String stringProp = this.propertyLoader.getProperty(key);
		if(stringProp == null){
			return null;
		}
		String[] strPieces = stringProp.split(",");
		return strPieces;
	}

	@Override
	public Boolean[] getPropertyAsBooleanArray(String key) {
		String stringProp = this.propertyLoader.getProperty(key);
		String[] strPieces = stringProp.split(",");
		Boolean [] boolPieces = new Boolean[strPieces.length];
		for (int i = 0; i < strPieces.length; i++) {
			boolPieces[i] = Boolean.parseBoolean(strPieces[i]);
		}
		return boolPieces;
	}

	@Override
	public Integer[] getPropertyAsIntArray(String key) {
		String stringProp = this.propertyLoader.getProperty(key);
		String[] strPieces = stringProp.split(",");
		Integer [] intPieces = new Integer[strPieces.length];
		for (int i = 0; i < strPieces.length; i++) {
			intPieces[i] = Integer.parseInt(strPieces[i]);
		}
		return intPieces;
	}

	@Override
	public String getNonNullProperty(String key) {
		if(key==null || getProperty(key)==null)
			return "";
		return getProperty(key);
	}

	@Override
	public String getProperty(String key, String defaultValue) {
		String retValue = getNonNullProperty(key);
		if(retValue.isEmpty())
			return defaultValue;
		return retValue;
	}

	@Override
	public List<String> getPropertyAsList(String key) {
		List<String> list=new ArrayList<String>();
		String stringProp = this.propertyLoader.getProperty(key);
		if(stringProp == null){
			return null;
		}
		String[] strPieces = stringProp.split(",");
		for(int i=0; i < strPieces.length;i++){
			list.add(strPieces[i]);
		}

		return list;
	}
	
	public void setPropertyManagerSimple(PropertyLoader propertyManagerSimple) {
		this.propertyLoader = propertyManagerSimple;
	}
}
