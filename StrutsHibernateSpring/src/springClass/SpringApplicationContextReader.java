package springClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextReader {
	private static ApplicationContext context;
	
	//��̬��ʼ�������ڹ��̼��ص�ʱ��;Ͷ�ȡ�����ļ�������һ��ApplicationContext����
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
