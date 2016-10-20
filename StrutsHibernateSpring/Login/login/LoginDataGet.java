package login;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DBConn.HibernateSessionFactory;
import blog.BlogBriefInfo;
import blog.BlogInfo;
import users.UserDetailInfo;

public class LoginDataGet {
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LoginDataGet(String userName){
		setUserName(userName);
	}
	
	public UserDetailInfo getUserDetailInfo(){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from UserDetailInfo u where u.userName =?");
		query.setString(0, userName);
		List userDetailList = query.list();
		transaction.commit();
		if(!userDetailList.isEmpty()){
			UserDetailInfo userDetail = (UserDetailInfo)userDetailList.get(0);
			System.out.println("用户详细信息查询结果id========="+userDetail.getId());
			return userDetail;
		}else{
			return null;
		}
	}
	
	public List<BlogBriefInfo> getBlogBriefList(){
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from BlogInfo b where b.author =?");
		query.setString(0, userName);
		List blogInfoList = query.list();
		transaction.commit();
		if(!blogInfoList.isEmpty()){
			System.out.println("文章标题查询结果============="+blogInfoList.size());
			List<BlogBriefInfo> blogBriefInfoList = new ArrayList<BlogBriefInfo>();
			Iterator it = blogInfoList.iterator();
			while(it.hasNext()){
				BlogBriefInfo temp = new BlogBriefInfo();
				BlogInfo blogInfo = (BlogInfo)it.next();
				temp.setId(blogInfo.getId());
				temp.setBlogTitle(blogInfo.getTitle());
				temp.setWriteTime(blogInfo.getWriteTime());
				blogBriefInfoList.add(temp);
			}
			System.out.println("文章标题转存结果============="+blogBriefInfoList.size());
			return blogBriefInfoList;
		}else{
			return null;
		}
	}
	
}
