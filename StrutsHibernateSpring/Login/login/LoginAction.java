package login;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import blog.BlogAuthorInfo;
import blog.BlogBriefInfo;
import blog.BlogContent;
import blog.BlogInfo;
import critic.CriticInfo;
import user.UserInfo;
import users.UserDetailInfo;

public class LoginAction implements Action{
	/*
	 * 用户从登陆页面登陆，当登陆成功后进入用户信息页面（personalIndex），页面中显示用户的详细信息以及用户的所有文章标题及写作时间。
	 * 即当登陆成功后，需要查询用户的详细信息，以及所有文章信息。
	 */
	private List<BlogBriefInfo> blogBriefInfoList = new ArrayList<BlogBriefInfo>();  //文章标题时间表列
	private UserDetailInfo userDetailInfo = new UserDetailInfo();  //用户详细信息
	private UserInfo user = new UserInfo();   //接收页面出入的用户名和密码
	private String arid;

	public String getArid() {
		return arid;
	}

	public void setArid(String arid) {
		this.arid = arid;
	}

	public List<BlogBriefInfo> getBlogBriefInfoList() {
		return blogBriefInfoList;
	}

	public void setBlogBriefInfoList(List<BlogBriefInfo> blogBriefInfoList) {
		this.blogBriefInfoList = blogBriefInfoList;
	}
	
	public UserDetailInfo getUserDetailInfo() {
		return userDetailInfo;
	}

	public void setUserDetailInfo(UserDetailInfo userDetailInfo) {
		this.userDetailInfo = userDetailInfo;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		/*
		 * 登录页面输入用户名密码，用userInfo对象接收，然后对用户名和密码进行验证，验证成功查询该用户的详细信息存放到UserDetailInfo对象中
		 * 同时查询该用户的所有已经发表的文章的标题以及发表时间，并存放到blogBriefInfoList中返回页面用于显示
		 */
		System.out.println("隐藏的id==========================="+arid);
		UserInfoValid userValid = new UserInfoValid(user.getUserName(), user.getPassword());
		if(userValid.doLoginValid()){
			System.out.println("===========身份验证成功");
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("userName", user.getUserName());
//			ac.getSession().put("password", user.getPassword());
			LoginDataGet loginDataGet = new LoginDataGet(user.getUserName());
			userDetailInfo = loginDataGet.getUserDetailInfo();
			blogBriefInfoList = loginDataGet.getBlogBriefList();
			return "success";
		}else{
			return "error";
		}
	}
	

}
