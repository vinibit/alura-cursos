package br.com.caelum.livraria.log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
public class LogInterceptor {
	
	@AroundInvoke
	public Object doLog(InvocationContext context) throws Exception {
		long begin = System.currentTimeMillis();
		
		Object result = context.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		System.out.println("[LOG] Duration for " + context.getMethod().getName() + " was " + duration + " ms.");
		
		return result;
	}
	
}
