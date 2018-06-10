package com.neo;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.util.Map;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * TSF Auth客户端(Feign)Token切点
 */
@Slf4j
public class FeignUserContextInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		System.out.println(attributes.getRequest().getHeader("x-customs-user"));
		Principal principal = attributes.getRequest().getUserPrincipal();
		
		User user = UserContextHolder.currentUser();
		Map<String, String> headers = user.toHttpHeaders();
		for (Map.Entry<String, String> header : headers.entrySet()) {
			template.header(header.getKey(), header.getValue());
		}
	}

}
