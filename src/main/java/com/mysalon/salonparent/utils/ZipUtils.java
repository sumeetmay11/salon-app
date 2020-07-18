package com.mysalon.salonparent.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ZipUtils {

	public static final String encoding = "UTF-8";

	public static String compress(String data) {
		String compressedData = null;
		try {
			byte[] output = compressByteArray(data.getBytes(encoding));
			compressedData = Base64.getEncoder().encodeToString(output);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return compressedData;
	}

	public static String deCompress(String compressedData) {
		String data = null;
		try {
			byte[] output = decompressByteArray(Base64.getDecoder().decode(compressedData));
			data = new String(output);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return data;
	}

	public static byte[] compressByteArray(byte[] data) throws IOException {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		deflater.finish();
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer); // returns the generated
													// code... index
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();

		deflater.end();
		return output;
	}

	public static byte[] decompressByteArray(byte[] data) throws IOException, DataFormatException {
		Inflater inflater = new Inflater();
		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();

		inflater.end();
		return output;
	}

	public static String getFastZipped(String str){
		if(ConversionUtils.isNullOrEmpty(str)){
			return str;
		}
		byte[] compressedBytes = ZipUtils.fastCompression(str);
		byte[] encoded = Base64.getEncoder().encode(compressedBytes);
		return new String(encoded);
	}

	public static String getFastUnzipped(String compressedString){
		if(ConversionUtils.isNullOrEmpty(compressedString)){
			return compressedString;
		}
		byte[] decodedBytes = Base64.getDecoder().decode(compressedString.getBytes());
		return ZipUtils.fastDecompress(decodedBytes);
	}

	public static byte[] fastCompression( String str){
		if (str == null || str.length() == 0) {
			return null;
		}
		byte[] data = str.getBytes();
		Deflater deflater = new Deflater();
		deflater.setLevel(Deflater.BEST_SPEED);
		deflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		deflater.finish();
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer); // returns the generated code... index
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		}catch (Exception e){

		}
		byte[] output = outputStream.toByteArray();
		return output;
	}

	public static String fastDecompress(byte[] data)  {
		try {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
			byte[] output = outputStream.toByteArray();
			return new String(output);
		} catch (Exception e) {
			return null;
		}
	}
}
