package util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringUtil {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	
	public static ApplicationContext getApplicationContext() {
		return context;
	}
	public static Object getBean(String name) throws BeansException {
		  return context.getBean(name);
	}
}
