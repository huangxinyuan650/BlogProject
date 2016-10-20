package login;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DBConn.HibernateSessionFactory;
import PO.UserPO;

public class UserInfoValid {
	private String userName;
	private String password;
	private Session session;
	private Transaction transaction;
	public UserInfoValid(String userName,String password){
		this.userName = userName;
		this.password = password;
		System.out.println("----------"+userName+"  "+password);
	}
	
	public boolean doRegisterValid(){
		System.out.println("对数据库进行操作");
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from UserPO u where u.userName=?");
		query.setString(0, userName);
		List list = query.list();	
		transaction.commit();
		System.out.println("============"+list.size());
		if(list.size()>0){
			return false;
		}else{
			UserPO user = new UserPO();
			user.setUserName(userName);
			user.setPassword(password);
			user.setRole("member");
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			return true;
		}		
	}
	
	public boolean doLoginValid(){
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		System.out.println("已进入到数据库的操作步骤");
		Query query = session.createQuery("from UserPO u where u.userName=? and u.password=?");
		query.setString(0, this.userName);
		query.setString(1, this.password);
		System.out.println("属性值输入完成");
		List list = query.list();
		System.out.println("查询完成");
		transaction.commit();
		System.out.println("================"+list.size());
		if(list.size()>0){
			System.out.println("==============="+((UserPO)list.get(0)).getId());
			return true;
		}else{
			return false;
		}
	}
}
