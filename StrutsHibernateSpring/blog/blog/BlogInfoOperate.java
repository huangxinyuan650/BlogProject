package blog;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DBConn.HibernateSessionFactory;

public class BlogInfoOperate {
	private Session session;
	private Transaction transaction;
		
	//����������Ϣ
	public boolean saveBlogInfo(BlogInfo blog){
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.save(blog);
		transaction.commit();
		session.close();
		return true;
	}
	
	//ɾ��������Ϣ
	public boolean deleteBlogInfo(int blogId){
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from BlogInfo b where b.id=?");
		query.setInteger(0, blogId);
		List list = query.list();
		if(list.size()>0){
//			BlogInfo bi = (BlogInfo)list.get(0);
			session.delete((BlogInfo)list.get(0));
			session.close();
			return true;
		}else{
			return false;
		}
	}
	
	//�޸�������Ϣ
	public boolean updateBlogInfo(BlogInfo blog){
		session = HibernateSessionFactory.getSession();
//		session.createSQLQuery("")
		transaction = session.beginTransaction();
		session.update(blog);
		transaction.commit();
		session.close();
		return true;
	}
	
	//��ѯ������Ϣ
	public List queryBlogInfo(){
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from BlogInfo");
		List list = query.list();
		transaction.commit();
		return list;
	}
}
