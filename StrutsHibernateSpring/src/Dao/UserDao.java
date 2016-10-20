package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import DBConn.HibernateSessionFactory;
import user.UserInfoPO;

public class UserDao {
	/*
	 * userDao�����ݿ⽻������
	 * ÿ�������Dao��ͨ��HibernateFactory�ľ�̬����getSession
	 * ����ȡһ��session����Ӷ���ɶ����ݿ����ɾ�Ĳ����
	 */
	private Session session;
	private Transaction transaction;
	
	/*
	 * �����������֮����Խ�����PO������ʵ��һ���ӿڣ���������Ĳ�������ֱ��д��һ���ӿڣ�
	 * Ȼ���ٰ�Dao������һ����׼���࣬������ɾ�Ĳ鷽��,�����е�Dao���̳������
	 */
	public boolean saveInfo(UserInfoPO userinfo){
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();   //�����ʹ��
			session.save(userinfo);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception e){
			System.out.println("Save fail������"+e);
			return false;
		}		
	}
	//public List find(){}
	//public boolean update(){};
	//public boolean delete(){};
}
