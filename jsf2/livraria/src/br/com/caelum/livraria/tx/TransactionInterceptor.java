package br.com.caelum.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;
	
	@AroundInvoke
	public Object runTX(InvocationContext context) throws Exception {
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Object result = context.proceed();
		
		tx.commit();
		
		return result;
	}

}
