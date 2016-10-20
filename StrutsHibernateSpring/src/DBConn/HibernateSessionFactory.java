package DBConn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	/*
	 * 用Configuration类来读取hibernate的配置文件并生成sessionfactory对象，都是静态方法，即加载工程的时候就会执行
	 */
	
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	public HibernateSessionFactory(){		
	}
	
	//在PO类中直接调用Hibernatefactory的静态方法getSession就可以得到一个hibernate的一个session对象来完成对数据库的操作
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateSessionFactory.sessionFactory = sessionFactory;
	}

	static{
		try{
			configuration = new Configuration().configure("hibernate.cfg.xml");
			setSessionFactory(configuration.buildSessionFactory());			
		}catch(Exception e){
			System.out.println("SessionFactory get fail!!!"+e);
		}
	}
}
