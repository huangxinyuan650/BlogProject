package user;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;

import DBConn.HibernateSessionFactory;
import springClass.SpringApplicationContextReader;
import user.UserInfo;

public class SpringAppReader {
	public static void main(String []args){
		System.out.println("==========start");
		ApplicationContext context = SpringApplicationContextReader.getContext();
		UserInfo userInfo = (UserInfo)context.getBean("userInfo");
		userInfo.setId(2650);
		userInfo.setUserName("huangxinyuan");
		userInfo.setPassword("huang");
		System.out.println("==============="+userInfo.getUserName());
		HibernateSessionFactory hibernate = (HibernateSessionFactory) context.getBean("hibernateSessionFactory");
		Session session = hibernate.getSession();
	}
}
