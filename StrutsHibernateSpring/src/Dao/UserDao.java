package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import DBConn.HibernateSessionFactory;
import user.UserInfoPO;

public class UserDao {
	/*
	 * userDao与数据库交互的类
	 * 每个对象的Dao中通过HibernateFactory的静态方法getSession
	 * 来获取一个session对象从而完成对数据库的增删改查操作
	 */
	private Session session;
	private Transaction transaction;
	
	/*
	 * 存入操作，在之后可以将所有PO都归类实现一个接口，则在这里的参数可以直接写成一个接口，
	 * 然后再把Dao类归类成一个标准的类，包含增删改查方法,让所有的Dao来继承这个类
	 */
	public boolean saveInfo(UserInfoPO userinfo){
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();   //事务的使用
			session.save(userinfo);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception e){
			System.out.println("Save fail！！！"+e);
			return false;
		}		
	}
	//public List find(){}
	//public boolean update(){};
	//public boolean delete(){};
}
