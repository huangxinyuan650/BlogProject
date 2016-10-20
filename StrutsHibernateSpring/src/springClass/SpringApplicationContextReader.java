package springClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextReader {
	private static ApplicationContext context;
	
	//静态初始化器，在工程加载的时候就就读取配置文件，生成一个ApplicationContext对象
	static{
		setContext(new ClassPathXmlApplicationContext("ApplicationContext.xml"));
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	public static void setContext(ApplicationContext context) {
		SpringApplicationContextReader.context = context;
	}
}
