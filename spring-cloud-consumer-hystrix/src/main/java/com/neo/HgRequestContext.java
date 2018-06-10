package com.neo;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

public class HgRequestContext {
	
//	private static final HystrixRequestVariableDefault<HgRequestContext> context = new HystrixRequestVariableDefault<HgRequestContext>();
	private static final ThreadLocal<HgRequestContext> context = new ThreadLocal<HgRequestContext>();
	
	private final User user;
	
	public HgRequestContext(User user) {
		this.user = user;
	}
	
	public static User currentUser() {
		HgRequestContext hgRequestContext = context.get();
		if (null == hgRequestContext) {
			return null;
		}
		return hgRequestContext.user;
	}
	
	public static void initRequestContext(User user) {
//		if(!HystrixRequestContext.isCurrentThreadInitialized()) {
//			HystrixRequestContext.initializeContext();
//		}
		context.set(new HgRequestContext(user));
	}
	
	public static void shutDownRequestContext() {
		if(HystrixRequestContext.isCurrentThreadInitialized()) {
			HystrixRequestContext.getContextForCurrentThread().shutdown();
		}
	}
	
	
}

