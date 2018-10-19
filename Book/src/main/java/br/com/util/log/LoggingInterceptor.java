package br.com.util.log;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggingInterceptor {

	@Inject
	private Logger logger;
	
	@AroundConstruct
	private void init(InvocationContext invocationContext) throws Exception {
		logger.fine("Entrando no construtor");
		try {
			invocationContext.proceed();
		} finally {
			logger.fine("Saindo do construtor");
		}
	}
	
	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception {
	   logger.fine("Entrando no método interceptador");
		logger.entering(ic.getTarget().toString(), ic.getMethod().toString());
		try {
			return ic.proceed();
		} finally {
		   logger.fine("Saindo no método interceptador");
		   logger.exiting(ic.getTarget().toString(), ic.getMethod().toString());
		}
	}
}
