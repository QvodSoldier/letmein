package com.neo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;


/**
 * 用户上下文
 * 
 * @author hongweizhu
 *
 */
@Data
public class User implements Serializable {

	public final static String CONTEXT_KEY_USERID = "x-customs-user";

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2824168312877999405L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 默认构造函数
	 */
	public User() {

	}

	public User(Map<String, String> headers) {
		fromHttpHeaders(headers);
	}

	/**
	 * 将user对象转换成为http对象头
	 * @return http头键值对
	 */
	public Map<String, String> toHttpHeaders() {
		if (StringUtils.isBlank(userId)) {
		}
		Map<String, String> headers = new HashMap<>();
		headers.put(CONTEXT_KEY_USERID, StringUtils.defaultString(userId));
		return headers;
	}

	private void fromHttpHeaders(Map<String, String> headers) {
		String value = headers.get(CONTEXT_KEY_USERID);
		if (StringUtils.isBlank(value)) {
		}
		userId = value;
	}

}
