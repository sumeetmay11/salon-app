package com.mysalon.salonparent.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mysalon.salonparent.utils.ConversionUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author Sumeet.pathak
 *
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseJsonDTO extends BaseDTO {

	@JsonIgnore
	protected Map<String, Object> anyProperties = new HashMap<>();
	
	@Override
	public String toString() {
		return ConversionUtils.marshalJson(this);
	}
	
	public void addAnyProperty(String key, Object object) {
		this.anyProperties.put(key, object);
	}
	
	@JsonAnyGetter
    public Map<String, Object> getAnyProperties() {
		if (this.anyProperties.isEmpty()) {
			return null;
		}
        return this.anyProperties;
    }

    @JsonAnySetter
    public void setAnyProperties(String name, Object value) {
        this.anyProperties.put(name, value);
    }
}
