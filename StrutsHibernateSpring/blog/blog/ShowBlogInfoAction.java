package blog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import DBConn.HibernateSessionFactory;

public class ShowBlogInfoAction implements Action{

	/*
	 * ������ȡ���µ�id������id��ѯ�õ����������Լ����µ����������֮�󽫲�ѯ�õ�����Ϣ������ʾ����������ҳ��
	 */
	private int blogId;  //��ǰ�˴��뵽��̨������id
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("��ȡҳ�洫�������id======================"+blogId);
		//�Ѿ���ȡ��������Ϣ����������Ҫ��ȡ�����е�����·������ȡ���µ���ʵ����
		BlogInfo blogInfo = queryBlog(getBlogId());
		String blogContext = new ReadBlog(blogInfo.getContextPath()).readBlogDetail();   //��ȡ�����µ�����׼�����ص���������ҳ��
		List criticList = queryCritics();   //��ȡ�����µ����۱���
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("author", blogInfo.getAuthor());
		request.setAttribute("writeTime", blogInfo.getWriteTime());
		request.setAttribute("blogId", blogInfo.getId());
		request.setAttribute("blogContext", blogContext);
		request.setAttribute("critics", criticList);
		return SUCCESS;
	}
	
	//�й��������۵Ĳ�ѯ
	protected List queryCritics(){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from CriticInfo c where c.blogId=?");
		query.setInteger(0, blogId);
		List criticList = query.list();
		transaction.commit();
		return criticList;
	}
	

	//������Ϣ���ݵĲ�ѯ
	protected BlogInfo queryBlog(int blogId){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		BlogInfo blogInfo = (BlogInfo)session.get(BlogInfo.class, blogId);
		transaction.commit();
		return blogInfo;
	}

}
