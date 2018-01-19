package com.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUtils implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException{
		ApplicationUtils.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}
	
	public static <T> Object getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}
	
	public static <T> Object getBean(String name,Class<T> clazz){
		return applicationContext.getBean(name, clazz);
	}
	
	public static String getProperties(String name){
		return getApplicationContext().getEnvironment().getProperty(name);
	}
}
