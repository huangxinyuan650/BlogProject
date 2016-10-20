package DBConn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	/*
	 * ��Configuration������ȡhibernate�������ļ�������sessionfactory���󣬶��Ǿ�̬�����������ع��̵�ʱ��ͻ�ִ��
	 */
	
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	public HibernateSessionFactory(){		
	}
	
	//��PO����ֱ�ӵ���Hibernatefactory�ľ�̬����getSession�Ϳ��Եõ�һ��hibernate��һ��session��������ɶ����ݿ�Ĳ���
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
