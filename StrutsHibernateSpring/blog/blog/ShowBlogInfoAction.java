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
	 * 用来获取文章的id并根据id查询得到文章详情以及文章的评论情况，之后将查询得到的信息返回显示到文章详情页面
	 */
	private int blogId;  //从前端传入到后台的文章id
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("获取页面传入的文章id======================"+blogId);
		//已经获取了文章信息对象，现在需要获取对象中的文章路径来读取文章的真实内容
		BlogInfo blogInfo = queryBlog(getBlogId());
		String blogContext = new ReadBlog(blogInfo.getContextPath()).readBlogDetail();   //读取了文章的内容准备返回到文章详情页面
		List criticList = queryCritics();   //获取了文章的评论表列
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("author", blogInfo.getAuthor());
		request.setAttribute("writeTime", blogInfo.getWriteTime());
		request.setAttribute("blogId", blogInfo.getId());
		request.setAttribute("blogContext", blogContext);
		request.setAttribute("critics", criticList);
		return SUCCESS;
	}
	
	//有关文章评论的查询
	protected List queryCritics(){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from CriticInfo c where c.blogId=?");
		query.setInteger(0, blogId);
		List criticList = query.list();
		transaction.commit();
		return criticList;
	}
	

	//文章信息内容的查询
	protected BlogInfo queryBlog(int blogId){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		BlogInfo blogInfo = (BlogInfo)session.get(BlogInfo.class, blogId);
		transaction.commit();
		return blogInfo;
	}

}
