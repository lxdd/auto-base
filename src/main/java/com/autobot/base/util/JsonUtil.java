package com.autobot.base.util;

import java.text.SimpleDateFormat;
import java.util.Optional;

//import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * (json对象辅助类)
 * 
 * @author (li_xiaodong)
 * @date 2015年10月14日 下午7:50:03
 */
// @Component
public class JsonUtil {
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final ObjectMapper MAPPER;

	static {
		// readMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		MAPPER = new ObjectMapper();
		MAPPER.setDateFormat(dateFormat);
		MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
	}

	/**
	 * (json转为Object)
	 * 
	 * @param json
	 * @param toClass
	 * @return
	 */
	@Deprecated
	public static <T> T parseToObject(String json, Class<T> toClass) {
		try {
			return (T) MAPPER.readValue(json, toClass);
		} catch (Exception e) {
			throw new RuntimeException("将json字符转换为对象时失败!");
		}
	}

	/**
	 * (Object转为json)
	 * 
	 * @param obj
	 * @return
	 */
	@Deprecated
	public static String parseToJson(Object obj) {
		if (obj == null) {
			return null;
		}

		try {
			return MAPPER.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("转换json字符失败!");
		}
	}

	/**
	 * (json转为Object) --- java 8
	 * 
	 * @param jsonOpt
	 * @param toClassOpt
	 * @return
	 */
	public static <T> Optional<T> parseToObjectOpt(Optional<String> jsonOpt, Optional<Class<T>> toClassOpt) {

		// 入参为空时，直接构建空的optional
		if (!jsonOpt.isPresent() || !toClassOpt.isPresent()) {
			return Optional.empty();
		}

		try {
			return Optional.ofNullable((T) MAPPER.readValue(jsonOpt.get(), toClassOpt.get()));
		} catch (Exception e) {
			throw new RuntimeException("将json字符转换为对象时异常，请检查json串!");
		}
	}

	/**
	 * (Object转为json) - java 8
	 * 
	 * @param objOpt
	 * @return
	 */
	public static Optional<String> parseToJsonOpt(Optional<Object> objOpt) {

		if (!objOpt.isPresent()) {
			return Optional.empty();
		}

		try {
			return Optional.ofNullable(MAPPER.writeValueAsString(objOpt.get()));
		} catch (Exception e) {
			throw new RuntimeException("将对象转换为json字符时异常!，请检查对象");
		}
	}

//	public static void main(String[] str) {
//
//		Optional<String> stre = parseToJsonOpt(Optional.ofNullable(new Result<>()));
//		if (stre.isPresent()) {
//			System.out.println(stre.get());
//		}
//
//	}

}
