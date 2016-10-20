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
	 * �û��ӵ�½ҳ���½������½�ɹ�������û���Ϣҳ�棨personalIndex����ҳ������ʾ�û�����ϸ��Ϣ�Լ��û����������±��⼰д��ʱ�䡣
	 * ������½�ɹ�����Ҫ��ѯ�û�����ϸ��Ϣ���Լ�����������Ϣ��
	 */
	private List<BlogBriefInfo> blogBriefInfoList = new ArrayList<BlogBriefInfo>();  //���±���ʱ�����
	private UserDetailInfo userDetailInfo = new UserDetailInfo();  //�û���ϸ��Ϣ
	private UserInfo user = new UserInfo();   //����ҳ�������û���������
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
		 * ��¼ҳ�������û������룬��userInfo������գ�Ȼ����û��������������֤����֤�ɹ���ѯ���û�����ϸ��Ϣ��ŵ�UserDetailInfo������
		 * ͬʱ��ѯ���û��������Ѿ���������µı����Լ�����ʱ�䣬����ŵ�blogBriefInfoList�з���ҳ��������ʾ
		 */
		System.out.println("���ص�id==========================="+arid);
		UserInfoValid userValid = new UserInfoValid(user.getUserName(), user.getPassword());
		if(userValid.doLoginValid()){
			System.out.println("===========�����֤�ɹ�");
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
