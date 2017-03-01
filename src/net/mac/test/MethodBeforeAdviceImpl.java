package net.mac.test;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

//aopalliance-1.0.jar - The hierarchy of the type MethodBeforeAdviceImpl is inconsistent
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("运行前检查......");	
		System.out.println("Method: " + arg0.getName());
		System.out.println("Args: " + Arrays.asList(arg1));
		System.out.println("Object: " + arg2);
	}
}
