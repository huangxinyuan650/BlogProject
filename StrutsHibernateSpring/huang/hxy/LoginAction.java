package hxy;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		if(getUserName().equals("huang")&&getPassword().equals("123")){
			return "success";
		}else{
			return "error";
		}
	}
}
