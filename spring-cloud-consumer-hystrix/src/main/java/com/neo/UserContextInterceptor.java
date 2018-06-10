package com.neo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * TSF Auth 服务端鉴权切点
 *
 * @author hongweizhu
 */
@Slf4j
public class UserContextInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2) throws Exception {
		// 提取客户端token
		User user = new User(HttpConvertUtil.httpRequestToMap(request));
		UserContextHolder.set(user);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2, ModelAndView arg3)
			throws Exception {
		// DOING NOTHING
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object arg2, Exception arg3)
			throws Exception {
		UserContextHolder.shutdown();
	}
}
