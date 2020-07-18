package com.mysalon.salonparent.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Sumeet.pathak
 *
 */
public class ConversionUtils {

	private static Logger logger = Logger.getLogger(ConversionUtils.class);

	private static ObjectMapper mapper = new ObjectMapper();

	private static Gson gson = new Gson();

	public static <T> T unmarshalJson(String json, Class<T> type) {
		if (StringUtils.isNotBlank(json)) {
			try {
				return mapper.readValue(json, type);
			} catch (Exception e) {
				logger.error("Exception occured while unmarshalling json object." + e.getMessage());
			}
		}
		return null;
	}

	public static <T> String marshalJson(T object) {
		if (object != null) {
			try {
				return mapper.writeValueAsString(object);
			} catch (Exception e) {
				logger.error("Exception occured while marshalling json object." + e.getMessage());
			}
		}
		return null;
	}

	public static <T> String objectToString(T object) {
		try {
			return gson.toJson(object);
		} catch (Exception e) {
			logger.error("Exception occured while converting objectToString." + e.getMessage());
		}
		return null;
	}

	public static JsonObject stringToJsonObject(String jsonString) {
		try {
			return JsonParser.parseString(jsonString).getAsJsonObject();
		} catch (Exception e) {
			logger.error("Exception occured while converting stringToJsoObject." + e.getMessage());
		}
		return null;
	}

	public static JsonArray stringToJsonArray(String jsonString) {
		try {
			return JsonParser.parseString(jsonString).getAsJsonArray();
		} catch (Exception e) {
			logger.error("Exception occured while converting stringToJsoObject." + e.getMessage());
		}
		return null;
	}

	public static <T> JsonObject objectToJsonObject(T object) {
		try {
			return gson.toJsonTree(object).getAsJsonObject();
		} catch (Exception e) {
			logger.error("Exception occured while converting stringToJsoObject." + e.getMessage());
		}
		return null;
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static Gson getGson() {
		return gson;
	}

	public static <T> Boolean isNullOrEmpty(List<T> list) {
		if (list != null && list.size() > 0)
			return false;
		else
			return true;
	}

	public static <T> Boolean isNullOrEmpty(T[] array) {
		if (array != null && array.length > 0)
			return false;
		else
			return true;
	}

	public static <T> boolean isNullOrEmpty(Map<String, T> map) {
		if (map != null && map.size() > 0)
			return false;
		return true;
	}

	public static String convertMapToString(Map<String, ?> map) {
		return map.keySet().stream().map(key -> key + "=" + map.get(key)).collect(Collectors.joining(", ", "{", "}"));
	}

/*	public static String messageFormatString(String templateString, Map<String, String> valuesMap) {
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		return sub.replace(templateString);
	}

	public static String messageFormatString(String templateString, String key, String value) {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put(key, value);
		return messageFormatString(templateString, valuesMap);
	}*/

	public static boolean isNullOrEmpty(JsonObject json) {
		return json == null || json.isJsonNull() || json.entrySet().size() == 0;
	}

	public static boolean isNullOrEmpty(String str) {
		return str==null || str.isEmpty();
	}
}
