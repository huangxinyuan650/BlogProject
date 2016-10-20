package blog;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DBConn.HibernateSessionFactory;

public class ArticalOperate {
	private Session session;
	private ArticalPO artical;
	
	//�޲εĹ��캯����Ϊ���µĸ��²���
	public ArticalOperate(){
	}
	//����������Ϣ�Ĳ����Ĺ��췽��ʱ���������
	public ArticalOperate(ArticalPO artical){
		this.artical = artical;
	}
	
	public int saveArtical(){
		session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(artical);
		Query query = session.createQuery("from ArticalPO a where a.articalPath=?");
		query.setString(0, artical.getArticalPath());
		transaction.commit();
		@SuppressWarnings("unchecked")
		List<ArticalPO> list = query.list();
		if(list.size()>0){
			return list.get(0).getId();
		}else{
			return -1;
		}
	}
	
	//ɾ��idΪid������
	public String deleteArtical(int id){
		session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		ArticalPO ap = (ArticalPO)session.get(ArticalPO.class, id);
		if(ap==null){
			transaction.commit();
			session.close();
			return "error";
		}else{
			session.delete(ap);
			transaction.commit();
			session.close();
			return "success";
		}
	}
}
