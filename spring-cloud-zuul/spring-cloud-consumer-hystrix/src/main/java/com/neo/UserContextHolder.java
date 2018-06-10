package com.neo;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * 用户上下文
 * 
 * @author hongweizhu
 */
public class UserContextHolder {

	public static User currentUser() {
		return HgRequestContext.currentUser();
	}

	public static void set(User user) {
		HgRequestContext.initRequestContext(user);
	}

	public static void shutdown() {
		HgRequestContext.shutDownRequestContext();
	}
}
