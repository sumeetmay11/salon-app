package com.mysalon.salonparent.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

import java.util.Map;

public class JsonUtil {
	private static Logger logger = Logger.getLogger(JsonUtil.class);

	public static void putSafeJsonElement(JsonObject jsonObject, String jsonObjectKey, String key, String value) {
		if(jsonObject == null || jsonObject.get(jsonObjectKey)== null){
			return;
		}
		jsonObject.get(jsonObjectKey).getAsJsonObject().addProperty(key, value);
	}


	public static void putSafeJsonString(JsonObject jsonObject, String key, String value) {

		if(jsonObject == null){
			return;
		}
		jsonObject.addProperty(key, value);
	}


	public static void putSafeJsonElements(JsonObject jsonObject, String jsonObjectKey, Map<String, String> map) {
		if(jsonObject == null || jsonObject.get(jsonObjectKey)==null){
			return;
		}
		for(String key : map.keySet()){
			putSafeJsonElement(jsonObject, jsonObjectKey, key, map.get(key));
		}
	}


	public static JsonArray getSafeJsonArray(JsonObject jsonObject, String key) {

		if(jsonObject == null || jsonObject.get(key)==null){
			return new JsonArray();
		}

		return jsonObject.get(key).getAsJsonArray();
	}

	public static String getSafeString(JsonObject jsonObject, String key) {

		if(jsonObject == null || jsonObject.get(key) == null){
			return "";
		}

		return jsonObject.get(key).getAsString();

	}

	public static JsonObject getSafeObject(JsonObject jsonObject, String key) {
		if(jsonObject == null || jsonObject.get(key) == null){
			return new JsonObject();
		}
		return jsonObject.get(key).getAsJsonObject();
	}


	public static double getSafeDouble(JsonObject jsonObject, String key) {
		if(jsonObject == null || jsonObject.get(key)==null){
			return 0d;
		}
		try{
			return jsonObject.get(key).getAsDouble();
		}catch (Exception e){
			logger.error("Invalid Json Data");
			return 0d;
		}
	}


	public static long getSafeLong(JsonObject jsonObject, String member) {
		if (jsonObject.has(member)) {
			return jsonObject.get(member).getAsLong();
		} else {
			return 0;
		}
	}


	public static int getSafeInt(JsonObject jsonObject, String key) {

		if(jsonObject == null || jsonObject.get(key)==null){
			return 0;
		}
		try{
			return (int)jsonObject.get(key).getAsDouble();
		}catch (Exception e){
			logger.error("Invalid Json Data");
			return 0;
		}

	}

	public static JsonObject getSafeObject(JsonObject jsonObject, String key, boolean returnNull){
		if(ConversionUtils.isNullOrEmpty(jsonObject) || !jsonObject.has(key) || jsonObject.get(key).isJsonNull()){
			return returnNull ? null : new JsonObject();
		}
		return jsonObject.get(key).getAsJsonObject();
	}

	public static boolean getSafeBoolean(JsonObject jsonObject, String key) {

		if(jsonObject == null || jsonObject.get(key)==null){
			return false;
		}

		return jsonObject.get(key).getAsBoolean();
	}

}
