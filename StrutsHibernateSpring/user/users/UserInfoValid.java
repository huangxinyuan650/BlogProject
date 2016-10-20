package users;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DBConn.HibernateSessionFactory;

public class UserInfoValid {
	private UserInfo userInfo;
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfoValid(UserInfo userInfo){
		setUserInfo(userInfo);
	}
	
	//对传进来的用户信息进行验证，根据验证结果返回一个布尔值
	public boolean doValid(){
		Session session = HibernateSessionFactory.getSession();
		String sqlCmd = "select id,role from userinfo where username='"+userInfo.getUserName()+"';";
		Transaction t = session.beginTransaction();
		Query query = session.createSQLQuery(sqlCmd);
		List list = query.list();
		t.commit();
		if(list.isEmpty()){
			return false;
		}else{
//			Iterator it = list.iterator();
//			while(it.hasNext()){
//				Map map = (Map)it.next();
//			}
			System.out.println("============="+list.size());
			return true;
		}
	}
}
