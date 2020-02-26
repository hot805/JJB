package com.jjb.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MimeMediaUtil {
	
	private static Map<String, MediaType> mediaMap;
	
	static {
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);		
	}
	
	public static MediaType getMediaType(String type) {
		return mediaMap.get(type.toUpperCase());//대문자로 변환해서 비교하기위함 -> 위의 있는 이미지파일 종류들이 아니면 null값이 반환
	}

}
