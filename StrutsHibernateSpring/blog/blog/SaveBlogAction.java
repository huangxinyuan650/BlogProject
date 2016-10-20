package blog;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DBConn.HibernateSessionFactory;

public class SaveBlogAction extends ActionSupport{


	private static final long serialVersionUID = 1L;
	private String editArea;
	private String articalTitle;
	
	public String getArticalTitle() {
		return articalTitle;
	}

	public void setArticalTitle(String articalTitle) {
		this.articalTitle = articalTitle;
	}

	public String getEditArea() {
		return editArea;
	}

	public void setEditArea(String editArea) {
		this.editArea = editArea;
	}

	public String execute() throws Exception{
		/*
		 * 保存页面的文章，连同作者也就是登录的会员的信息一同获取
		 */
		//获取session中的当前用户名
		String author = (String)ActionContext.getContext().getSession().get("userName");
		System.out.println("=========="+getEditArea());
		System.out.println("=========="+getArticalTitle());
		author = "huangxinyuan";
		BlogInfo bi = new BlogInfo();
		bi.setAuthor(author);
		bi.setWriteTime(new Date());
		//new WriteBlog(getEditArea(), author).doWrite();
		bi.setContextPath(new WriteBlog(getEditArea(), author).doWrite());
		if(saveBlog(bi)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	protected boolean saveBlog(BlogInfo blogInfo){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(blogInfo);
		transaction.commit();
		session.close();
		return true;
	}
}
